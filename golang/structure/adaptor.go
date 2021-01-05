package main

type Adaptee struct {

}
func (a *Adaptee) f1() {
	println("f1")
}

type Adaptor struct {
	adptee *Adaptee
}
func NewAdaptor(a *Adaptee) *Adaptor {
	return &Adaptor{a}
}
func (ar *Adaptor) fa() {
	ar.adptee.f1()
}
func main() {
	ar := NewAdaptor(&Adaptee{})
	ar.fa()
}