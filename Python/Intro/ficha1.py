"""Ficha 1"""

import math

print("\n-----\nFicha 1\n-----\n")

print("\n-----\nEx 1.3\n")
A = 45 + 27
print("(a) " + str(A))
B = 2**3
print("(b) " + str(B))
C = 9 % 4
print("(c) " + str(C))
D = "2" + "34"
print("(d) " + str(D))
E = 2.5 * 4
print("(e) " + str(E))
F = 10 / 3
print("(f) " + str(F))
G = 10 // 3
print("(g) " + str(G))
H = 10 % 3
print("(h) " + str(H))

print("\n-----\nEx 1.4\n")
print("(a) " + str(type(A)))
print("(a) " + str(type(B)))
print("(a) " + str(type(C)))
print("(a) " + str(type(D)))
print("(a) " + str(type(E)))
print("(a) " + str(type(F)))
print("(a) " + str(type(G)))
print("(a) " + str(type(H)))

print("\n-----\nEx 1.5\n")
A = (10-7)*(4-3)
print("(a) " + str(A) + " " + str(type(A)))
B = 10-7*4-3
print("(b) " + str(B) + " " + str(type(B)))
C = 17/3
print("(c) " + str(C) + " " + str(type(C)))
D = 17//3
print("(d) " + str(D) + " " + str(type(D)))
E = 17%3
print("(e) " + str(E) + " " + str(type(E)))
F = (3+5)/2*3
print("(f) " + str(F) + " " + str(type(F)))
G = (3+5)/(2*3)
print("(g) " + str(G) + " " + str(type(G)))
H = 1+1/3
print("(h) " + str(H) + " " + str(type(H)))
I = 1+1/3.0
print("(h) " + str(I) + " " + str(type(I)))
J = 1+1//3
print("(h) " + str(J) + " " + str(type(J)))
K = 2**3
print("(h) " + str(K) + " " + str(type(K)))
L = 2.0**3
print("(h) " + str(L) + " " + str(type(L)))

print("\n-----\nEx 1.6\n")
print("(a) a=121, b=45, t=a, a=b, b=t")
print("(a) a=121, b=45, t=121, a=45, b=121")
A=121
print("a=" + str(A))
B=45
print("b=" + str(B))
T=A
print("t=" + str(T))
A=B
print("a=" + str(A))
B=T
print("b=" + str(B) + "\n")

print("(b) p=1, p=p*2, p=p*3, p=p*4")
print("(b) p=1, p=2, p=6, p=24")
P=1
print(P)
P=P*2
print(P)
P=P*3
print(P)
P=P*4
print(P)
print("\n")

print("(c) N=1, N=N*10+2, N=N*10+3, N=N*10+4")
print("(c) N=1, N=12, N=123, N=1234")
N=1
print(N)
N=N*10+2
print(N)
N=N*10+3
print(N)
N=N*10+4
print(N)
print("\n")

print("(d) x=2.0, r=x, r=0.5*(r+x/r), r=0.5*(r+x/r), r=0.5*(r+x/r)")
print("(d) x=2.0, r=2.0, r=1.5, r=1.4166666666666665, r=1.4142156862745097")
X=2.0
print(X)
R=X
print(R)
R=0.5*(R+X/R)
print(R)
R=0.5*(R+X/R)
print(R)
R=0.5*(R+X/R)
print(R)
print("\n")

print("(e) a=54, b=24, r=a%b, a=b, b=r, r=a%b, a=b, b=r")
print("(e) a=54, b=24, r=6, a=24, b=6, r=0, a=6, b=0")
A=54
print(A)
B=24
print(B)
R=A%B
print(R)
A=B
print(A)
B=R
print(B)
R=A%B
print(R)
A=B
print(A)
B=R
print(B)
print("\n")

print("\n-----\nEx 1.7\n")
print("(a) s=0, s=s**2+1, s=s**2+2, s=s**2+3")
print("(a) s=0, s=1, s=3, s=12")
S=0
print(S)
S=S**2+1
print(S)
S=S**2+2
print(S)
S=S**2+3
print(S)
print("\n")

print("(b) s=0, s=(s+1)**2, s=(s+2)**2, s=(s+3)**2")
print("(b) s=0, s=1, s=9, s=144")
S=0
print(S)
S=(S+1)**2
print(S)
S=(S+2)**2
print(S)
S=(S+3)**2
print(S)
print("\n")

print("(c) n=1, s=0, s=s+n, n=n+1, s=s+n, n=n+1, s=s+n, n=n+1")
print("(c) n=1, s=0, s=1, n=2, s=3, n=3, s=6, n=4")
N=1
print(N)
S=0
print(S)
S=S+N
print(S)
N=N+1
print(N)
S=S+N
print(S)
N=N+1
print(N)
S=S+N
print(S)
N=N+1
print(N)
print("\n")

