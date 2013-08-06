
public class XOGame {

    public void startGame() throws NotImplementedException {
        MovesHistory movesHistory = new MovesHistory();
        Rules rules = Rules.askRules();
        Players players = new Players(rules.getCountHumans(), rules.getCountRobots());
        Field field = new Field(rules.getDimension(), rules.getFieldSize(), rules.getCountInRowForWin());

        while (field.hasAvailableMoves() || field.playerIsWin(players.currentPlayer())) {
            for (int moveNumber = 0; moveNumber < rules.getCountMoves(); moveNumber++) {
                UI.drawField(field);
                Move move = players.move(field);
                movesHistory.add(move);
                field.writeMove(move, players.currentPlayer());
            }
            players.nextPlayer();
        }

    }
}