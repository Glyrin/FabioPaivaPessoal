"""Ficha 5"""

import math

print("\n-----\nFicha 5\n-----\n")

print("\n-----\nEx 5.1\n")
def media_arit(xs):
    if len(xs)==0:
        return 0
    else:
        return sum(xs)/len(xs)

print(media_arit([10, 20, 30, 40, 50]))
print("\n")

print("\n-----\nEx 5.2\n")
def media_geom(xs):
    if len(xs)==0:
        return 0
    else:
        produto=1
        for x in xs:
            produto*=x
        return math.pow(produto,1/len(xs))
    
print(media_geom([1, 2, 3, 4, 5]))
print("\n")

print("\n-----\nEx 5.3\n")
def desvio_padrao(xs):
    if len(xs)==0:
        return 0
    else:
        media=media_arit(xs)
        soma_diferencas_quadrados=sum((x-media)**2 for x in xs)
    return math.sqrt(soma_diferencas_quadrados/(len(xs)-1))

print(desvio_padrao([1, 2, 3, 4, 5]))
print("\n")

print("\n-----\nEx 5.4\n")
def intervalo(xs, a, b):
    contagem=0
    for i in xs:
        if i>a and i<b:
            contagem+=1
    return contagem

print(intervalo([1, 2, 5, 7, 10], 2, 8))
print("\n")

print("\n-----\nEx 5.5\n")
def segundoMaior(l):
    if len(l)<2:
        return None
    
    maior=-2147483648 #representa o menor numero int que o python aceita
    segundo=-2147483648

    for x in l:
        if x>maior:
            segundo=maior
            maior=x
        elif x>segundo and x!=maior:
            segundo=x
    if segundo== -2147483648:
        return None
    
    return segundo

print(segundoMaior([-1, 20, 12, -10]))
print("\n")

print("\n-----\nEx 5.6\n")
def ocorrencias(txt,c):
    indices=[]
    for i in range(len(txt)):
        if txt[i]==c:
            indices.append(i)    

    return indices

print(ocorrencias('banana', 'a'))
print("\n")

print("\n-----\nEx 5.7\n")
print("(a)")
def divisores(n):
    listaDivisores=[]
    for x in range(1,n):
        if n%x==0:
            listaDivisores.append(x)
    
    return listaDivisores

print(divisores(12))
print("\n")

print("(b)")
def perfeito(n):
    if sum(divisores(n))==n:
        return True
    else:
        return False

print(perfeito(6))
print(perfeito(10))
print("\n")

print("\n-----\nEx 5.8\n")
def repetidos(lista):
    if len(lista)==len(set(lista)): # set(lista) cria uma segunda lista sem os elementos repetidos, se as listas não tiverem o mesmo tamanho existiam repetidos
        # também podia ser feito por ciclo que elimina repetidos em vez de set(lista), ver Teórica 8 slide 19
        return False
    else:
        return True
    
print(repetidos(['ola', 'ole', 'abba', 'ole']))
print(repetidos([3, 2, -5, 0, 1]))
print("\n")

print("\n-----\nEx 5.9\n")
def palavras(txt):
    palavras=[]
    soLetras=""
    posicao=1
    for i in txt:
        if i==' ' or posicao==len(txt):
            posicao+=1
            palavras.append(soLetras)
            soLetras=""
        elif i.isalpha():
            posicao+=1
            soLetras+=i
        else:
            posicao+=1
    
    return palavras

print(palavras("---A Maria tinha um cordeirinho?"))
print("\n")

print("\n-----\nEx 5.10\n")
# nem sabia por onde começar tive de ir ver a definição do triângulo de Pascal ao Google
def fatorial(n):
    fat=1
    for i in range (1,n+1):
        fat*=i
    return fat

def pascal(n):
    linha=[]
    for k in range(n+1):
        if k==0 or k==n:
            linha.append(1)
        else:
            num=int (fatorial(n)/(fatorial(k)*fatorial(n-k)))# como tem divisões usa-se int para ter só a parte inteira
            linha.append(num)
    
    return linha

print(pascal(4))
print("\n")

print("\n-----\nEx 5.11\n")
def filtra_letras(txt):
    soLetras=[]
    for i in txt:
        if i.isalpha():
            soLetras.append(i.lower())# adiciona só as letras e sempre em minusculas por causa do lower()
    return soLetras

def anagramas(txt1, txt2):
    l1=filtra_letras(txt1)
    l1.sort()# função sort(), ordena listas de A a Z ou de menor para maior se forem números
    l2=filtra_letras(txt2)
    l2.sort()

    return l1==l2# é possivel comparar duas listas ordenadas

print(anagramas('Marcelo Sousa', 'salmao escuro'))
print(anagramas('Anibal Cavaco', 'cabala nociva'))
