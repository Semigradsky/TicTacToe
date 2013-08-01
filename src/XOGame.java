
public class XOGame {

    public void startGame() {
        Rules rules = Rules.askRules();
        Players players = new Players(rules.getCountHumans(), rules.getCountRobots());
        Field field = new Field(rules.getFieldWidth(), rules.getFieldHeight());

        while (field.hasAvailableMoves()) {
            for (int moveNumber = 0; moveNumber < rules.getCountMoves(); moveNumber++) {
                UI.drawField(field);
                Move move = players.move(field);
                // ToDo: move
            }
            players.nextPlayer();
        }

    }
}