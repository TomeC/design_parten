package main

import "container/list"

type Observer interface {
	update()
}
type ConcreteObserver1 struct {

}
func (o *ConcreteObserver1) update () {
	println("ConcreteObserver1 update")
}
type ConcreteObserver2 struct {

}
func (o *ConcreteObserver2) update () {
	println("ConcreteObserver2 update")
}

type Subject struct {
	obs *list.List
}
func NewSubject() *Subject {
	return &Subject{list.New()}
}
func (s *Subject) regist(o Observer) {
	s.obs.PushBack(o)
}
func (s *Subject) update() {
	for e := s.obs.Front(); e != nil; e = e.Next() {
		e.Value.(Observer).update()
	}
}

func main() {
	s := NewSubject()
	s.regist(&ConcreteObserver1{})
	s.regist(&ConcreteObserver2{})
	s.regist(&ConcreteObserver1{})
	s.update()
}