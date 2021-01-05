package main

type A struct {

}
func NewA() *A {
	return &A{}
}
func (a *A) f1() {
	println("f1")
}
func (a *A) f2() {
	println("f2")
}
func (a *A) f() {
	a.f1();
	a.f2();
}
func main() {
	a := NewA()
	a.f()
}