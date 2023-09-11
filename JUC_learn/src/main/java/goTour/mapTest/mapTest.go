package main

import "fmt"

type Vertex struct {
	Lat, Long float64
}

var m = map[string]Vertex{ // 相当于Java中的HashMap<String, Vertex>
	"Bell Labs": Vertex{
		40.68433, -74.39967,
	},
	"Google": Vertex{
		37.42202, -122.08408,
	},
	"Microsoft": {520.1314, 5656},
}

func main() {
	fmt.Println(m)
	delete(m, "Microsoft")
	fmt.Println(m)
	v, ok := m["Answer"]
	fmt.Println("The value:", v, "Present?", ok)
	v, ok = m["Google"]
	fmt.Println("The value:", v, "Present?", ok)
	fmt.Println("//-------------------------------")

}
