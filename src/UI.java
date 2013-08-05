import java.util.Collection;
import java.util.Scanner;

public class UI {
    private static Scanner scanner = new Scanner(System.in);

    private static char[] chips = { 'x', 'o', '#', '$' };

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static void drawField(Field field) throws NotImplementedException {
        Collection<int[][]> array = field.getField();
        for (int[][] d2Field : array) {
            for (int i = 0; i < d2Field.length; i++) {
                for (int j = 0; j < d2Field[0].length; j++) {
                    char chip = d2Field[i][j] < 0 ? ' ' : chips[d2Field[i][j]];
                    System.out.print("[" + chip + "]");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static int readNumber(String text) {
        showMessage(text);
        return readNumber();
    }

    public static int readNumber(String text, int minValue, int maxValue) {
        showMessage(text);
        return readNumber(minValue, maxValue);
    }

    public static String readString(String text) {
        showMessage(text);
        return scanner.nextLine();
    }

    public static int readNumber() {
        int number;
        try {
            number = Integer.parseInt(scanner.next());
            scanner.nextLine();
        } catch (NumberFormatException ex) {
            showMessage("Please, enter number value.");
            return readNumber();
        }
        return number;
    }

    public static int readNumber(int minValue, int maxValue) {
        int number;
        try {
            number = Integer.parseInt(scanner.next());
            scanner.nextLine();
            if (number < minValue || number > maxValue) {
                showMessage("Please, enter number in range: [" + minValue + "; " + maxValue + "]");
                return readNumber(minValue, maxValue);
            }
        } catch (NumberFormatException ex) {
            showMessage("Please, enter number value.");
            return readNumber();
        }
        return number;
    }
}
