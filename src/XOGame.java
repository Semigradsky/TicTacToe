import java.util.ArrayList;
import java.util.List;

public class XOGame {

    public void startGame() throws NotImplementedException {
        List<Move> movesHistory = new ArrayList<Move>();
        Rules rules = Rules.askRules();
        Players players = new Players(rules.getCountHumans(), rules.getCountRobots());
        Field field = new Field(rules.getDimension(), rules.getFieldSize());

        while (field.hasAvailableMoves()) {
            for (int moveNumber = 0; moveNumber < rules.getCountMoves(); moveNumber++) {
                UI.drawField(field);
                Move move = players.move(field);
                movesHistory.add(move);
                // ToDo: move
            }
            players.nextPlayer();
        }

    }
}