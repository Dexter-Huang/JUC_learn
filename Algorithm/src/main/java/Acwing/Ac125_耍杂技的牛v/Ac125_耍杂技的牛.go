package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
)

type Cow struct {
	w, s int64
}

var scanner = bufio.NewScanner(os.Stdin)

func nextInt64() int64 {
	scanner.Scan()
	ans, _ := strconv.ParseInt(scanner.Text(), 10, 64)
	return ans
}
func main() {
	scanner.Split(bufio.ScanWords)
	n := nextInt64()
	arr := make([]Cow, n)
	for i := int64(0); i < n; i++ {
		arr[i] = Cow{nextInt64(), nextInt64()}
	}
	sort.Slice(arr[:n], func(i, j int) bool {
		return arr[i].w+arr[i].s < arr[j].w+arr[j].s
	})
	var ans int64 = -arr[0].s
	var sum int64
	for i := int64(0); i < n; i++ {
		ans = max(ans, sum-arr[i].s)
		sum += arr[i].w
	}
	fmt.Println(ans)

}

func max(a int64, b int64) int64 {
	if a > b {
		return a
	}
	return b
}
