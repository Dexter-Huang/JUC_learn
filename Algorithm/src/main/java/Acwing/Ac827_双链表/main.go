package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var scanner = bufio.NewScanner(os.Stdin)

func nextInt() int {
	scanner.Scan()
	ans, _ := strconv.Atoi(scanner.Text())
	return ans
}

func nextStr() string {
	scanner.Scan()
	return scanner.Text()
}

type ListNode struct {
	val       int
	pre, next *ListNode
}

// --------------
var kthMap = make(map[int]*ListNode)
var fakeHead = ListNode{val: -1}
var fakeTail = ListNode{val: -1}
var time = 0

func incr(node *ListNode) {
	time++
	kthMap[time] = node
}
func addNode(pre, cur, next *ListNode) {
	pre.next = cur
	cur.pre = pre
	cur.next = next
	next.pre = cur
}

func delNode(pre, cur, next *ListNode) {
	pre.next = next
	next.pre = pre
	cur.pre = nil
	cur.next = nil
}

func printList() {
	cur := fakeHead.next
	for cur != &fakeTail {
		fmt.Printf("%d ", cur.val)
		cur = cur.next
	}
	fmt.Println()
}

func init() {
	scanner.Split(bufio.ScanWords)
	fakeTail.pre = &fakeHead
	fakeHead.next = &fakeTail
}
func main() {
	n := nextInt()
	for i := 0; i < n; i++ {
		target := nextStr()
		switch target {
		case "L":
			x := nextInt()
			futureHead := ListNode{val: x}
			curHead := fakeHead.next
			addNode(&fakeHead, &futureHead, curHead)
			incr(&futureHead)
			break
		case "R":
			x := nextInt()
			futureTail := ListNode{val: x}
			curTail := fakeTail.pre
			addNode(curTail, &futureTail, &fakeTail)
			incr(&futureTail)
			break
		case "D":
			k := nextInt()
			toDelNode := kthMap[k]
			delNode(toDelNode.pre, toDelNode, toDelNode.next)
			break
		case "IL":
			k := nextInt()
			x := nextInt()
			kthNode := kthMap[k]
			kthPreNode := kthNode.pre
			toAddNode := ListNode{val: x}
			addNode(kthPreNode, &toAddNode, kthNode)
			incr(&toAddNode)
			break
		case "IR":
			k := nextInt()
			x := nextInt()
			kthNode := kthMap[k]
			kthNextNode := kthNode.next
			toAddNode := ListNode{val: x}
			addNode(kthNode, &toAddNode, kthNextNode)
			incr(&toAddNode)
			break
		default:
			break
		}
	}
	printList()
}
