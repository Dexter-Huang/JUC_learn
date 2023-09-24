package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var scanner = bufio.NewScanner(os.Stdin)
var f = make([][]int, 305)

func nextInt() int {
	scanner.Scan()
	ans, _ := strconv.Atoi(scanner.Text())
	return ans
}

func init() {
	// 在main函数前执行的代码
	scanner.Split(bufio.ScanWords)
	for i := 0; i < 305; i++ {
		f[i] = make([]int, 305)
		for j := 0; j < 305; j++ {
			f[i][j] = 0x3f3f3f3f
		}
	}
}
func main() {
	n := nextInt()
	a := make([]int, n+1)

	sum := make([]int, n+1)
	for i := 1; i <= n; i++ {
		a[i] = nextInt()
		sum[i] = sum[i-1] + a[i]
	}
	for len := 1; len <= n; len++ {
		for i := 1; i+len-1 <= n; i++ {
			j := i + len - 1
			if len == 1 {
				f[i][j] = 0
			} else {
				for k := i; k < j; k++ {
					f[i][j] = min(f[i][j], f[i][k]+f[k+1][j]+sum[j]-sum[i-1])
				}
			}
		}
	}
	fmt.Println(f[1][n])
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
