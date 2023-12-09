import turtle

t = turtle.Turtle()
t.speed(3)

def friso(n,lado):
    for ameia in range(n):
        t.forward(lado)
        t.left(90)
        t.forward(lado)
        t.right(90)
        t.forward(lado)
        t.right(90)
        t.forward(lado)
        t.left(90)

friso(3,50)