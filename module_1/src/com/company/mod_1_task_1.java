package com.company;
import java.util.Scanner;

public class mod_1_task_1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int z;
        System.out.print ("Введите значение a: ");
        int a = console.nextInt();
        System.out.print ("Введите значение b: ");
        int b = console.nextInt();
        System.out.print ("Введите значение c: ");
        int c = console.nextInt();
        z = ((a - 3) * b / 2) + c;
        System.out.println ("((a–3)*b/2)+c = " + z);
    }
}
