package main
type ProtoType struct {
    id int
    name string
}
func (p *ProtoType) Clone() ProtoType {
    return ProtoType{p.id, p.name}
}
func main() {
    p := ProtoType{1, "hello"}
    c := p.Clone()
    println(c.id, c.name)
}