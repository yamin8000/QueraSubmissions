package main

import "fmt"

func main() {
	sins := [7]string{"sib", "somagh", "senjed", "serke", "sir", "sabze", "seke"}
	var m int
	_, _ = fmt.Scan(&m)
	for i := 0; i < m; i++ {
		fmt.Println(sins[i])
	}
}
