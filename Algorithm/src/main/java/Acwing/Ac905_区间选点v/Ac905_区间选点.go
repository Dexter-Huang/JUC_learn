package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

const N int = 100010

type Range struct {
	l, r int
}

func main() {
	n := 0
	slot := make([]Range, N)
	reader := bufio.NewReader(os.Stdin)
	nStr, _ := reader.ReadString('\n')
	nStr = strings.TrimSpace(nStr)
	n, _ = strconv.Atoi(nStr)
	for i := 0; i < n; i++ {
		line, _ := reader.ReadString('\n')
		line = strings.TrimSpace(line)
		nums := strings.Split(line, " ")
		l, _ := strconv.Atoi(nums[0])
		r, _ := strconv.Atoi(nums[1])
		slot[i] = Range{l, r}
	}
	sort.Slice(slot[:n], func(i, j int) bool {
		return slot[i].r < slot[j].r
	})
	res := 0
	var ed int = -2e9
	for i := 0; i < n; i++ {
		if slot[i].l > ed {
			res++
			ed = slot[i].r
		}
	}
	fmt.Printf("%d\n", res)
}
