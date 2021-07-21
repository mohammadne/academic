package main

import "math/cmplx"

// return matrix A and Matrix b
func reciever() ([][2]complex128, [][]complex128, []complex128) {
	m := 2

	input := [][2]complex128{
		{0.0, 1.0},
		{0.25, 1.284},
		{0.5, 1.6487},
		{0.75, 2.117},
		{1.0, 2.7183},
	}

	matrixA := make([][]complex128, 0, len(input))
	for index := 0; index < len(input); index++ {
		coefs := calculateCoefficients(m, input[index][0])
		matrixA = append(matrixA, coefs)
	}

	matrixb := make([]complex128, 0, len(input))
	for index := 0; index < len(input); index++ {
		matrixb = append(matrixb, input[index][1])
	}

	return input, matrixA, matrixb
}

func calculateCoefficients(m int, x complex128) []complex128 {
	res := make([]complex128, 0, m+1)

	for index := 0; index <= m; index++ {
		res = append(res, cmplx.Pow(x, complex(float64(index), 0)))
	}

	return res
}
