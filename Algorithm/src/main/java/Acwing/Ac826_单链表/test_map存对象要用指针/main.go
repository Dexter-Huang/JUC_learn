package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var scanner = bufio.NewScanner(os.Stdin)
var time = 0
var kthMap = make(map[int]ListNode)
var fakeHead = ListNode{Val: 0, Next: nil}

func init() {
	scanner.Split(bufio.ScanWords)
	kthMap[0] = fakeHead
}
func nextInt() int {
	scanner.Scan()
	ans, _ := strconv.Atoi(scanner.Text())
	return ans
}

func nextStr() string {
	scanner.Scan()
	return scanner.Text()
}

func incr(node *ListNode) {
	//fmt.Println(node)
	time++
	kthMap[time] = *node
}

func printList() {
	cur := fakeHead.Next
	for cur != nil {
		fmt.Printf("%d ", cur.Val)
		cur = cur.Next
	}
	fmt.Println()
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	n := nextInt()
	for i := 0; i < n; i++ {
		str := nextStr()
		switch str {
		case "H":
			futureHead := ListNode{Val: nextInt()}
			curHead := fakeHead.Next
			fakeHead.Next = &futureHead
			futureHead.Next = curHead
			incr(&futureHead)
			printList()
			break
		case "I":
			k := nextInt()
			x := nextInt()
			curNode := &ListNode{Val: x}
			kthNode := kthMap[k]
			kNextNode := kthNode.Next
			kthNode.Next = curNode
			curNode.Next = kNextNode
			incr(curNode)
			printList()
			break
		case "D":
			k := nextInt()
			kthNode := kthMap[k]
			if kthNode.Next != nil {
				kthNode.Next = kthNode.Next.Next
			}
			printList()
			break
		default:
			break
		}
	}
	printList()
}
