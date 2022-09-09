package ua.hillelit.homeworks.main;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(findSymbolOccurrence("Gods", 'G'));
        System.out.println("-".repeat(10));
        System.out.println(findWordPosition("Occurrence", "ccu"));
        System.out.println("-".repeat(10));
        System.out.println(stringReverse("Banana"));
        System.out.println("-".repeat(10));
        System.out.println(isPalindrome("ererere"));
        System.out.println("-".repeat(10));
        guessTheWord();
    }

    public static int findSymbolOccurrence(String str, char ch) {
        if(str == null) {
            return -1;
        }
        int quantityOfSymbols = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                quantityOfSymbols++;
            }
        }
        return quantityOfSymbols;
    }

    public static int findWordPosition(String source, String target) {
        if(source == null || target == null) {
            return -1;
        }
        if (source.contains(target)) {
            return source.indexOf(target);
        }
        return -1;
    }

    public static String stringReverse(String str) {
        if(str == null) {
            return "Ошибка";
        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            arr[str.length() - i - 1] = str.charAt(i);
        }
        return String.valueOf(arr);
    }

    public static boolean isPalindrome(String str) {
        if(str == null) {
            return false;
        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            arr[str.length() - i - 1] = str.charAt(i);
        }
        if(str.equals(String.valueOf(arr))) {
            return true;
        }
        return false;
    }

    public static void guessTheWord() {

        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String hiddenWord = words[random.nextInt(25)];
        System.out.println("Угадайте слово");
        System.out.println(hiddenWord);
        String answer = sc.nextLine();
        checkAnswer(answer, hiddenWord, sc);
    }

    public static boolean checkAnswer(String answer, String hiddenWord, Scanner sc) {

        if (answer.equals(hiddenWord) == true) {
            System.out.println("Верно!");
            return true;
        } else {
            for (int i = 0; i < answer.length(); i++) {
                if (i > answer.length() - 1 || i > hiddenWord.length() - 1) {
                    break;
                } else {
                    if (answer.charAt(i) == hiddenWord.charAt(i)) {
                        System.out.print(answer.charAt(i));
                    } else System.out.print("#");
                }
            }
            System.out.println("#".repeat(15));
            System.out.println("\nПопробуйте снова!");
            answer = sc.nextLine();
            checkAnswer(answer, hiddenWord, sc);
        }
        return false;
    }

}
