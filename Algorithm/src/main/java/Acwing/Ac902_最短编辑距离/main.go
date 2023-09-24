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

func nextStr() string {
	scanner.Scan()
	return scanner.Text()
}
func main() {
	scanner.Split(bufio.ScanWords)
	n := nextInt()
	s1 := nextStr()
	m := nextInt()
	s2 := nextStr()
	f := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		f[i] = make([]int, m+1)
	}

	for i := 0; i <= n; i++ {
		f[i][0] = i
	}
	for j := 0; j <= m; j++ {
		f[0][j] = j
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			if s1[i-1] == s2[j-1] {
				f[i][j] = min3(f[i-1][j]+1, f[i][j-1]+1, f[i-1][j-1])
			} else {
				f[i][j] = min3(f[i-1][j]+1, f[i][j-1]+1, f[i-1][j-1]+1)
			}
		}
	}
	fmt.Println(f[n][m])
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func min3(a, b, c int) int {
	return min(min(a, b), c)
}
