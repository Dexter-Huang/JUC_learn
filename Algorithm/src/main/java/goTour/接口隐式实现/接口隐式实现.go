package main

import "fmt"

type I interface {
	M()
}

type T struct {
	S string
}

// 接口类型 是由一组方法签名定义的集合。
// 此方法表示类型 T 实现了接口 I，但我们无需显式声明此事。
func (t T) M() {
	fmt.Println(t.S)
}

func main() {
	var i2 I = T{"hello"}
	i2.M()
	fmt.Println("//----------------空接口---------------------")
	var i interface{} //定义空接口
	describe(i)

	i = 42
	describe(i)

	i = "hello"
	describe(i)

	fmt.Println("//----------------类型断言-------------------")
	var i3 interface{} = "hello"

	s := i3.(string)
	fmt.Println(s)

	s, ok := i3.(string)
	fmt.Println(s, ok)

	f, ok := i3.(float64)
	fmt.Println(f, ok)

	//f = i.(float64) // 报错(panic)
	//fmt.Println(f)
	fmt.Println("//----------------类型选择-------------------")
	do(21)
	do("hello")
	do(true)

}
func describe(i interface{}) {
	fmt.Printf("(%v, %T)\n", i, i)
}
func do(i interface{}) {
	switch v := i.(type) {
	case int:
		fmt.Printf("Twice %v is %v\n", v, v*2)
	case string:
		fmt.Printf("%q is %v bytes long\n", v, len(v))
	default:
		fmt.Printf("I don't know about type %T!\n", v)
	}
}
