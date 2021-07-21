package main

func multiply(a [][]complex128, b []complex128) []complex128 {
	res := make([]complex128, len(a))

	for index1 := 0; index1 < len(a); index1++ {
		sum := complex(0, 0)
		for index2 := 0; index2 < len(b); index2++ {
			sum += a[index1][index2] * b[index2]
		}

		res[index1] = sum
	}

	return res
}
