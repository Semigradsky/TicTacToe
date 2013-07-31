
public class XOGame {

    public void startGame() {
        Rules rules = Rules.askRules();
        Players players = new Players(rules.countHumans, rules.countRobots);
        Field field = new Field(rules.fieldWidth, rules.fieldHeight);

        while (field.hasAvailableMoves()) {
            for (int moveNumber = 0; moveNumber < rules.countMoves; moveNumber++) {
                UI.drawField(field);
                Move move = players.move(field);
                // ToDo: move
            }
            players.nextPlayer();
        }

    }
}