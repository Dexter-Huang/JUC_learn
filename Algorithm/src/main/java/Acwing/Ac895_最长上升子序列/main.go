package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var scanner = bufio.NewScanner(os.Stdin)

func nextInt() int {
	scanner.Scan()
	ans, _ := strconv.Atoi(scanner.Text())
	return ans
}
func main() {
	scanner.Split(bufio.ScanWords)
	n := nextInt()
	arr := make([]int, n)
	f := make([]int, n)
	for i := 0; i < n; i++ {
		arr[i] = nextInt()
		f[i] = 1
	}
	ans := 0
	for i := 0; i < n; i++ {
		for j := 0; j < i; j++ {
			if arr[i] > arr[j] {
				f[i] = max(f[j]+1, f[i])
			}
		}
		ans = max(ans, f[i])
	}
	fmt.Println(ans)

}

func max(a int, b int) int {
	if a < b {
		return b
	}
	return a
}
