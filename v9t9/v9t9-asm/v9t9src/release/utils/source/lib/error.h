/*
  error.h

  (c) 1991-2012 Edward Swartz

  This program is free software; you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation; either version 2 of the License, or
  (at your option) any later version.
 
  This program is distributed in the hope that it will be useful, but
  WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
  General Public License for more details.
 
  You should have received a copy of the GNU General Public License
  along with this program; if not, write to the Free Software
  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
  02111-1307, USA.
 */

#ifndef	__ERROR__
extern	int Error;
#endif

void	die(char *file);
void	tierror(char *file);


#define	BADPATH	1
#define	NOTTIEMUL 2
#define BADFILE 3
#define NOSPACE 4
#define	NOTIFILE 5
#define BADSEEK 6
#define BADREAD 7
#define BADDISK 8
#define	EXISTS 9
#define	NOMEMORY 10
#define	INCOMPAT 11
#define BADSIDE 12
#define NOFILE 13
