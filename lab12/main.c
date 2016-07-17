#include <locale.h>
#include <malloc.h>
#include <mylib.h>

#define MAX_SIZE 100000

int main()
{
	int size;
    char *text = (char *)malloc(MAX_SIZE*sizeof(char));

	setlocale(0,"");
	printf("Введите строку: ");
	gets(text);

	size = GetSize(text);
    ReccuringCharsCount(text,size);
    return 0;
}
