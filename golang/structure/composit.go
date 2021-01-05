package main

import "container/list"

type HumanResource interface {
	getSalary() int
}
type Employee struct {
	id, salary int
}
func NewEmployee(id, salary int) *Employee {
	return &Employee{id, salary}
}
func (e *Employee) getSalary() int {
	return e.salary
}
type Department struct {
	id, salary int
	resourceList *list.List
}
func NewDepartment(id int) *Department {
	return &Department{id, 0, list.New()}
}
func (d *Department) getSalary() int {
	total := 0
	for e := d.resourceList.Front(); e != nil; e = e.Next() {
		total += e.Value.(HumanResource).getSalary()
	}
	return total
}
func (d *Department) addResource(r HumanResource) {
	d.resourceList.PushBack(r)
}
func main() {
	root := NewDepartment(1)
	u1 := NewEmployee(11, 10)
	u2 := NewEmployee(12, 11)
	root.addResource(u1)
	root.addResource(u2)
	d1 := NewDepartment(2)
	d1.addResource(u1)
	root.addResource(d1)
	println(root.getSalary())
}