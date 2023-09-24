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

func nextString() string {
	scanner.Scan()
	return scanner.Text()
}

func main() {
	scanner.Split(bufio.ScanWords)
	n, m := nextInt(), nextInt()
	s1, s2 := nextString(), nextString()
	dp := make([][]int, n+1)
	dp[0] = make([]int, m+1)
	for i := 1; i <= n; i++ {
		dp[i] = make([]int, m+1)
		for j := 1; j <= m; j++ {
			if s1[i-1] == s2[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
			}
		}
	}
	fmt.Println(dp[n][m])
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
