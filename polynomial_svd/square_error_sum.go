package main

import (
	"math/cmplx"
)

func squareErrorSum(input [][2]complex128, polynomial []complex128) complex128 {
	x := make([]complex128, 0, len(input))
	y := make([]complex128, 0, len(input))

	for index := 0; index < len(input); index++ {
		x = append(x, input[index][0])
		y = append(x, input[index][1])
	}

	sum := complex(0, 0)

	for index := 0; index < len(x); index++ {
		xSum := polynomialSum(polynomial, x[index])
		sum += cmplx.Pow(xSum-y[index], 2)
	}

	return sum
}

func polynomialSum(x []complex128, input complex128) complex128 {
	sum := complex(0, 0)

	for index := 0; index < len(x); index++ {
		sum += x[index] * cmplx.Pow(input, complex(float64(index), 0))
	}

	return sum
}
