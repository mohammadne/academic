package main

import (
	"io/ioutil"
	"os"
)

func trainMtrix(directory string) ([][]uint32, error) {
	files, err := ioutil.ReadDir(directory)
	if err != nil {
		return nil, err
	}

	matrix := make([][]uint32, 0, len(files))

	maxLength := 0
	for _, fileInfo := range files {
		file, err := os.Open(directory + fileInfo.Name())
		if err != nil {
			return nil, err
		}
		defer file.Close()

		vector, err := fileVector(file)
		if err != nil {
			return nil, err
		}

		if length := len(vector); length > maxLength {
			maxLength = length
		}

		matrix = append(matrix, vector)
	}

	uniform := uniformeMatrix(matrix, maxLength)
	transpose := transposeMatrix(uniform)
	return transpose, nil
}

func uniformeMatrix(matrix [][]uint32, max int) [][]uint32 {
	for index := 0; index < len(matrix); index++ {
		if diff := max - len(matrix[index]); diff > 0 {
			matrix[index] = uniformeVector(matrix[index], max)
		}
	}

	return matrix
}

func transposeMatrix(slice [][]uint32) [][]uint32 {
	xl := len(slice[0])
	yl := len(slice)
	result := make([][]uint32, xl)

	for i := range result {
		result[i] = make([]uint32, yl)
	}

	for i := 0; i < xl; i++ {
		for j := 0; j < yl; j++ {
			result[i][j] = slice[j][i]
		}
	}

	return result
}
