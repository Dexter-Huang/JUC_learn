package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var scanner = bufio.NewScanner(os.Stdin)
var n, m int

const N = 310

var h, f [N][N]int
var dx = [4]int{-1, 0, 1, 0}
var dy = [4]int{0, 1, 0, -1}

func nextInt() int {
	scanner.Scan()
	ans, _ := strconv.Atoi(scanner.Text())
	return ans
}
func dp(x, y int) int {
	if f[x][y] != -1 {
		return f[x][y]
	}
	f[x][y] = 1
	for i := 0; i < 4; i++ {
		nx := x + dx[i]
		ny := y + dy[i]
		if nx >= 1 && nx <= n && ny >= 1 && ny <= m && h[nx][ny] < h[x][y] {
			f[x][y] = max(f[x][y], dp(nx, ny)+1)
		}
	}
	return f[x][y]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func init() {
	scanner.Split(bufio.ScanWords)
	for i := 0; i < N; i++ {
		for j := 0; j < N; j++ {
			f[i][j] = -1
		}
	}
}

func main() {
	n = nextInt()
	m = nextInt()
	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			h[i][j] = nextInt()
		}
	}
	res := 0
	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			res = max(res, dp(i, j))
		}
	}
	fmt.Println(res)
}
