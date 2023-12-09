import turtle

t = turtle.Turtle()
t.speed(3)

def espiral_v1():
    comp=200
    for l in range(96):
        t.forward(comp)
        comp-=2
        t.left(90)
   
espiral_v1()

def espiral_v2():
    comp=200
    for l in range(100):
        t.forward(comp)
        comp-=2
        t.left(91)
   
espiral_v2()
