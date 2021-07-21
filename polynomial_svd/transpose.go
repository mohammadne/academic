package main

func transpose(slice [][]complex128) [][]complex128 {
	xl := len(slice[0])
	yl := len(slice)
	result := make([][]complex128, xl)

	for i := range result {
		result[i] = make([]complex128, yl)
	}

	for i := 0; i < xl; i++ {
		for j := 0; j < yl; j++ {
			result[i][j] = slice[j][i]
		}
	}

	return result
}
