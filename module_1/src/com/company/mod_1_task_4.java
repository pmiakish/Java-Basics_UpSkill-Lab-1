package com.company;
import java.util.Locale;
import java.util.Scanner;

public class mod_1_task_4 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.print ("Введите значение действительное число формата \"nnn.ddd\": ");
        double x;
        x = console.nextDouble();
        String[] xStr = String.valueOf(x).split("\\."); // делим строковое представление числа, разделитель - точка
            if (xStr[0].length() == 3 && xStr[1].length() == 3) { // проверяем количество символов в целой и дробной части
               String dnStr = (xStr[1] + "." + xStr[0]); // меняем целую и дробную часть местами (String)
               double dn = Double.parseDouble(dnStr); // конвертируем результат в double
               System.out.println (dn);
            }
            else {
                System.out.println ("Неверный формат числа!");
            }
    }
}
