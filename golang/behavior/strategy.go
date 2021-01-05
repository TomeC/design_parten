package main

type Strategy interface {
	call()
}
type StrategyA struct {
}
func (sa *StrategyA) call() {
	println("sa call")
}
type StrategyB struct {
}
func (sb *StrategyB) call() {
	println("sb call")
}

var Factory map[int]Strategy = make(map[int]Strategy)
func init() {
	Factory[0] = &StrategyA{}
	Factory[1] = &StrategyB{}
}
func main() {
	var sa Strategy = Factory[1]
	sa.call()
}