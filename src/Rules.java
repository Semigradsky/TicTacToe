
public class Rules {
    public static final class CountHumans {
        public static final int Min = 0;
        public static final int Max = 2;
    }

    public static final class CountRobots {
        public static final int Min = 0;
        public static final int Max = 2;
    }

    public static final class CountMoves {
        public static final int Min = 1;
        public static final int Max = 3;
    }

    public static final class CountInRowForWin {
        public static final int Min = 3;
        public static final int Max = 5;
    }

    public Rules() {
        fieldSize[0] = 3;
        fieldSize[1] = 3;
    }

    private int countHumans = 0;
    private int countRobots = 0;
    private int countPlayers = 2;
    private int dimension = 2;
    private int[] fieldSize = new int[2];
    private int countMoves = 1;
    private int countInRowForWin = 3;

    public int getCountHumans() { return  countHumans; }
    public int getCountRobots() { return  countRobots; }
    public int getCountPlayers() { return countPlayers; }
    public int getDimension() { return dimension; }
    public int[] getFieldSize() { return fieldSize; }
    public int getCountMoves() { return countMoves; }
    public int getCountInRowForWin() { return countInRowForWin; }

    public static Rules askRules() {
        Rules rules = new Rules();
        int choice = UI.readNumber("Hello, what game mode to select?\n" +
                "1) Standard game against human.\n" +
                "2) Standard game against robot.\n" +
                "3) No standard game.", 1, 3);

        switch (choice) {
            case GameModes.AgainstHuman:
                rules.countHumans = 2;
                rules.countRobots = 0;
                break;
            case GameModes.AgainstRobot:
                rules.countHumans = 1;
                rules.countRobots = 1;
                break;
            case GameModes.NoStandardGame:
                rules.countHumans = UI.readNumber("How many human players?", CountHumans.Min, CountHumans.Max);
                rules.countRobots = UI.readNumber("How many robot players?", CountRobots.Min, CountRobots.Max);

                rules.dimension = UI.readNumber("What are the demensions of a space? (default = 2)", 2, 3);
                rules.fieldSize = new int[rules.dimension];
                for (int i = 0; i < rules.dimension; i++) {
                    rules.fieldSize[i] = UI.readNumber("How many cells in " + (i + 1) + " dimension?", 1, 30);
                }

                rules.countMoves = UI.readNumber("How many moves? (default = 1)", CountMoves.Min, CountMoves.Max);

                rules.countInRowForWin = UI.readNumber("How many in row for win? (default = 3)", CountInRowForWin.Min, CountInRowForWin.Max);
                break;
            default:
                return askRules();
        }
        rules.countPlayers = rules.countHumans + rules.countRobots;
        return rules;
    }
}