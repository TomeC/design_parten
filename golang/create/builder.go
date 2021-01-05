package main
type ResourceConf struct {
    maxTotal int
    maxIdle int
}
func (r *ResourceConf) getTotal() int {
    return r.maxTotal
}
func (r *ResourceConf) getIdle() int {
    return r.maxIdle
}
type Builder struct {
    maxTotal int
    maxIdle int
}
func (b *Builder) build() *ResourceConf {
    return &ResourceConf{b.maxTotal, b.maxIdle}
}
func (b *Builder) setTotal(total int) *Builder {
    b.maxTotal = total
    return b
}
func (b *Builder) setIdle(idle int) *Builder {
    b.maxIdle = idle
    return b
}
func main() {
    b := &Builder{}
    r := b.setTotal(10).setIdle(2).build()
    println(r.getTotal(), r.getIdle())
}