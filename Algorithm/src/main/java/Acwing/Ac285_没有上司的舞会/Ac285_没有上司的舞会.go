package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

const N = 6010

var (
	n       int
	list    [N][]int
	f       [N][2]int
	st      [N]bool
	happy   [N]int
	scanner = bufio.NewScanner(os.Stdin)
)

func add(a, b int) {
	list[a] = append(list[a], b)
}

func dfs(u int) {
	f[u][1] = happy[u]
	for i := 0; i < len(list[u]); i++ {
		son := list[u][i]
		dfs(son)
		f[u][1] += f[son][0]
		f[u][0] += max(f[son][0], f[son][1])
	}
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func nextInt() int {
	scanner.Scan()
	num, _ := strconv.Atoi(scanner.Text())
	return num
}
func init() {
	scanner.Split(bufio.ScanWords)
}

func main() {
	n = nextInt()
	for i := 1; i <= n; i++ {
		happy[i] = nextInt()
	}
	m := n - 1
	for m > 0 {
		m--
		a := nextInt()
		b := nextInt()
		add(b, a)
		st[a] = true
	}
	root := 1
	for st[root] {
		root++
	}
	dfs(root)
	fmt.Println(max(f[root][0], f[root][1]))
}
