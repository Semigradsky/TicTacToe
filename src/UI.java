
public class UI {

    private static char[] chips = { 'x', 'o' };

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static void drawField(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                char chip = field[i][j] < 0 ? ' ' : chips[field[i][j]];
                System.out.print("[" + chip + "]");
            }
            System.out.println();
        }
    }
}
