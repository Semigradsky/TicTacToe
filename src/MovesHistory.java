import java.util.ArrayList;
import java.util.List;

public class MovesHistory {
    private List<Move> moves = new ArrayList<Move>();

    public void add(Move move) {
        moves.add(move);
    }
}
