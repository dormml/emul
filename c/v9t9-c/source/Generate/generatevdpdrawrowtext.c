/*
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

#include <stdio.h>

int
main(void)
{
	unsigned int i, b;

	printf("typedef unsigned char u8;\n");
	for (i = 0; i < 256; i++) {
		printf("static void\tdrawrowtext%d(u8 *o)\n", i);
		printf("{\n\t");
		for (b = 0; b < 6; b++)
			if (i & (0x80 >> b))
				printf("o[%d]=16;\t", b);
			else
				printf("o[%d]=0;\t", b);
		printf("\n}\n\n");


	}

	printf("void (*vdpdrawrowtext[])(u8 *)=\n{\n");
	for (i = 0; i < 256; i++) {
		printf("drawrowtext%d%s", i, i != 255 ? "," : "\n};");

		if ((i % 6) == 5)
			printf("\n");
	}
	exit(0);
}
