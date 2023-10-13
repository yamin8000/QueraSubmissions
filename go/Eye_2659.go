package main

import "fmt"

func main() {
	var n int
	_, _ = fmt.Scan(&n)
	var correct, wrong string
	_, _ = fmt.Scan(&correct, &wrong)

	var errors = 0
	var start = 0
	var end = len(correct) - 1
	mid := (len(correct) - 1) / 2
	for start != end {
		if correct[start] != wrong[start] {
			errors++
		}
		if correct[end] != wrong[end] {
			errors++
		}
		start++
		end--
	}
	if correct[mid] != wrong[mid] {
		errors++
	}
	fmt.Println(errors)
}