print("(d) x=3, y=1, y=x*y+1, y=x*y+1, y=x*y+1")
print("(d) x=3, y=1, y=4, y=13, y=40")
X=3
print(X)
Y=1
print(Y)
Y=X*Y+1
print(Y)
Y=X*Y+1
print(Y)
Y=X*Y+1
print(Y)
print("\n")

print("(e) x=3, y=x**3+x**2+x+1")
print("(e) x=3, y=40")
X=3
print(X)
Y=X**3+X**2+X+1
print(Y)
print("\n")

print("\n-----\nEx 1.8\n")
print("(a)")
X=input()
print(X)
print("O programa ficou à espera que escrevesse algo antes de retornar o que eu lá escrevi")
print("(b)")
X=input("Please write something: ")
print(X)
print("O programa escrevou 'Please write something: ' e depois ficou à espera que escrevesse algo")
print("antes de retornar só o que eu lá escrevi\n")

print("\n-----\nEx 1.9\n")
NOME=input("What's your name? ")
print("Hello, "+NOME+"\n")

print("\n-----\nEx 1.10\n")
print("(a)")
X=2
A=(1+X)*(-1+2*X)
print(A)
print("(b)")
B=1+1/2+1/3+1/4
print(B)
print("(c)")
C=math.pow(2,math.pow(2,3))
print(C)
print("(d)")
X=5
D=(1-math.pow(X,2))/(2*X)
print(D)
print("(e)")
X=2
E=1+1/(2+1/X)
print(E)
print("(f)")
X=2
Y=0.5
F=math.sqrt(math.pow(X,2)+math.pow(Y,2))
print(F)
print("(g)")
A=1
B=1
C=-1/3
G=math.sqrt(math.pow(B,2)-4*A*C)
print(G)
print("(h)")
A=math.pi/4
H=math.sin(math.pi-A)
print(H)
print("\n")

print("\n-----\nEx 1.11\n")
print("(a)")
print (97+555)
print("(b)\nErro Sintático, $ não é operador válido")
# print(97$+555$)
print("(c)")
print (math.sqrt(2))
print("(d)\nErro Semântico, não se pode fazer raiz quadrada de números negativos")
#print (math.sqrt(-2))
print("(e)\nErro Sintático, falta o operador depois do 2")
#print (2(math.pi))
print("(f)")
print (2*math.pi)
print("(g)")
print (str(2*math.pi))
print("(h)")
print (int(2*math.pi))
print("(i)\nErro Semântico, não se pode concatenar strings com números")
#print ("97"+555)
print("(j)")
print (97 == "97")
print("(k)")
print ( 97 == int("97"))
print("(l)")
print (102 <= 97)
print("(m)\nErro Semântico, não se pode fazer comparações de strings com números quando se usa <=")
#print (102 <= "97")
print("(n)")
print ("102" <= "97")
print("(o)\nErro Semântico, não se pode concatenar strings com números")
#print( "valor de pi é " + math.pi)
print("(p)")
print ("valor de pi é " + str(math.pi))
print("\n")

print("\n-----\nEx 1.12\n")
KM=float(input("Quantos quilómetros percorreu? "))
LITROS=float(input("Quantos litros de combustível gastou? "))
print(LITROS/KM*100)
print("\n")

print("\n-----\nEx 1.13\n")
def area_circ(raio_r):
    """
    Calcula a área de um círculo.
    Argumentos:
        r (float): O raio do círculo.
    Retorna:
        float: A área do círculo.
    """
    valor_area=math.pi*(math.pow(raio_r,2))
    return valor_area

print(area_circ(2))
print("\n")

print("\n-----\nEx 1.14\n")
def celsius(temp_f):
    """
    Converte uma temperatura de Fahrenheit para Celsius.
    Argumentos:
        F (float): A temperatura em Fahrenheit.
    Retorna:
        float: A temperatura equivalente em Celsius.
    """
    valor_celsius=(5/9)*(temp_f-32)
    return valor_celsius

print(celsius(100))
print("\n")

print("\n-----\nEx 1.15\n")
def hipotenusa(cat_a,cat_b):
    """
    Calcula a hipotenusa de um triângulo retângulo.
    Argumentos:
        a (float): Comprimento de um dos catetos.
        b (float): Comprimento do outro cateto.
    Retorna:
        float: O comprimento da hipotenusa.
    """
    valor_h=math.sqrt(math.pow(cat_a,2)+math.pow(cat_b,2))
    return valor_h

print(hipotenusa(2,2))
print("\n")
