package main

import (
	"bufio"
	"container/heap"
	"fmt"
	"os"
	"strconv"
)

type MinHeap []int

func (el MinHeap) Len() int {
	return len(el)
}

func (el MinHeap) Less(i, j int) bool {
	return el[i] < el[j]
}

func (el MinHeap) Swap(i, j int) {
	el[i], el[j] = el[j], el[i]
}

func (el *MinHeap) Push(x interface{}) {
	*el = append(*el, x.(int))
}

func (el *MinHeap) Pop() interface{} {
	old := *el         // save old
	n := len(old)      // get length
	x := old[n-1]      // get last element
	*el = old[0 : n-1] // remove last element
	return x
}

var scanner = bufio.NewScanner(os.Stdin)

func nextInt() int {
	scanner.Scan()
	ans, _ := strconv.Atoi(scanner.Text())
	return ans
}
func main() {
	scanner.Split(bufio.ScanWords)
	n := nextInt()
	arr := make(MinHeap, 0)
	for i := 0; i < n; i++ {
		arr.Push(nextInt())
	}
	heap.Init(&arr)
	ans := 0
	for len(arr) > 1 {
		a := heap.Pop(&arr).(int)
		b := heap.Pop(&arr).(int)
		ans += a + b
		heap.Push(&arr, a+b)
	}
	fmt.Println(ans)
}
