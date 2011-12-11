/**
 * 
 */
package v9t9.server.tcf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.tm.tcf.protocol.IToken;
import org.eclipse.tm.tcf.protocol.Protocol;
import org.eclipse.tm.tcf.services.IMemory;
import org.eclipse.tm.tcf.services.IMemory.DoneGetContext;
import org.eclipse.tm.tcf.services.IMemory.MemoryContext;
import org.eclipse.tm.tcf.services.IMemory.MemoryError;
import org.junit.Before;
import org.junit.Test;

import v9t9.base.utils.Pair;
import v9t9.common.memory.IMemoryDomain;
import v9t9.server.tcf.services.IMemoryV2;
import v9t9.server.tcf.services.IMemoryV2.MemoryChange;

/**
 * @author ejs
 *
 */
public class TestTCFMemory extends BaseTCFTest {

	private IMemory mem;
	private IMemoryV2 memV2;
	
	@Before
	public void getServices() {
		mem = (IMemory) getService(IMemory.NAME);
		memV2 = (IMemoryV2) getService(IMemoryV2.NAME);
	}
	
	@Test
	public void testGetRootChildren() throws Throwable {
		for (final String parent : new String[] { "", "root", null }) {
			new TCFCommandWrapper() {
				public IToken run() throws Exception {
					return mem.getChildren(parent, new IMemory.DoneGetChildren() {
						
						/* (non-Javadoc)
						 * @see org.eclipse.tm.tcf.services.IMemory.DoneGetChildren#doneGetChildren(org.eclipse.tm.tcf.protocol.IToken, java.lang.Exception, java.lang.String[])
						 */
						@Override
						public void doneGetChildren(IToken token, Exception error,
								String[] context_ids) {
							try {
								assertNoError(error);
								
								assertEquals(4, context_ids.length);
								List<String> kids = Arrays.asList(context_ids);
								assertTrue(kids.contains(IMemoryDomain.NAME_CPU));
								assertTrue(kids.contains(IMemoryDomain.NAME_GRAPHICS));
								assertTrue(kids.contains(IMemoryDomain.NAME_SPEECH));
								assertTrue(kids.contains(IMemoryDomain.NAME_VIDEO));
							} catch (Throwable t) {
								excs[0] = t;
							} finally {
								tcfDone();
							}
						}
					});
				}
			};
		};
		
	}
	
