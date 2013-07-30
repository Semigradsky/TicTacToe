
import java.util.Scanner;

public class XOGame {

    private Player[] players;
    private int[][] field;
    private Rules rules = new Rules();

    Scanner scanner = new Scanner(System.in);

    public void startGame() {
        selectTheRules();

        rules.countPlayers = rules.countHumans + rules.countRobots;
        fillPlayers(rules.countHumans, rules.countRobots);
        initializeField(rules.fieldWidth, rules.fieldHeight);

        UI.drawField(field);
    }

    private void selectTheRules() {
        UI.showMessage("Hello, what game mode to select?\n1) Standard game against human.\n2) Standard game against robot.\n3) No standard game.");
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.next());
        } catch (NumberFormatException ex) {
            selectTheRules();
            return;
        }

        switch (choice) {
            case 1: // against human
                rules.countHumans = 2;
                break;
            case 2: // against robot
                rules.countHumans = 1;
                rules.countRobots = 1;
                break;
            case 3: // no standard game
                UI.showMessage("How many human players?");
                rules.countHumans = scanner.nextInt();
                UI.showMessage("How many robot players?");
                rules.countRobots = scanner.nextInt();

                UI.showMessage("How many cells horizontally? (default = 3)");
                rules.fieldWidth = scanner.nextInt();
                UI.showMessage("How many cells as vertical? (default = 3)");
                rules.fieldHeight = scanner.nextInt();

                UI.showMessage("How many moves? (default = 1)");
                rules.countMoves = scanner.nextInt();

                break;
            default:
                selectTheRules();
                break;
        }
    }

    private void fillPlayers(int countHumans, int countRobots) {
        Player[] result = new Player[countHumans + countRobots];
        int playerIndex = 0;
        for (int i = 0; i < countHumans; i++) {
            result[playerIndex++] = new Player();
        }
        for (int i = 0; i < countRobots; i++) {
            result[playerIndex++] = new Robot();
        }
        players = result;
    }

    private void initializeField(int fieldWidth, int fieldHeight) {
        field = new int[fieldWidth][fieldHeight];
        for (int i = 0; i < fieldWidth; i++) {
            for (int j = 0; j < fieldHeight; j++) {
                field[i][j] = -1;
            }
        }
    }
}
