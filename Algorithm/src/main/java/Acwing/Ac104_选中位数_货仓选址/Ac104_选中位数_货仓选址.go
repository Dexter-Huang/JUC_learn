package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
)

var scanner = bufio.NewScanner(os.Stdin)

func nextInt64() int64 {
	scanner.Scan()
	ans, _ := strconv.ParseInt(scanner.Text(), 10, 64)
	return ans
}
func abs(a int64) int64 {
	if a < 0 {
		return -a
	}
	return a
}
func main() {
	scanner.Split(bufio.ScanWords)
	n := nextInt64()
	arr := make([]int64, n)
	for i := int64(0); i < n; i++ {
		arr[i] = nextInt64()
	}
	sort.Slice(arr[:n], func(i, j int) bool {
		return arr[i] < arr[j]
	})
	var mid int64
	if n%2 == 0 {
		mid = (arr[n/2] + arr[n/2-1]) / 2
	} else {
		mid = arr[(n-1)/2]
	}
	var ans int64
	for i := int64(0); i < n; i++ {
		fmt.Println(mid, arr[i])
		ans += abs(mid - arr[i])
	}
	fmt.Println(ans)
}
