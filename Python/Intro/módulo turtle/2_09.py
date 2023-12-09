import turtle

t = turtle.Turtle()
t.speed(3)

def poligono_reg(n,lado):
    angulo_externo=360/n
    for l in range(n):
        t.forward(lado)
        t.left(angulo_externo)

poligono_reg(3,100)