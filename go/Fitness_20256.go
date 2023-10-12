package main

import "fmt"

func main() {
	var input string
	_, _ = fmt.Scanln(&input)
	if isGood(input) {
		fmt.Println("rahat baash")
	} else {
		fmt.Println("nakhor lite")
	}
}

func isGood(input string) bool {
	var reds = 0
	var yellow = 0
	var greens = 0
	for i := 0; i < len(input); i++ {
		current := string(input[i])
		if current == "R" {
			reds++
		} else if current == "Y" {
			yellow++
		} else if current == "G" {
			greens++
		}
		if reds >= 3 {
			return false
		}
		if reds >= 2 && yellow >= 2 {
			return false
		}
	}
	return greens != 0
}
