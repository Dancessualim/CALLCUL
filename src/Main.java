import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String expression = scanner.nextLine();
        System.out.println(anls(expression));
    }
    public static String anls(String expression) throws Exception {
        int num1, num2;
        String oper;
        String result;
        boolean isRom;
        String[] Numb = expression.split("[+\\-*/]");
        oper = detectOperation(expression);
        if (oper == null) throw new Exception("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления ");
        if (Numb.length != 2) throw new Exception("Калькулятор умеет выполнять операции только с двумя числами");
        if (Rom.isRom(Numb[0]) && Rom.isRom(Numb[1])) {
            num1 = Rom.convertToArab(Numb[0]);
            num2 = Rom.convertToArab(Numb[1]);


            isRom = true;
        }

        else if (!Rom.isRom(Numb[0]) && !Rom.isRom(Numb[1])) {
            num1 = Integer.parseInt(Numb[0]);
            num2 = Integer.parseInt(Numb[1]);
            isRom = false;
        }

        else {
            throw new Exception("Числа должны быть одной системы счисления");
        }
        if (num1 >10 || num2 >10) {
            throw new Exception("Числа должны быть от 0 до 10");
        }

        int arab = calc(num1, num2, oper);
        if (isRom) {
            if (arab <= 0) {
                throw new Exception("Римское число не может быть ниже единицы");
            }

            result = Rom.convertToRom(arab);

        } else {
            result = String.valueOf(arab);
        }
        return result;
    }
    static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }
     static int calc (int a, int b, String oper) {
         return switch (oper) {
             case "+" -> a + b;
             case "-" -> a - b;
             case "*" -> a * b;
             default -> a / b;
         }; //почему
        }
     }

     class Rom {
         static String[] Rommas = new String[]{
                 "-", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                 "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                 "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                 "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                 "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                 "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                 "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                 "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                 "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                 "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

         public static boolean isRom(String val) {
             for (String s : Rommas) {
                 if (val.equals(s)) {
                     return true;

                 }
             }
             return false;
         }
         public static int convertToArab(String rom) {
             for (int i = 0; i < Rommas.length; i++) {
                 if (rom.equals(Rommas[i])) {
                     return i;
             }
             }
             return -1;
     }
      public static String convertToRom(int arab) {
         return  Rommas[arab];
         }
     }