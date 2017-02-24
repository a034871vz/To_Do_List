#include <stdio.h>
#include <malloc.h>
#include <math.h>


int main(void) {

	int 	i, arrSize,
			errScan;
	float 	n, nBegin, nEnd,
			step;
	float	*data;

	errScan = 1;
	printf("Çàäàéòå íà÷àëî èíòåðâàëà: ");
		errScan *= scanf("%f", &nBegin);
	printf("Çàäàéòå  êîíåö èíòåðâàëà: ");
		errScan *= scanf("%f", &nEnd);
	printf("Çàäàéòå ðàçìåð      øàãà: ");
		errScan *= scanf("%f", &step);

	if(errScan != 1) {

		printf("Äàííûå ââåäåíû íåâåðíî!");
		return 0;
	}

	n = nBegin;
	if((n < nEnd) && (step != 0)) {

		arrSize = (int)((nEnd-n)/step) + 1;
		data = (float*)malloc(arrSize * sizeof(float));

	} else
		return 0;

	i = 0;
	while(n <= nEnd) {

		data[i] = pow(n, 2);
		n += step;
		i++;
	}

	i = 0;
	n = nBegin;
	while(i < arrSize) {

		printf("%5.2f : %10.2f\n", n, data[i]);
		n += step;
		i++;
	}

	if(data == NULL)
		free(data);

	return 0;
}
