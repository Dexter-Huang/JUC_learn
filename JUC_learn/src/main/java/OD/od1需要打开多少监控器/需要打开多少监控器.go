package main

import "fmt"

var offsets = [][]int{{-1, 0}, {1, 0}, {0, 1}, {0, -1}}

func main() {
	var m, n int
	fmt.Scan(&m, &n)

	matrix := make([][]int, m)
	for i := 0; i < m; i++ {
		matrix[i] = make([]int, n)
		for j := 0; j < n; j++ {
			fmt.Scan(&matrix[i][j])
		}
	}

	fmt.Println(getResult(m, n, matrix))
}

func getResult(m, n int, matrix [][]int) int {
	count := 0

	for x := 0; x < m; x++ {
		for y := 0; y < n; y++ {
			if matrix[x][y] == 1 {
				count++
				continue
			}

			for _, offset := range offsets {
				newX := x + offset[0]
				newY := y + offset[1]

				if newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == 1 {
					count++
					break
				}
			}
		}
	}

	return count
}
