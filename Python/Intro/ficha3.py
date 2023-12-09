"""Ficha 3"""

import math

print("\n-----\nFicha 3\n-----\n")

print("\n-----\nEx 3.1\n")
tempC = [-5,0,5,10,15,20,25]
print("(a)\n")
for valor in tempC:
    print(valor)

print("\n(b)\n")
for valor in range(-1,6):
    print(valor*5)

print("\n(c)\n")
valor=-5
while valor<=25:
    print(valor)
    valor+=5

print("\n(d)\n")

def celsius(F):
    C=(5.0/9)*(F-32)
    return C

valor= -5
while valor<=25:
    print("Temperatura em ºC: "+str(round(celsius(valor),1))+"ºC, temperatura em ºF: "+str(valor)+"ºF")
    valor+=5

print("\n")

print("\n-----\nEx 3.2\n")
for i in range(10, 56, 3):
    print(i)

print("\n(a)\n")
for i in range(10, 56, 3):
    if i%7==0:
        break
    else:
        print(i)

print("\n(b)\n")
for i in range(10, 56, 3):
    if i%7==0:
        continue
    else:
        print(i)
print("\n")

print("\n-----\nEx 3.3\n")
def media_arit(xs):
    if len(xs)==0:
        return 0
    else:
        return sum(xs)/len(xs)
    
print(media_arit([10, 20, 30, 40, 50]))
print("\n")

print("\n-----\nEx 3.4\n")
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

print("\n-----\nEx 3.5\n")
def bissexto(n):
    BISSEXTO=False
    if n%4==0 and n%100!=0 or n%400==0:
        BISSEXTO=True
    return BISSEXTO

print(bissexto(2020))
print("\n")

print("\n-----\nEx 3.6\n")
print("Anos Bissextos entre 2000 e 2020")
for ano in range(2000,2021):
    if bissexto(ano)==True:
        print(ano)
    else:
        continue
print("\n")

print("\n-----\nEx 3.7\n")
def fatorial(n):
    fat=1
    for i in range (1,n+1):
        fat*=i
    return fat

print(fatorial(5))
print("\n")

print("\n-----\nEx 3.8\n")
def quadrado_perfeito(n):
    raiz=int(math.sqrt(n))
    return raiz*raiz==n

print(quadrado_perfeito(9))

print("\n-----\nEx 3.8v2\n")
def quadrado_perfeito2(n):
    soma = 0
    k = 1
    while soma < n:
        soma += k
        k += 2
    return soma == n

print(quadrado_perfeito2(9))
print("\n")

print("\n-----\nEx 3.9\n")
def triangular(n):
    soma = 0
    k = 1
    while soma < n:
        soma += k
        k += 1
    return soma == n

print(triangular(9))
print("\n")

print("\n-----\nEx 3.10\n")
def algarismos(n):
    NUM=n
    AD=0
    while NUM!=0:
        NUM=NUM//10
        AD+=1
    return AD
print(algarismos(9733))
print("\n")

print("\n-----\nEx 3.11\n")
print("\n(a)\n")

def mindiv(n):
    for d in range(2,n+1):
      if n%d==0:
        return d

print(mindiv(22))
print("\n")

print("\n(b)\n")

def primo(n):
    return mindiv(n)==n

print(primo(11))
print("\n")

print("\n(c)\n")

def mindiv2(n):
    for d in range(int(math.sqrt(n)),n+1):
      if n%d==0 and d>1:
        return d

print(mindiv2(22))
print("\n")

print("\n-----\nEx 3.12\n")

def leibniz(k):
    """
    Calcula o somatório dos primeiros k termos da série de Leibniz para aproximar o valor de π.

    Parâmetros:
        k (int): O número de termos a serem somados na série.

    Retorna:
        float: O valor aproximado de π com base no somatório dos k termos.
    """
    aproximacao_pi=0.0
    for i in range(k):
        termo=math.pow((-1), i)/(2*i+1)
        aproximacao_pi+=termo

    aproximacao_pi*=4
    return aproximacao_pi

print(leibniz(10000))
print("\n")

print("\n-----\nEx 3.13\n")

def binom(n,k):
    coeficiente=fatorial(n)/(fatorial(k)*fatorial(n-k))
    return coeficiente

print(binom(5, 2))
print("\n")

print("\n-----\nEx 3.14\n")
print("Módulo turtle\n")
