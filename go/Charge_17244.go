package main

import "fmt"

func main() {
	var k float32
	_, _ = fmt.Scan(&k)
	fmt.Println((k / 2) * (k + 1))
}
