"""Ficha 2"""

import math

print("\n-----\nFicha 2\n-----\n")

print("\n-----\nEx 2.1\n")
def investimento(P0,r,t):
    """
    Calcula o valor de um investimento.
    Argumentos:
        P0 (float): investimento inicial.
        r (float): taxa de juro.
        t (int): instante no tempo.
    Retorna:
        float: valor do investimento.
    """
    valor_inv=P0*math.exp(r*t)
    return valor_inv
print("\n")

print("\n-----\nEx 2.2\n")
def dist(x1,y1,x2,y2):
    """
    Calcula a distância entre 2 pontos.
    Argumentos:
        x1 (float): valor de x no ponto 1.
        y1 (float): valor de y no ponto 1.
        x2 (float): valor de x no ponto 2.
        y2 (float): valor de y no ponto 2.
    Retorna:
        float: valor da distância entre os 2 pontos.
    """
    distancia=math.sqrt(math.pow((x2-x1),2)+math.pow((y2-y1),2))
    return distancia
print("\n")

print("\n-----\nEx 2.3\n")
def radianos(graus, mins, segs):
    """
    Converte graus em radianos.
    Argumentos:
        graus (int): valor em graus a converter.
        mins (int): valor em minutos a converter, 1 grau = 60 mins.
        segs (int): valor em segundos a converter, 1 grau = 3600 segs.
    Retorna:
        float: valor convertido em radianos, cada 180º = π.
    """
    angulo=graus+mins/60+segs/3600
    radianos=angulo*math.pi/180
    return radianos
print("\n")

print("\n-----\nEx 2.4\n")
def segundos(horas, mins, segs):
    """
    Converte tempo completo só em segundos.
    Argumentos:
        horas (int): valor em em horas a converter para segundos.
        mins (int): valor em minutos a converter para segundos.
        segs (int): valor em segundos a somar.
    Retorna:
        int: valor completo em segundos.
    """
    segundos=segs+mins*60+horas*3600
    return segundos
print("\n")

print("\n-----\nEx 2.5\n")
def trocos(valor):
    """
    Converte tempo completo só em segundos.
    Argumentos:
        valor (int): valor que vai ser convertido em diversas notas e moedas.
    Retorna:
        str: como foi decomposto o pagamento.
    """
    VALOR=valor
    N20=VALOR//20
    n20="notas EUR 20: "+str(N20)+"\n"
    VALOR=VALOR%20
    N10=VALOR//10
    n10="notas EUR 10: "+str(N10)+"\n"
    VALOR=VALOR%10
    N5=VALOR//5
    n5="notas EUR  5: "+str(N5)+"\n"
    VALOR=VALOR%5
    m1="moedas EUR 1: "+str(VALOR)
    pagamento=n20+n10+n5+m1
    return pagamento
print(trocos(93))
print("\n")

print("\n-----\nEx 2.6\n")
xs=[5,0,42,10,24,30,81]
print("(a)")
for valor in xs:
    print("     "+str(valor))
print("(b)")
for valor in xs:
    print("     "+str(valor)+" || "+str(math.pow(valor,2))+" || "+str(math.sqrt(valor)))
print("(c)")
TOTAL=0
for valor in xs:
    TOTAL+=valor
    print("     "+str(valor)+" || "+str(TOTAL))
print("\n")

print("\n-----\nEx 2.7\n")
def tabela_quadrados(n):
    for num in range(n):
        print(str(num)+" "+str(int(math.pow(num,2))))
tabela_quadrados(5)
print("\n")

print("\n-----\nEx 2.8\n")
CI=int(input("Insira o capital inicial: "))
R=int(input("Insira a taxa de juro em percentagem: "))
def tabela_capital(Ci, n, r):
    for mes in range(n+1):
        CF=Ci*math.pow((1+(r/100)/12),mes)
        CF=round(CF, 2)
        print("Mês: "+str(mes)+ "|| Capital final: "+str(CF)+"€")
tabela_capital(CI, 24, R)
print("\n")

print("\n-----\nEx 2.9\n")
print("Módulo turtle\n")

print("\n-----\nEx 2.10\n")
print("Módulo turtle\n")

print("\n-----\nEx 2.11\n")
print("Módulo turtle\n")

print("\n-----\nEx 2.12\n")
def sdq(d):
    return sum([desvio**2 for desvio in d])
        
print(sdq([-6.9,4.7]))
print("\n")

print("\n-----\nEx 2.13\n")
def valor2(v):
    preco=1.72
    return sum([litros*preco for litros in v])
        
print(valor2([24.8,49.2]))
print("\n")

print("\n-----\nEx 2.14\n")
def area_triangulo(a,b,c):
    s=(a+b+c)/2
    A=math.sqrt(s*(s-a)*(s-b)*(s-c))
    return A
print(area_triangulo(3,3,3))
print("\n")

print("\n-----\nEx 2.15\n")
def triangulo(a,b,c):
    A=False
    if a<(b+c):
        A=True
    elif b<(a+c):
        A=True
    elif c<(a+b):
        A=True
    elif a>(abs(b-c)):
        A=True
    elif b>(abs(a-c)):
        A=True
    elif c>(abs(a-b)):
        A=True
    return A
print(triangulo(3,3,3))
print("\n")

print("\n-----\nEx 2.16\n")
print("(a) 3 == 3 - TRUE")
print("(b) 3 != 3 - FALSE")
print("(c) 3 >= 4 - FALSE")
print("(d) not (3 < 4) - FALSE")
print(3==3)
print(3!=3)
print(3>=4)
print(not (3<4))
print("\n")

print("\n-----\nEx 2.17\n")
print("(a) a < b")
print("(b) a <= b")
print("(c) a <= 18 and day != 3")
print("(d) a <= 18 and day == 3")
print("\n")

print("\n-----\nEx 2.18\n")
def classifica(p):
    MENSAGEM=""
    if p<0 or p>100:
        MENSAGEM="inválido"
    elif p<50:
        MENSAGEM="insuficiente"
    elif p>=50 and p<70:
        MENSAGEM="suficiente"
    elif p>=70 and p<80:
        MENSAGEM="bom"
    elif p>=80 and p<90:
        MENSAGEM="suficiente"
    else:
        MENSAGEM="excelente"
    return MENSAGEM

print(classifica(100))
print("\n")