	@Test
	public void testGetContextErrors() throws Throwable {
		new TCFCommandWrapper() {
			public IToken run() throws Exception {
				return mem.getContext("root", new IMemory.DoneGetContext() {
					
					@Override
					public void doneGetContext(IToken token, Exception error,
							MemoryContext context) {
						try {
							assertNotNull("expected error", error);
						} catch (Throwable t) {
							excs[0] = t;
						} finally {
							tcfDone();
						}
					}
				});
			}
		};
		new TCFCommandWrapper() {
			public IToken run() throws Exception {
				return mem.getContext("", new IMemory.DoneGetContext() {
					
					@Override
					public void doneGetContext(IToken token, Exception error,
							MemoryContext context) {
						try {
							assertNotNull("expected error", error);
						} catch (Throwable t) {
							excs[0] = t;
						} finally {
							tcfDone();
						}
					}
				});
			}
		};
		
		new TCFCommandWrapper() {
			public IToken run() throws Exception {
				return mem.getContext(null, new IMemory.DoneGetContext() {
					
					@Override
					public void doneGetContext(IToken token, Exception error,
							MemoryContext context) {
						try {
							assertNotNull("expected error", error);
						} catch (Throwable t) {
							excs[0] = t;
						} finally {
							tcfDone();
						}
					}
				});
			}
		};
		
	}
	@Test
	public void testGetContexts() throws Throwable {
		new TCFCommandWrapper() {
			public IToken run() throws Exception {
				return mem.getContext(IMemoryDomain.NAME_CPU, new IMemory.DoneGetContext() {
					
					@Override
					public void doneGetContext(IToken token, Exception error,
							MemoryContext context) {
						try {
							assertNoError(error);
							
							assertEquals(0, context.getStartBound());
							assertEquals(65536, context.getEndBound());
							assertEquals(IMemoryDomain.NAME_CPU, context.getID());
							assertEquals("Console", context.getName());
						} catch (Throwable t) {
							excs[0] = t;
						} finally {
							tcfDone();
						}
					}
				});
			}
		};
		new TCFCommandWrapper() {
			public IToken run() throws Exception {
				return mem.getContext(IMemoryDomain.NAME_VIDEO, new IMemory.DoneGetContext() {
					
					@Override
					public void doneGetContext(IToken token, Exception error,
							MemoryContext context) {
						try {
							assertNoError(error);
							
							assertEquals(0, context.getStartBound());
							assertTrue(context.getEndBound().intValue() > 0);
							assertEquals(IMemoryDomain.NAME_VIDEO, context.getID());
							assertEquals("VDP", context.getName());
						} catch (Throwable t) {
							excs[0] = t;
						} finally {
							tcfDone();
						}
					}
				});
			}
		};
		
		new TCFCommandWrapper() {
			public IToken run() throws Exception {
				return mem.getContext(IMemoryDomain.NAME_GRAPHICS, new IMemory.DoneGetContext() {
					
					@Override
					public void doneGetContext(IToken token, Exception error,
							MemoryContext context) {
						try {
							assertNoError(error);
							
							assertEquals(0, context.getStartBound());
							assertTrue(context.getEndBound().intValue() > 0);
							assertEquals(IMemoryDomain.NAME_GRAPHICS, context.getID());
							assertEquals("GROM/GRAM", context.getName());
						} catch (Throwable t) {
							excs[0] = t;
						} finally {
							tcfDone();
						}
					}
				});
			}
		};
		
		new TCFCommandWrapper() {
			public IToken run() throws Exception {
				return mem.getContext(IMemoryDomain.NAME_SPEECH, new IMemory.DoneGetContext() {
					
					@Override
					public void doneGetContext(IToken token, Exception error,
							MemoryContext context) {
						try {
							assertNoError(error);
							
							assertEquals(0, context.getStartBound());
							assertTrue(context.getEndBound().intValue() > 0);
							assertEquals(IMemoryDomain.NAME_SPEECH, context.getID());
							assertEquals("Speech", context.getName());
						} catch (Throwable t) {
							excs[0] = t;
						} finally {
							tcfDone();
						}
					}
				});
			}
		};
	}
	

	@Test
	public void testMemoryNotifySimple() throws Throwable {
		// start...
		final int DELAY = 100;
		int memMode = 0;
		final List<Pair<String, MemoryChange[]>> changeMap = new ArrayList<Pair<String, MemoryChange[]>>();
		final IMemoryV2.MemoryContentChangeListener listener = new IMemoryV2.MemoryContentChangeListener() {

			@Override
			public void contentChanged(String contextId, MemoryChange[] change) {
				changeMap.add(new Pair<String, MemoryChange[]>(contextId,
						change));
			}
		};

		doVideoMemWrite(memMode, DELAY, listener, "HELLO");
		
		assertTrue("expected event", !changeMap.isEmpty());
		
		// expect only one change and one range
		assertEquals(1, changeMap.size());
		assertEquals(IMemoryDomain.NAME_VIDEO, changeMap.get(0).first);
		
		MemoryChange[] changes = changeMap.get(0).second;
		assertNotNull(changes);
		assertEquals(1, changes.length);
		
		MemoryChange change = changes[0];
		assertEquals(0, change.addr);
		assertEquals(5, change.size);
		assertTrue(new String(change.data), Arrays.equals("HELLO".getBytes(), change.data));
	}
	

