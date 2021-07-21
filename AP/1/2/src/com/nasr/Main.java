package com.nasr;

public class Main {

    public static void main(String[] args) {
        for (int row = 0; row <= 10; row++) {
            for (int column = 0; column <= 10; column++) {
                System.out.print(String.valueOf(row * column) + ' ');
            }
            System.out.println();
        }
    }
}
