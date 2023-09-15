package main

import (
	"fmt"
	"math"
)

// golang中func定义格式 一次是 func (指针接收者) 函数名(参数列表) 返回值列表 {函数体}
// func(a int) int是一个函数闭包
func adder() func(a int) int {
	sum := 0
	return func(x int) int {
		sum += x
		return sum
	}
}

type Vertex struct {
	X, Y float64
}

func (v Vertex) Abs() float64 {
	return math.Sqrt(v.X*v.X + v.Y*v.Y)
}

func (v *Vertex) Scale(f float64) {
	v.X = v.X * f
	v.Y = v.Y * f
}

func main() {
	pos, neg := adder(), adder()
	for i := 0; i < 10; i++ {
		fmt.Println(
			pos(i),
			neg(-2*i),
		)
	}

	fmt.Println("//---------------------------------------------")
	v := Vertex{3, 4}
	v.Scale(10)
	fmt.Println(v.Abs())
}