	@Test
	public void testMemoryNoNotifySimple() throws Throwable {
		final int DELAY = 100;
		final int memMode = IMemoryV2.MODE_FLAT;		// no events should be generated

		final List<Pair<String, MemoryChange[]>> changeMap = new ArrayList<Pair<String, MemoryChange[]>>();
		final IMemoryV2.MemoryContentChangeListener listener = new IMemoryV2.MemoryContentChangeListener() {

			@Override
			public void contentChanged(String contextId, MemoryChange[] change) {
				changeMap.add(new Pair<String, MemoryChange[]>(contextId,
						change));
			}
		};

		
		doVideoMemWrite(memMode, DELAY, listener, "blargh");
		
		assertTrue("expected no events: " + changeMap, changeMap.isEmpty());
	}

	protected void doVideoMemWrite(final int memMode, final int delay,
			final IMemoryV2.MemoryContentChangeListener listener,
			final String data)
			throws Throwable {
		doVideoMemWrite(memMode, delay, 1, listener, data.getBytes(), 0, data.length(), 0, 0);	
	}
	
	/**
	 * @param memMode
	 * @param delay
	 * @param granularity 
	 * @param listener
	 * @param method 
	 * @throws Throwable
	 */
	protected void doVideoMemWrite(final int memMode, final int delay,
			final int granularity, 
			final IMemoryV2.MemoryContentChangeListener listener, final byte[] data, int addr,
			int size, final int skip, final int skipLength)
			throws Throwable {
		Protocol.invokeAndWait(new Runnable() {
			public void run() {
				memV2.addListener(listener);
			}
		});
		
		try {
			new TCFCommandWrapper() {
				public IToken run() throws Exception {
					return memV2.startChangeNotify(IMemoryDomain.NAME_VIDEO, delay, granularity,
						new IMemoryV2.DoneCommand() {
							
							@Override
							public void done(Exception error) {
								try {
									assertNoError(error);
								} catch (Throwable t) {
									excs[0] = t;
								} finally {
									tcfDone();
								}								
							}
					});
				}		
			};
			
			final IMemory.MemoryContext[] videos = { null };
			new TCFCommandWrapper() {
				public IToken run() throws Exception {
					return mem.getContext(IMemoryDomain.NAME_VIDEO, new DoneGetContext() {
						@Override
						public void doneGetContext(IToken token, Exception error,
							MemoryContext context) {
							try {
								assertNoError(error);
								videos[0] = context;
							} catch (Throwable t) {
								excs[0] = t;
							} finally {
								tcfDone();
							}								
						}
					});
				}		
			};
			
			final boolean[] finished = { true };
			final Set<IToken> waiting = new HashSet<IToken>();
			
			final IMemory.DoneMemory done = new IMemory.DoneMemory() {
	
				@Override
				public void doneMemory(IToken token, MemoryError error) {
					assertNoError(error);
	
					synchronized (waiting) {
						waiting.remove(token);
						if (waiting.isEmpty())
							finished[0] = true;
					}
				}
			};
			
			int idx = 0;
			int end = addr + size;
			while (addr < end) {
				if (idx >= data.length)
					idx = 0;
				
				final int theAddr = addr;
				final int theIdx = idx;
				int toUse;
				
				toUse = Math.min(end - addr, Math.min(data.length - idx, size - idx));
				if (skip > 0)
					toUse = Math.min(skip, toUse);
				
				final int toUse_ = toUse;
				
				System.out.println("set: " + theAddr + "+" + toUse + " @ " + theIdx);
				new TCFCommandWrapper() {
					public IToken run() throws Exception {
						IToken token = videos[0].set(Integer.valueOf(theAddr), 1, data, theIdx, toUse_, memMode, done);
						synchronized (waiting) {
							waiting.add(token);
						}
						tcfDone();
						return token;
					}		
				};
				
				addr += toUse;
				idx += toUse;
				if (skip > 0) {
					if (toUse < skip) {
						// use more next time
						idx = 0;
					} else {
						addr += skipLength;
					}
				} else {
					if (toUse < size)
						idx = 0;
				}
			}
			
			long timeout = System.currentTimeMillis() + 10 * 1000;
			while (!finished[0]) {
				if (System.currentTimeMillis() > timeout)
					fail("timed out waiting for memory writes");
				Thread.sleep(500);
			}
			
			new TCFCommandWrapper() {
				public IToken run() throws Exception {
					return memV2.stopChangeNotify(IMemoryDomain.NAME_VIDEO, 
						new IMemoryV2.DoneCommand() {
							
							@Override
							public void done(Exception error) {
								try {
									assertNoError(error);
								} catch (Throwable t) {
									excs[0] = t;
								} finally {
									tcfDone();
								}								
							}
					});
				}		
			};
			
			
			// await the event
			Thread.sleep(delay * 5);
		} finally {
			Protocol.invokeAndWait(new Runnable() {
				public void run() {
					memV2.removeListener(listener);
				}
			});
		}
	}
	

