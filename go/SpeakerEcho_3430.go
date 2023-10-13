package main

import "fmt"

func main() {
	var input string
	_, _ = fmt.Scan(&input)
	for i := 0; i < len(input); i++ {
		for j := 0; j < i; j++ {
			fmt.Print(string(input[i]))
		}
		fmt.Println(input[i:])
	}
}
