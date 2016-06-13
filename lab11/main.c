#include <stdio.h>
#include <malloc.h>
#include <locale.h>

typedef struct sNode
{
    int value;
    struct sNode *next;
} tNode;


void push(tNode **head, int data)
{
    tNode *tmp = (tNode*) malloc(sizeof(tNode));
    tmp->value = data;
    tmp->next = (*head);
    (*head) = tmp;
}

tNode* getLast(tNode *head) //ïîëó÷àåì ïîñëåäíèé ýëåìåíò
{
    if (head == NULL)
	{
        return NULL;
    }
    while (head->next)
	{
        head = head->next;
    }
    return head;
}

void pushBack(tNode *head, int value) //âñòàâëÿåì íîâûé ýëåìåíò â êîíåö
{
    tNode *last = getLast(head);
    tNode *tmp = (tNode*) malloc(sizeof(tNode));
    tmp->value = value;
    tmp->next = NULL;
    last->next = tmp;

	printf("Element %d Inserted into the bottom of the list.\n", value);
}

void printList(tNode *head)
{
    while (head)
	{
        printf("%d ", head->value);
        head = head->next;
    }
    printf("\n");
}

void insert(tNode *head, unsigned n, int val) //âñòàâêà ýëåìåíòà êóäà çàõîòèì :)
{
    unsigned i = 0;
    tNode *tmp = NULL;
    //Íàõîäèì íóæíûé ýëåìåíò. Åñëè âûøëè çà ïðåäåëû ñïèñêà, òî âûõîäèì èç öèêëà,
    //îøèáêà âûáðàñûâàòüñÿ íå áóäåò, ïðîèçîéä¸ò âñòàâêà â êîíåö
    while (i < n && head->next)
	{
        head = head->next;
        i++;
    }
    tmp = (tNode*) malloc(sizeof(tNode));
    tmp->value = val;
    //Åñëè ýòî íå ïîñëåäíèé ýëåìåíò, òî next ïåðåêèäûâàåì íà ñëåäóþùèé
    if (head->next)
	{
        tmp->next = head->next;
    //èíà÷å íà NULL
    }
	else
	{
        tmp->next = NULL;
    }
    head->next = tmp;
	printf("Element %d Inserted after the %d-go elements.(indexing with 0)\n", val,n);
}


void deleteList(tNode **head) //óäàëÿåì ñïèñîê - îñâîáîæäàåì ïàìÿòü
{
    tNode* prev = NULL;
    while ((*head)->next) {
        prev = (*head);
        (*head) = (*head)->next;
        free(prev);
    }
    free(*head);
	printf("List deleted!\n");
}


void main()
{
    tNode* head = NULL;
	setlocale(0,"");
	printf("Create a list.Add to it the element = 54\n");
	push(&head,54);//ïåðâûé ýëåìåíò ñïèñêà

    pushBack(head, 14);
    pushBack(head, -812);
    pushBack(head, 5);
    pushBack(head, 522);
    insert(head, 3, 1);

	printf("\nLinked List:\n");
    printList(head);
	deleteList(&head);
}
