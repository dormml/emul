/*
  FastTimer.java

  (c) 2010-2016 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package ejs.base.timer;


import com.vladium.utils.timing.HRTimer;
import com.vladium.utils.timing.ITimer;
import com.vladium.utils.timing.TimerFactory;

import ejs.base.utils.ListenerList;


/**
 * This is a timer thread which makes use of a high-resolution system timer
 * to provide predictable numbers of interrupts for a given task.  
 * In a consistently loaded system, the timing should be predictable as
 * well. 
 * @author Ed
 *
 */
public class FastTimer {
	private ITimer timer;
	private ListenerList<Runnable> invokes;
	private ListenerList<RunnableInfo> taskinfos;
	private Object controlLock;
	private Thread timerThread;
	private String name;
	private static int gCnt;
	
	static final long NS = 1000000 * 1000L;
	static boolean DEBUG = false;
	
	
	class RunnableInfo {
		public RunnableInfo(Runnable task, long delay) {
			super();
			this.task = task;
			this.delay = delay;
			this.deadline = timer.getTimeNs() + this.delay;
		}
		Runnable task;
		/** ns */
		long deadline;
		/** ns */
		long delay;
	}
	
	public FastTimer(String name) {
		this.name = name;
		taskinfos = new ListenerList<RunnableInfo>();
		invokes = new ListenerList<Runnable>();
		timer = TimerFactory.newTimer();
		controlLock = new Object();
	}
	
	/**
	 * 
	 */
	public FastTimer() {
		this("" + gCnt++);
	}
	
	/**
	 * Schedule a task to occur the given number of times per second.
	 * @param task
	 * @param perSecond
	 */
	public void scheduleTask(Runnable task, long perSecond) {
		synchronized (controlLock) {
			for (RunnableInfo info : taskinfos)
				if (info.task == task)
					return;
			
			if (perSecond != 0) {
				RunnableInfo info = new RunnableInfo(task, NS / perSecond);
				taskinfos.add(info);
			
				if (timerThread == null)
					startTimer();
			}
		}
	}

	private void startTimer() {
		timerThread = new Thread("FastTimer [" + name + "]") {
			@Override
			public void run() {
				int iterations = 0;
				
				long nsstart = timer.getTimeNs();
				long nextns = nsstart + NS;
				
				if (timer instanceof HRTimer) {
					System.out.println("Minimum resolution is: " + HRTimer.getMinimumTimerResolution());
					HRTimer.timeBeginPeriod(10);
				}
				try {
					//long prev = timer.getTimeNs();
					//double prevd = timer.getTimeDouble();
					while (true) {
						if (timerThread == null)
							break;
						try {
							Thread.sleep(0, 50000);
						} catch (InterruptedException e) {
							return;
						}
						
						Object[] infos;
						synchronized (controlLock) {
							//System.out.println(now);
							//long elapsed = now - prev;
							//System.out.print(elapsed + ",");
	
							infos = invokes.toArray();
							invokes.clear();
						}
						for (Object info : infos) {
							try {
								((Runnable) info).run();
							} catch (Throwable t) {
								t.printStackTrace();
							}
						}
						
						final long now = timer.getTimeNs();
						synchronized (controlLock) {
							//System.out.println(now);
							//long elapsed = now - prev;
							//System.out.print(elapsed + ",");
	
							infos = taskinfos.toArray();
						}

						for (Object infoObj : infos) {
							FastTimer.RunnableInfo info = (FastTimer.RunnableInfo) infoObj;
							try {
								if (now >= info.deadline) {
									//System.out.println("moving from " + info.deadline + " by " + info.delay + " to " + (info.delay + info.deadline));
									if (now - info.deadline > info.delay * 10) {
										// too much delay (suspended process, etc)
										info.deadline = now + info.delay;
										info.task.run();
									} else {
										while (now >= info.deadline) {
											info.deadline += info.delay;
											info.task.run();
										}
									}
								}
								else if ((now ^ info.deadline) < 0) {
									// clock overflowed
									info.deadline = now + info.delay;
									info.task.run();
								}									
							} catch (Throwable t) {
								t.printStackTrace();
								info.deadline = -1;
							}
							//prev = now;
						}
						
						iterations++;
						if (DEBUG && now >= nextns) {
							double elapsed = (now - nsstart) / (double) NS;
							System.out.println("timer profiling: " + iterations + " iterations in " + 
										elapsed + " seconds = " + (iterations / elapsed) + " ns per iteration");
							nextns += NS;
						}
								
					}
				} finally {
					if (timer instanceof HRTimer) {
						HRTimer.timeEndPeriod(10);
					}
				}
			}
		};
		timerThread.setDaemon(true);
		timerThread.setPriority(Thread.MAX_PRIORITY);
		timerThread.start();		
	}
	
	public void cancel() {
		synchronized (controlLock) {
			if (timerThread != null) {
				timerThread.interrupt();
				taskinfos.clear();
				timerThread = null;
			}
		}
	}

	public void cancelTask(Runnable runnable) {
		synchronized (controlLock) {
			for (Object o : taskinfos.toArray()) {
				if (((RunnableInfo) o).task == runnable) {
					taskinfos.remove((RunnableInfo) o);
					//break;
				}
			}
		}		
	}

	/**
	 * Invoke a runnable as soon as possible
	 * @param runnable
	 */
	public void invoke(Runnable runnable) {
		synchronized (controlLock) {
			invokes.add(runnable);
			if (timerThread == null)
				startTimer();
		}
		
	}
}
