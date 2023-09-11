package main

import "fmt"

/*
*
切片文法类似于没有长度的数组文法。

这是一个数组文法：

[3]bool{true, true, false}
下面这样则会创建一个和上面相同的数组，然后构建一个引用了它的切片：

[]bool{true, true, false}
*/
func main() {
	q := []int{2, 3, 5, 7, 11, 13}
	fmt.Println(q)

	r := []bool{true, false, true, true, false, true}
	fmt.Println(r)

	s := []struct {
		i int
		b bool
	}{
		{2, true},
		{3, false},
		{5, true},
		{7, true},
		{11, false},
		{13, true},
	}
	fmt.Println(s)

	fmt.Println("//---------------------------------------------")
	final := []int{2, 3, 5, 7, 11, 13}
	s2 := final[1:4]
	fmt.Println("1:4 ", s2)

	s2 = final[1:5]
	fmt.Println("1:5 ", s2)

	// 切片:2意思是从0开始到2结束，不包含2
	s2 = final[:2]
	fmt.Println(":2 ", s2)
	// 切片1:意思是从1开始到最后
	s2 = final[1:]
	fmt.Println("1: ", s2)
}
