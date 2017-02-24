/******** Файл MAIN2.C **************************/
/* "Программа пользователя" */
#include "lab2.h"
#include <stdio.h>
main()
{
    int R; /* размерность */
    int i, j; /* номера строки и столбца */
    int m; /* значения элемента */
    int op; /* операция */
    system("chcp 65001 > nul");
    printf("Введите размерность матрицы >");
    scanf("%d",&R);
    /* создание матрицы */
    if ( creat_matr (R) )
    {
        printf("Ошибка создания матрицы\n");
        exit(0);
    }
    /* заполнение матрицы */
    for ( m=j=0; j<R; j++)
    {
        for ( i=0; i<R; i++)
            write_matr(i,j,++m);
    }
    while(1)
    {
        /* вывод матрицы на экран */
        system("chcp 65001 > nul");
        for (j=0; j<R; j++)
        {
            for (i=0; i<R; i++)
                printf("%3d ",read_matr(i,j));
            printf("\n");
        }
        printf("0 — выход\n1 — чтение\n2 — запись\n>");
        scanf("%d",&op);
        switch(op)
        {
        case 0:
            if (close_matr()) printf("Ошибка при уничтожении\n");
            else printf("Матрица уничтожена\n");
            exit(0);
        case 1:
        case 2:
            printf("Введите номер столбца >");
            scanf("%d",&j);
            printf("Введите номер строки >");
            scanf("%d",&i);
            if (op==2)
            {
                printf("Введите значение элемента >");
                scanf("%d",&m);
                write_matr(j,i,m);
                if (L2_RESULT<0) printf("Ошибка записи\n");
            }
            else
            {
                m=read_matr(j,i);
                if (L2_RESULT<0) printf("Ошибка считывания\n");
                else printf("Считано: %d\n",m);
            }
            printf("Нажмите клавишу\n");
            getch();
            break;
        }
    }
return 0;
}
/*****Конец файла MAIN2.C **********************/
