package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var n, m int
var N = 1010
var f = make([]int, N)
var v = make([]int, N)
var w = make([]int, N)

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
		for j := m; j >= v[i]; j-- {
			f[j] = max(f[j], f[j-v[i]]+w[i])
		}
	}
	fmt.Println(f[m])
}

func nextInt(scanner *bufio.Scanner) int {
	scanner.Scan()
	num, _ := strconv.Atoi(scanner.Text())
	return num
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
