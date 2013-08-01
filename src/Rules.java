
public class Rules {
    public static final class CountHumans {
        public static final int Min = 0;
        public static final int Max = 10;
    }

    public static final class CountRobots {
        public static final int Min = 0;
        public static final int Max = 10;
    }

    public static final class CountMoves {
        public static final int Min = 1;
        public static final int Max = 3;
    }

    private int countHumans = 0;
    private int countRobots = 0;
    private int countPlayers = 2;
    private int fieldWidth = 3;
    private int fieldHeight = 3;
    private int countMoves = 1;

    public int getCountHumans() { return  countHumans; }
    public int getCountRobots() { return  countRobots; }
    public int getCountPlayers() { return countPlayers; }
    public int getFieldWidth() { return  fieldWidth; }
    public int getFieldHeight() { return fieldHeight; }
    public int getCountMoves() { return countMoves; }

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
                rules.countHumans = UI.readNumber("How many human players?", Rules.CountHumans.Min, Rules.CountHumans.Max);
                rules.countRobots = UI.readNumber("How many robot players?", Rules.CountRobots.Min, Rules.CountRobots.Max);

                // ToDo: change to n size fields
                rules.fieldWidth = UI.readNumber("How many cells horizontally?", 1, 30);
                rules.fieldHeight = UI.readNumber("How many cells as vertical?", 1, 30);

                rules.countMoves = UI.readNumber("How many moves? (default = 1)", Rules.CountMoves.Min, Rules.CountMoves.Max);

                break;
            default:
                return askRules();
        }
        rules.countPlayers = rules.countHumans + rules.countRobots;
        return rules;
    }
}