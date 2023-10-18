package main

import (
	"bufio"
	"os"
	"strconv"
)

var scanner = bufio.NewScanner(os.Stdin)
var writer = bufio.NewWriter(os.Stdout)

type any = interface{}

func nextInt() int {
	scanner.Scan()
	ans, _ := strconv.Atoi(scanner.Text())
	return ans
}

func nextStr() string {
	scanner.Scan()
	return scanner.Text()
}
func init() {
	scanner.Split(bufio.ScanWords)
}

type stack struct {
	data [100005]any
	top  int
}

func (s *stack) push(x any) {
	s.top++
	s.data[s.top] = x
}

func (s *stack) pop() {
	s.top--
}

func (s *stack) empty() bool {
	return s.top == -1
}

func (s *stack) query() any {
	return s.data[s.top]
}
func main() {
	n := nextInt()
	stack := stack{top: -1}
	for i := 0; i < n; i++ {
		command := nextStr()
		switch command {
		case "push":
			num := nextInt()
			stack.push(num)
			break
		case "pop":
			stack.pop()
			break
		case "empty":
			if stack.empty() {
				writer.Write([]byte("YES\n"))
				//fmt.Println("YES")
			} else {
				writer.Write([]byte("NO\n"))
				//fmt.Println("NO")
			}

			break
		case "query":
			writer.Write([]byte(strconv.Itoa(stack.query().(int)) + "\n"))
			//fmt.Println(stack.query())
			break
		default:
			break
		}
	}
	writer.Flush()
}
