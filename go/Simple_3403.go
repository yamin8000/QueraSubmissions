package main

import (
	"fmt"
	"math"
)

func main() {
	var a, b, c, d float64
	_, _ = fmt.Scan(&a, &b, &c, &d)
	sum := a + b + c + d
	fmt.Printf("Sum : %f\n", sum)
	fmt.Printf("Average : %f\n", sum/4)
	fmt.Printf("Product : %f\n", a*b*c*d)
	fmt.Printf("MAX : %f\n", supermax(a, b, c, d))
	fmt.Printf("MIN : %f\n", supermin(a, b, c, d))
}

func supermin(a, b, c, d float64) float64 {
	return math.Min(a, math.Min(b, math.Min(c, d)))
}
func supermax(a, b, c, d float64) float64 {
	return math.Max(a, math.Max(b, math.Max(c, d)))
}
