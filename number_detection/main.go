package main

import (
	"fmt"
	"os"
)

func main() {
	trainedMatrices := make([][][]uint32, 0, 10)

	for index := 0; index <= 9; index++ {
		dir := fmt.Sprintf("train/%d/", index)
		matrix, err := trainMtrix(dir)
		if err != nil {
			panic(err)
		}

		trainedMatrices = append(trainedMatrices, matrix)
	}

	svdDecompositions := make([]Svd, 0, 10)

	for index := 0; index <= 9; index++ {
		matrix := trainedMatrices[index]
		complexMatrix := make([][]complex128, 0, len(matrix))

		for _, row := range matrix {
			complexRow := make([]complex128, 0, len(row))
			for _, number := range row {
				complexRow = append(complexRow, complex(float64(number), 0))
			}

			complexMatrix = append(complexMatrix, complexRow)
		}

		svd, err := New(complexMatrix)
		if err != nil {
			panic(err)
		}

		svdDecompositions = append(svdDecompositions, svd)
	}

	file, err := os.Open("test/test.jpg")
	if err != nil {
		panic(err)
	}
	defer file.Close()

	testVector, err := fileVector(file)
	if err != nil {
		panic(err)
	}

	Qs := make([]int, 0, 10)

	for index := 0; index <= 9; index++ {
		matrixA := svdDecompositions[index].U
		uniformTestVector := uniformeVector(testVector, len(matrixA))
		matrixb := toComplexVector(uniformTestVector)

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

		// output: squareErrorSum
		errorValue := squareErrorSum(matrixA, matrixb, xMatrix)
		Qs = append(Qs, int(real(errorValue)))
	}

	estimate := minIndex(Qs)
	fmt.Printf("estimate number: %d\n", estimate)
}