	/**
	 * @param changeMap
	 * @param i
	 * @param j
	 */
	private void validateRanges(String expDomain,
			byte[] data, int addr, int size,
			int skip, int skipLength, 
			List<Pair<String, MemoryChange[]>> changeMap) {
	
		// ensure the pairs are all contiguous
		for (Pair<String, MemoryChange[]> ent : changeMap) {
			Arrays.sort(ent.second, new Comparator<MemoryChange>() {
	
				@Override
				public int compare(MemoryChange o1, MemoryChange o2) {
					return o1.addr.intValue() - o2.addr.intValue();
				}
				
			});
	
		}
		
		// ensure each piece is in order
		Collections.sort(changeMap, new Comparator<Pair<String, MemoryChange[]>>() {
	
			@Override
			public int compare(Pair<String, MemoryChange[]> o1,
					Pair<String, MemoryChange[]> o2) {
				return o1.second[0].addr.intValue() - o2.second[0].addr.intValue();
			}
			
		});
		int end = addr + size;
		int idx = 0;
		for (Pair<String, MemoryChange[]> ent : changeMap) {
			assertEquals(expDomain, ent.first);
			for (MemoryChange change : ent.second) {
				
				assertEquals(addr, change.addr);
				assertEquals(change.toString(), skip > 0 ? Math.min(end - addr, skip) : end - addr, change.size);
				assertEquals(change.toString(), change.size, change.data.length);
				
				if (change.size < skipLength)
					addr += change.size;
				else
					addr += change.size + skipLength;
				idx = (idx + (int) change.size) % data.length;
				
			}
		}
		
		changeMap.clear();
	}

	@Test
	public void testMemoryNotifyScatter() throws Throwable {
		// start...
		final int DELAY = 100;
		int memMode = 0;
		final List<Pair<String, MemoryChange[]>> changeMap = new ArrayList<Pair<String, MemoryChange[]>>();
		final IMemoryV2.MemoryContentChangeListener listener = new IMemoryV2.MemoryContentChangeListener() {

			@Override
			public void contentChanged(String contextId, MemoryChange[] change) {
				changeMap.add(new Pair<String, MemoryChange[]>(contextId,
						change));
			}
		};

		byte[] data = { 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
		
		// write 377 to 768 by 2
		doVideoMemWrite(memMode, DELAY, 1, listener, data, 377, 768 - 377, 2, 1);
		
		assertTrue("expected event", !changeMap.isEmpty());
		
		validateRanges(IMemoryDomain.NAME_VIDEO, 
				data, 377, 768 - 377, 2, 1, changeMap);
		
		
		// write 377 to 768 by 2, no gaps
		doVideoMemWrite(memMode, DELAY, 2, listener, data, 377, 768 - 377, 2, 1);
		
		assertTrue("expected event", !changeMap.isEmpty());
		
		validateRanges(IMemoryDomain.NAME_VIDEO, 
				data, 376, 768 - 376, 0, 0, changeMap);
		
		// huge chunk
		doVideoMemWrite(memMode, DELAY, 1024, listener, data, 123, 15, 2, 7);
		
		assertTrue("expected event", !changeMap.isEmpty());
		
		validateRanges(IMemoryDomain.NAME_VIDEO, 
				data, 0, 1024, 0, 0, changeMap);
	}
	

}