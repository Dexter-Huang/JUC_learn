package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

const N = 1010

var n, m int
var v, w [N]int
var f [N][N]int

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Split(bufio.ScanWords)

	n = nextInt(scanner)
	m = nextInt(scanner)

	for i := 1; i <= n; i++ {
		v[i] = nextInt(scanner)
		w[i] = nextInt(scanner)
	}

	for i := 1; i <= n; i++ {
		for j := 0; j <= m; j++ {
			for k := 0; k*v[i] <= j; k++ {
				f[i][j] = max(f[i][j], f[i-1][j-k*v[i]]+k*w[i])
			}
		}
	}
	fmt.Println(f[n][m])
}

func max(a, b int) int {
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
