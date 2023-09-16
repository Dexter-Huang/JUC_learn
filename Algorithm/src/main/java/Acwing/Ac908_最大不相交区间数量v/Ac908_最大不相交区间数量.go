package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
)

var scanner = bufio.NewScanner(os.Stdin)

func nextInt() int {
	scanner.Scan()
	num, _ := strconv.Atoi(scanner.Text())
	return num
}

var n int

type Range struct {
	l, r int
}

const N int = 100005

var slot = make([]Range, N)

func main() {
	scanner.Split(bufio.ScanWords)
	n = nextInt()
	for i := 0; i < n; i++ {
		slot[i].l = nextInt()
		slot[i].r = nextInt()
	}

	sort.Slice(slot[:n], func(i, j int) bool {
		if slot[i].l == slot[j].l {
			return slot[i].r < slot[j].r
		}
		return slot[i].l < slot[j].l
	})

	var res = 1
	var maxR = slot[0].r
	for i := 1; i < n; i++ {
		if slot[i].l <= maxR {
			maxR = min(slot[i].r, maxR)
		} else {
			res++
			maxR = slot[i].r
		}
	}
	fmt.Println(res)
}

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}
