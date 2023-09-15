package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var n, m int
var v []int
var w []int
var f [][]int

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func nextInt(scanner *bufio.Scanner) int {
	scanner.Scan()
	num, _ := strconv.Atoi(scanner.Text())
	return num
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	n = nextInt(scanner)
	m = nextInt(scanner)

	for i := 1; i <= n; i++ {
		v[i] = nextInt(scanner)
		w[i] = nextInt(scanner)
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			if j < v[i] {
				f[i][j] = f[i-1][j]
			} else {
				f[i][j] = max(f[i-1][j], f[i][j-v[i]]+w[i])
			}
		}
	}

	fmt.Println(f[n][m])
}
