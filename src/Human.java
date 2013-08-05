
public class Human extends Player {

    public Human(int playerIndex) {
        this.playerId = playerIndex;
    }

    public Move move(Field field) {
        String turn = UI.readString("Your turn:");
        return new Move(parseTurn(turn));
    }

    private int[] parseTurn(String turn) {
        String[] tmp_arr = turn.split(" ");
        int[] turns = new int[tmp_arr.length];
        for (int i = 0; i < tmp_arr.length; i++) {
            int number = 0;
            try {
                number = Integer.parseInt(tmp_arr[i]);
            } catch (NumberFormatException ex) {
            } finally {
                turns[i] = number;
            }
        }
        return turns;
    }
}
