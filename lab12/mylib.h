#ifndef H_FUNCTIONS  //проверка двйоного подключения Guard Ifdef
#define H_FUNCTIONS

//макрос сравнения
#define SETZERO(X)  X=0

//макрос вывода
#define NEW_STR() printf("\n")

//макрос foreach
#define foreach( ptrvar, strvar ) 
	char* ptrvar; \
	for( ptrvar=strvar ; (*ptrvar) != '\0' ; *ptrvar++)

int GetSize(char *mass) //вывовдит исходную строку и возвращает количество символов
{
	int count = 0;
	foreach(el, mass)
	{
		printf("%c", *el);
		count++;
	}
	NEW_STR();
	return count;
}
void ReccuringCharsCount(char* str, int size)
{
	int k, j, i, cnt;
	int repetition; 
    for (SETZERO(k); k < size; ++k)
	{ 
        cnt = 1; 
		repetition = FALSE; 
		for (SETZERO(j); j < k; ++j)
			if ( str[k] == str[j] )
			{ 
				repetition = TRUE; 
                break; 
			}
        if (repetition == TRUE) 
			continue;
        for (i = k+1; i < size; ++i)
		{ 
             if ( str[k] == str[i] )
                ++cnt;
        }
        printf("%c --> %d раз(а).\n", str[k], cnt); 
    }
}
#endif

