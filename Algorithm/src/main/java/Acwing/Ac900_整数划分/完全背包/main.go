package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var scanner = bufio.NewScanner(os.Stdin)
var MOD int = 1000000007
var LEN int = 1005
var f = make([][]int, LEN)

func init() {
	scanner.Split(bufio.ScanWords)
	for i := 0; i < LEN; i++ {
		f[i] = make([]int, LEN)
	}
	f[0][0] = 1
}

func nextInt() int {
	scanner.Scan()
	ans, _ := strconv.Atoi(scanner.Text())
	return ans
}

func main() {
	n := nextInt()
	for i := 1; i <= n; i++ {
		for j := 0; j <= n; j++ {
			for k := 0; j-k*i >= 0; k++ {
				f[i][j] += f[i-1][j-k*i]
				f[i][j] %= MOD
			}
		}
	}
	fmt.Println(f[n][n])
}
