package main

import "fmt"

func main() {
	var n float32
	var m float32
	_, _ = fmt.Scan(&n, &m)
	bmi := n / (m * m)
	fmt.Printf("%.2f", bmi)
	fmt.Println()
	if bmi < 18.5 {
		fmt.Println("Underweight")
	} else if bmi < 25 {
		fmt.Println("Normal")
	} else if bmi < 30 {
		fmt.Println("Overweight")
	} else {
		fmt.Println("Obese")
	}
}
