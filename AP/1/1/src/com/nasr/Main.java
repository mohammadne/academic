package com.nasr;

public class Main {

    public static void main(String[] args) {
        System.out.println(checkIsPrimary(35, 4));
    }

    // باید ب.م.م 2 عدد برابر 1 باشد
    //میشه مقسوم علیه های یکی رو حساب کزد و با حلقه forEach روی دیگری هم بدست آورد
    private static boolean checkIsPrimary(int num1, int num2) {
        int tmp;
        while (num2 != 0) {
            if (num1 < num2) {
                tmp = num1;
                num1 = num2;
                num2 = tmp;
            }
            tmp = num2;
            num2 = num1 % num2;
            num1 = tmp;
        }
        return num1 == 1;
    }
}
