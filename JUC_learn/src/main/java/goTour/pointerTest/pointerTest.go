package main

import "fmt"

// type关键字是什么意思呢？
// type 指的是类型的意思，我们可以用type来定义一个结构体
type Vertex struct {
	X int
	Y int
}

// 结构体字段可以通过结构体指针来访问。
// 如果我们有一个指向结构体的指针 p，
// 那么可以通过 (*p).X 来访问其字段 X。
// 不过这么写太啰嗦了，所以语言也允许我们使用隐式间接引用，直接写 p.X 就可以
func main() {
	v := Vertex{1, 2}
	p := &v
	//(*p).X = 1e9
	p.X = 1e9
	fmt.Println(v)
}
