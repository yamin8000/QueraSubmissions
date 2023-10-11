package main

import (
	"fmt"
)

func main() {
	var king, queen, rooks, bishops, knights, pawns int
	_, _ = fmt.Scanln(&king, &queen, &rooks, &bishops, &knights, &pawns)

	king = normal(king, 1)
	queen = normal(queen, 1)
	rooks = normal(rooks, 2)
	bishops = normal(bishops, 2)
	knights = normal(knights, 2)
	pawns = normal(pawns, 8)

	fmt.Printf("%d %d %d %d %d %d", king, queen, rooks, bishops, knights, pawns)
}

func normal(current, top int) int {
	if current == top {
		return 0
	} else if current < top {
		return top - current
	} else {
		return -1 * (current - top)
	}
}
