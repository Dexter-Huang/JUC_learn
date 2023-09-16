package main

import "fmt"

const N int = 1010

var n int
var m int
var f [N]int
var v [N]int
var w [N]int

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	fmt.Scan(&n, &m)
	for i := 1; i <= n; i++ {
		fmt.Scan(&v[i], &w[i])
	}
	for i := 1; i <= n; i++ {
		for j := v[i]; j <= m; j++ {
			f[j] = max(f[j], f[j-v[i]]+w[i])
		}
	}
	fmt.Println(f[m])
}
