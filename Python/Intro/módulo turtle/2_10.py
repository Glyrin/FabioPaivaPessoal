import turtle

t = turtle.Turtle()
t.speed(3)

def poligono_reg(n,lado):
    angulo_externo=360/n
    for l in range(n):
        t.forward(lado)
        t.left(angulo_externo)

def casa(lado):
    poligono_reg(4,lado)
    t.left(90)
    t.forward(lado)
    t.right(90)
    poligono_reg(3,lado)

casa(100)
