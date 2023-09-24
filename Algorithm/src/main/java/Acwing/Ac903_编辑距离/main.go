package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var scanner = bufio.NewScanner(os.Stdin)

var (
	f = make([][]int, 1005)
)

func nextInt() int {
	scanner.Scan()
	ans, _ := strconv.Atoi(scanner.Text())
	return ans
}

func nextStr() string {
	scanner.Scan()
	return scanner.Text()
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func isOk(str, targetStr string, limit int) bool {
	strLen := len(str)
	targetStrLen := len(targetStr)
	for i := 1; i <= strLen; i++ {
		for j := 1; j <= targetStrLen; j++ {
			if str[i-1] == targetStr[j-1] {
				f[i][j] = min(min(f[i-1][j]+1, f[i][j-1]+1), f[i-1][j-1])
			} else {
				f[i][j] = min(min(f[i-1][j]+1, f[i][j-1]+1), f[i-1][j-1]+1)
			}
		}
	}
	return f[strLen][targetStrLen] <= limit
}
func main() {
	scanner.Split(bufio.ScanWords)
	// 声明长宽均为1005的二维数组
	for i := 0; i < 1005; i++ {
		f[i] = make([]int, 1005)
	}

	for i := 0; i < 1005; i++ {
		f[i][0] = i
		f[0][i] = i
	}
	//////////////
	n := nextInt()
	m := nextInt()
	list := make([]string, n)
	for i := 0; i < n; i++ {
		list[i] = nextStr()
	}
	ans := make([]int, m)
	for i := 0; i < m; i++ {
		curTargetStr := nextStr()
		limit := nextInt()
		for j := 0; j < n; j++ {
			if isOk(list[j], curTargetStr, limit) {
				ans[i]++
			}
		}
	}

	for i := 0; i < m; i++ {
		fmt.Println(ans[i])
	}

}
