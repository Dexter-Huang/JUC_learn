package main

import (
	"bufio"
	"container/heap"
	"fmt"
	"os"
	"sort"
	"strconv"
)

type Edge struct {
	l, r int
}

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
	*el = append(*el, x.(Edge).r)
}

func (el *MinHeap) Pop() interface{} {
	old := *el
	n := len(old)
	x := old[n-1]
	*el = old[0 : n-1]
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
	arr := make([]Edge, n)
	for i := 0; i < n; i++ {
		l := nextInt()
		r := nextInt()
		arr[i] = Edge{l, r}
	}

	sort.Slice(arr[:n], func(i, j int) bool {
		return arr[i].l < arr[j].l
	})
	//fmt.Println(arr)
	minHeap := &MinHeap{}
	heap.Init(minHeap)

	for i := 0; i < n; i++ {
		l := arr[i].l
		r := arr[i].r
		if minHeap.Len() == 0 || l <= (*minHeap)[0] {
			heap.Push(minHeap, Edge{l, r})
		} else {
			min_r := (*minHeap)[0]
			heap.Pop(minHeap)
			heap.Push(minHeap, Edge{l, max(min_r, r)})
		}
	}

	fmt.Println(minHeap.Len())
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
