def search(a):
    for i in range(len(a)):
        if a[i] == '+':
            return add(a[i - 1], a[i + 1])
        if a[i] == '-':
            return sub(a[i - 1], a[i + 1])
        if a[i] == '*':
            return mul(a[i - 1], a[i + 1])
        if a[i] == '/':
            return div(a[i - 1], a[i + 1])

def add(a,b):
    return int(a) + int(b)
def sub(a,b):
    return int(a) - int(b)
def mul(a,b):
    return int(a) * int(b)
def div(a,b):
    return int(a) / int(b)

while input() != 'x':
    list = [i for i in input().split()]
    res = 0
    print(' '.join(str(i) for i in list))
    print(search(list))
#func = lambda a,b: a+b


