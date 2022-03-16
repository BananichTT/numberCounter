import java.util.Scanner;

public class Main {
    public static int a, b;
    public static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String number(String s) {
        String[] subStr = s.split("-"); // строка делится на массив строк

        // конвертация из строки в число
        a = Integer.parseInt(subStr[2]);
        b = Integer.parseInt(subStr[0]);

        // разбор случая введеной строки вида "01-ZZ-99"
        if (subStr[1].equals("ZZ") && a == 99) {
            subStr[1] = "AA"; // "зануляется" второй элемент в массиве
            subStr[2] = "01"; // "зануляется" третий элемент в массиве
            b++; // прибавляется 1 к первому элементо
            String S = Integer.toString(b); // первый элемент массива конвертируется в строку
            if (b < 10) {
                subStr[0] = "0" + S; // добавляем 0 к строке если первый элемент меньше 10
            } else {
                subStr[0] = S;
            }

            // разбор случая введеной строки вида "01-AZ-99"
        } else if (subStr[1].charAt(1) == 'Z' && a == 99) {
            char ch1 = subStr[1].charAt(1); // получили второй символ у второго элемента массива строк subStr
            subStr[2] = "01";
            ch1 = letters[0]; // символу присваевается значение из массиа "A"

            char ch0 = subStr[1].charAt(0); // получил первый символ у второго элемента массива строк subStr

            // поиск символа в массиве букв и присвоение ему следующей по порядку буквы в алфавите
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == ch0) {
                    ch0 = letters[i + 1];
                    break;
                }
            }
            subStr[1] = String.valueOf(ch0) + String.valueOf(ch1); // сибирается второй элемент массива subStr из символов

            // разбор случая введеной строки вида "01-AA-99"
        } else if (a == 99) {
            char ch = subStr[1].charAt(1);

            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == ch) {
                    ch = letters[i + 1];
                    break;
                }
            }
            subStr[1] = String.valueOf(subStr[1].charAt(0)) + String.valueOf(ch);
            subStr[2] = "01";
        } else {
            a++;
            String S = Integer.toString(a);
            if (a < 10) {
                subStr[2] = "0" + S;
            } else {
                subStr[2] = S;
            }
        }
        String arS = String.join("", subStr);

        System.out.println(arS);
        return arS;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите чило строку вида: 01-AA-01");
        number(scanner.nextLine());
    }
}