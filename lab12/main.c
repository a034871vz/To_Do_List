#include <malloc.h>
#include "mylib.h"


int main(void) {

	float 	parseFloatAfterInfo(char*, char[]);

	char	a,x, xEnd,step;
	char	*buffer;

	buffer = (char*)malloc(63 * sizeof(char));

	   a = parseFloatAfterInfo("\nType value of 'a': ", buffer);
	   x = parseFloatAfterInfo("Type 'xBegin': ", buffer);
	xEnd = parseFloatAfterInfo("Type 'xEnd': ", buffer);
	step = parseFloatAfterInfo("Define 'step' value: ", buffer);

	return 0;
}
