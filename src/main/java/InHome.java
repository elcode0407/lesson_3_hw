import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InHome {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    public static void main(String args[]) throws IOException {
        wordU();
    }

    private static void wordU() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
                "potato"};
        System.out.println("Вот слова:");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] +" ");
        }
        System.out.println();

        String b1 = getWord(words);
        System.out.println("----------"+b1+"----------");
        String b2 = word(b1);
        System.out.println("Угадай слово:");

        Scanner br = new Scanner(System.in);

        while (true) {
            String user = br.nextLine();
            user = word(user);
            if (b2.equals(user)) {
                System.out.println("Ты угадал!!");
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                int b = sc.nextInt();
                if (b == 1) {
                    wordU();
                } else if (b == 0) {
                    break;
                }
                break;
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < b2.length() - 1; i++) {
                    if (b2.charAt(i) == user.charAt(i)) result.append(b2.charAt(i));
                    else result.append("#");
                }
                System.out.println(result);
                System.out.println("Ты не угадал,еще раз попытайся:");

            }
        }
        gamenumber();
    }

    private static void gamenumber() {

        int rand_int1 = rand.nextInt(9);
        int an = 3;

        System.out.println("Угадай число от 1 до 9:");
        System.out.println("-------------"+rand_int1+"---------------");
        for (int i = 0; i < 4; i++) {

            int a = sc.nextInt();
            if (a <= 9) {
                if (a == rand_int1) {
                    System.out.println("Alright");
                    System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                    int b = sc.nextInt();
                    if (b == 1) {
                        gamenumber();
                    } else if (b == 0) {
                        break;
                    }
                    break;
                } else {
                    if (an != 1) {
                        an--;
                        System.out.println("Попйток осталось: " + an);
                    } else {
                        break;
                    }
                }
            } else {
                System.out.println("Число должно быть меньше или равно 9");
            }
        }

    }

    static String getWord(String[] s) {
        Random r = new Random();
        return s[r.nextInt(s.length - 1)];
    }

    static String word(String s) {
        String word = "###############";
        StringBuilder sBuilder = new StringBuilder(s);
        for (int i = sBuilder.length() - 1; i < word.length() - 1; i++) {
            sBuilder.append(word.charAt(i));
        }
        s = sBuilder.toString();
        return s;

    }
}
