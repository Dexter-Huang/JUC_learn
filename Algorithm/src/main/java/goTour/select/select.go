package main

import (
	"fmt"
)

func fibonacci(c, quit chan int) {
	x, y := 0, 1
	// 解释一下这里的for循环，这里的for循环是一个死循环，不会退出的
	// case c<-x 是指将x的值传入到c中，然后x和y的值进行交换
	// case <-quit 是指从quit中取出值，如果取出的值是0，那么就退出循环
	for {
		select {
		case c <- x:
			fmt.Println("c <- x:", x)
			x, y = y, x+y
		case <-quit:
			fmt.Println("quit")
			return
		}
	}
}

func main() {
	c := make(chan int)
	quit := make(chan int)
	go func() {
		for i := 0; i < 10; i++ {
			fmt.Println(<-c)
		}
		quit <- 0
	}()
	fibonacci(c, quit)
}
