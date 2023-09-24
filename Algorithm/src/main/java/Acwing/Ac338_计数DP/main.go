package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var scanner = bufio.NewScanner(os.Stdin)
var MOD = int(1e7 + 5)
var num = make([]int, MOD)

func nextInt() int {
	scanner.Scan()
	ans, _ := strconv.Atoi(scanner.Text())
	return ans
}
func init() {
	scanner.Split(bufio.ScanWords)
}

func getNum(l, r int) int {
	res := 0
	for i := l; i >= r; i-- {
		res = res*10 + num[i]
	}
	return res
}

func pow10(x int) int {
	res := 1
	for x > 0 {
		x--
		res *= 10
	}
	return res
}

func work(n, x int) int {
	if n == 0 {
		return 0
	}
	len := 0
	for n > 0 {
		len++
		num[len] = n % 10
		n /= 10
	}
	ans := 0
	if x != 0 {
		for i := len; i >= 1; i-- {
			if i < len {
				ans += getNum(len, i+1) * pow10(i-1)
			}
			if num[i] == x {
				ans += getNum(i-1, 1) + 1
			} else if num[i] > x {
				ans += pow10(i - 1)
			} else {
				ans += 0
			}
		}
	} else {
		for i := len; i > 0; i-- {
			ans += (getNum(len, i+1) - 1) * pow10(i-1)
			if num[i] == x {
				ans += getNum(i-1, 1) + 1
			} else if num[i] > x {
				ans += pow10(i - 1)
			} else {
				ans += 0
			}
		}
	}
	return ans
}

func main() {
	a := 1
	b := 1
	for {
		a = nextInt()
		b = nextInt()
		if a == 0 && b == 0 {
			break
		}
		if a > b {
			a, b = b, a
		}
		for i := 0; i <= 9; i++ {
			fmt.Printf("%d ", work(b, i)-work(a-1, i))
		}
		fmt.Println()
	}
}
