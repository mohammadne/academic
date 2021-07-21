package main

import (
	"image"
	_ "image/jpeg"
	"io"
)

// black rgb : (0, 0, 0)
// white rgb : (255, 255, 255)
func fileVector(file io.Reader) ([]uint32, error) {
	img, _, err := image.Decode(file)
	if err != nil {
		return nil, err
	}

	bounds := img.Bounds()
	yPixles := bounds.Max.Y - bounds.Min.Y
	xPixles := bounds.Max.X - bounds.Min.X

	vector := make([]uint32, 0, yPixles*xPixles)

	for x := bounds.Min.X; x < bounds.Max.X; x++ {
		for y := bounds.Min.Y; y < bounds.Max.Y; y++ {
			r, g, b, _ := img.At(x, y).RGBA()
			avg := (r + g + b) / (3 * 257)
			vector = append(vector, avg)
		}
	}

	return vector, nil
}

func uniformeVector(vector []uint32, max int) []uint32 {
	diff := max - len(vector)

	slice := make([]uint32, diff)
	for index := range slice {
		slice[index] = 255
	}

	newVector := make([]uint32, 0, max)
	newVector = append(newVector, vector...)
	newVector = append(newVector, slice...)
	return newVector
}

func minIndex(vector []int) int {
	min := vector[0]
	minIndex := 0

	for index, num := range vector {
		if num < min {
			minIndex = index
			min = num
		}
	}

	return minIndex
}

func toComplexVector(vector []uint32) []complex128 {
	complexVector := make([]complex128, 0, len(vector))

	for _, number := range vector {
		complexVector = append(complexVector, complex(float64(number), 0))
	}

	return complexVector
}
