package main

import "fmt"

type Share struct {
	a int
}

var smap = make(map[int] *Share)
func init() {
	println("init")
	smap[1] = &Share{}
	smap[2] = &Share{}
	fmt.Println(smap)
}
func  get(id int) *Share{
	fmt.Println(smap)
	return smap[id]
}

func main() {
	println("main")
	s1 := get(1)
	s2 := get(1)
	s3 := get(2)
	println(s1)
	println(s2)
	println(s3)
}