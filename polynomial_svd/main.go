package main

import "fmt"

func main() {
	input, matrixA, matrixb := reciever()

	svd, err := New(matrixA)
	if err != nil {
		panic("error in input")
	}

	cMatrix := multiply(transpose(svd.U), matrixb)

	zMatrix := make([]complex128, 0, len(cMatrix))
	for index := 0; index < len(cMatrix); index++ {
		element := cMatrix[index] / complex(svd.S[index], 0)
		zMatrix = append(zMatrix, element)
	}

	// output: Pm polynomial coefficients in order (a0, a1, ..., an)
	xMatrix := multiply(svd.V, zMatrix)
	fmt.Println(xMatrix)

	// output: squareErrorSum
	errorValue := squareErrorSum(input, xMatrix)
	fmt.Println(errorValue)
}
