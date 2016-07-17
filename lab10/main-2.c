#include <stdio.h>
#include <malloc.h>

void main()
{
    char buffer[] = {'e', 'E', 'u', 'U', 'i', 'I', 'o', 'O', 'a', 'A' };
    char *mass = (char *)malloc(10000*sizeof(char));
    char simv;
    int i = 0, j;
//ïîñèìâîëüíûé ââîä. Ââîä ïðîáåëà = êîíåö ââîäà
    printf("Enter the letter:\n");
    do
    {
        scanf("%c",&simv);
        mass[i] = simv;
        i++;
    }
    while (simv != ' ');

//ïîëó÷åííàÿ ïîñëåäîâàòåëüíîñòü áåç ãëàññíûõ
    printf("\nResult:\n");
    for(i=0; mass[i]!=' '; i++)
    {
        for(j=0; j<10; j++)
        {
            if(mass[i] == buffer[j])
            {
                printf("%c",mass[i]);
            }
        }
    }
    printf("\n");
    free(mass);
}
