package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// 头插法
func reverseBetween(head *ListNode, m int, n int) *ListNode {
	// write code here
	if head == nil || head.Next == nil {
		return head
	}

	dummy := &ListNode{Next: head}
	pre := dummy

	for i := 1; i < m; i++ {
		pre = pre.Next
	}

	cur := pre.Next
	for i := m; i < n; i++ {
		temp := cur.Next
		cur.Next = temp.Next
		temp.Next = pre.Next
		pre.Next = temp
	}
	return dummy.Next
}

func main() {
	var str string
	fmt.Scanln(&str)
	fmt.Println(str)
}
