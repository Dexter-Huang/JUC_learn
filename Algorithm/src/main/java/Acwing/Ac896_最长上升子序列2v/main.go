package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

type Stack []int

func NewStack() Stack {
	return make(Stack, 0)
}

func (s *Stack) Push(v int) {
	*s = append(*s, v)
}

func (s *Stack) Pop() int {
	ans := (*s)[len(*s)-1]
	*s = (*s)[:len(*s)-1]
	return ans
}

func (s *Stack) Peek() int {
	return (*s)[len(*s)-1]
}

func (s *Stack) Size() int {
	return len(*s)
}

func (s *Stack) Empty() bool {
	return len(*s) == 0
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
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		arr[i] = nextInt()
	}

	stack := NewStack()
	stack.Push(arr[0])
	for i := 1; i < n; i++ {
		if arr[i] > stack.Peek() {
			stack.Push(arr[i])
		} else if arr[i] < stack.Peek() {
			stack[getIndex(stack, arr[i])] = arr[i]
		}
	}
	fmt.Println(stack.Size())
}
func getIndex(stack Stack, target int) int {
	l, r := -1, stack.Size()
	for l+1 != r {
		mid := (l + r) >> 1
		if stack[mid] >= target {
			r = mid
		} else {
			l = mid
		}
	}
	return r
}
