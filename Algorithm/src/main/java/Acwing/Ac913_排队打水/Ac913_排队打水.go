package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
)

var scanner = bufio.NewScanner(os.Stdin)

func nextLong() int64 {
	scanner.Scan()
	ans, _ := strconv.ParseInt(scanner.Text(), 10, 64)
	return ans
}
func main() {
	scanner.Split(bufio.ScanWords)
	n := nextLong()
	arr := make([]int64, n)
	sum := make([]int64, n)
	for i := int64(0); i < n; i++ {
		arr[i] = nextLong()
	}
	sort.Slice(arr[:n], func(i, j int) bool {
		return arr[i] < arr[j]
	})
	sum[0] = 0
	var ans int64
	for i := int64(1); i < n; i++ {
		sum[i] = sum[i-1] + arr[i-1]
		ans += sum[i]
	}
	fmt.Println(ans)

}
