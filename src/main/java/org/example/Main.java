package org.example;

import java.util.Scanner;

public class Main {
    static String[][] number = new String[][]{
            //   0        1          2         3        4          5       6        7        8         9       10
            {"  @@  ", "   @  ", "  @@  ", " @@@  ", "   @  ", " @@@@ ", "  @@  ", " @@@@ ", "  @@  ", "  @@  "},    //0
            {" @  @ ", "  @@  ", " @  @ ", "    @ ", "  @@  ", " @    ", " @    ", "    @ ", " @  @ ", " @  @ ",},   //1
            {" @  @ ", "   @  ", "    @ ", "  @@  ", " @ @  ", " @@@  ", " @@@  ", "   @  ", "  @@  ", "  @@@ "},    //2
            {" @  @ ", "   @  ", "   @  ", "    @ ", " @@@@ ", "    @ ", " @  @ ", "  @   ", " @  @ ", "    @ ",},   //3
            {"  @@  ", "   @  ", " @@@@ ", " @@@  ", "   @  ", " @@@  ", "  @@  ", " @    ", "  @@  ", "  @@  "},    // 4

    };

    public static String show(int i, String numb) {
        String numbSTR = "";
        String[] strArr = numb.split("");
        for (String str : strArr)
            numbSTR += number[i][Integer.parseInt(str)];
        return numbSTR;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть числа : ");
        String numb = scanner.nextLine();
        try {
            System.out.print("\n");
            for (int i = 0; i < 5; i++) {
                System.out.println(show(i, numb));
            }
        } catch (NumberFormatException e) {
            System.out.println("Введено не число або деякі символи не є цифрами.");
        }
        scanner.close();
    }
}