package main

type IA interface {
	f()
}

type A1 struct {
}
func (a *A1) f() {
	println("A1 process")
}

type A2 struct {
}
func (a *A2) f() {
	println("A2 process")
}

type Decorator struct {
	ia IA
}
func NewDecorator(ia IA) IA {
	return &Decorator{ia}
}
func (d *Decorator) f() {
	println("Decorator process")
	d.ia.f()
}

func main() {
	a1 := A1{}
	a2 := A2{}
	d1 := NewDecorator(&a1)
	d1.f()

	d2 := NewDecorator(&a2)
	d2.f()

	d3 := NewDecorator(d1)
	d3.f()
}
