package main

import (
	"math/cmplx"
)

func squareErrorSum(a [][]complex128, b []complex128, polynomial []complex128) complex128 {
	sum := complex(0, 0)

	for index := 0; index < len(a); index++ {
		xSum := polynomialSum(a[index], polynomial)
		sum += cmplx.Pow(xSum-b[index], 2)
	}

	return sum
}

func polynomialSum(x []complex128, y []complex128) complex128 {
	sum := complex(0, 0)

	for index := 0; index < len(x); index++ {
		sum += x[index] * y[index]
	}

	return sum
}
