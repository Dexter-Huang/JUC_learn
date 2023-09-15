package main

import "fmt"

// swap 底层原理是值传递，所以不会改变原来的值
func swap(x, y string) (string, string) {
	return y, x
}

func swap2(x, y string) {
	x, y = y, x
}

// 引用传值 实现swap
func swap3(x, y *string) {
	*x, *y = *y, *x
}

const N = 1010

var (
	// 声明一个二维数组
	f   [N][N]int
	vis [N][N]bool
)

func main() {
	a, b := "hello", "world"
	swap(a, b)
	fmt.Println(a, b)
	swap2(a, b)
	fmt.Println(a, b)
	swap3(&a, &b)
	fmt.Println(a, b)

}
