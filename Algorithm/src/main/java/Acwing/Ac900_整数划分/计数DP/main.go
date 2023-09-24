package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var scanner = bufio.NewScanner(os.Stdin)
var f = make([][]int, 1005)
var MOD = int(1e9 + 7)

func init() {
	scanner.Split(bufio.ScanWords)
	for i := 0; i < 1005; i++ {
		f[i] = make([]int, 1005)
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
		for j := 1; j <= i; j++ {
			f[i][j] = (f[i-1][j-1] + f[i-j][j]) % MOD
		}
	}
	res := 0
	for i := 1; i <= n; i++ {
		res = (res + f[n][i]) % MOD
	}
	fmt.Println(res)
}
