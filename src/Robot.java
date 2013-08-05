import java.util.ArrayList;
import java.util.Random;

public class Robot extends Player {
    private static Random random = new Random();

    public Robot(int playerIndex) {
        this.playerId = playerIndex;
    }

    public Move move(Field field) throws NotImplementedException {
        ArrayList<int[][]> f = field.getField();
        switch (f.size()) {
            case 2:
                return new Move(getRandomMove(f.get(0)));
            case 3:
                return new Move(getRandomMove(f.toArray(new int[f.get(0).length][f.get(0)[0].length][f.size()])));
            default:
                throw new NotImplementedException();
        }
    }

    private int[] getRandomMove(int[][] field) {
        int x, y;
        do {
            x = random.nextInt(field.length);
            y = random.nextInt(field[0].length);
        } while (field[x][y] != -1);
        return new int[] { x, y };
    }

    private int[] getRandomMove(int[][][] field) {
        int x, y, z;
        do {
            x = random.nextInt(field.length);
            y = random.nextInt(field[0].length);
            z = random.nextInt(field[0][0].length);
        } while (field[x][y][z] != -1);
        return new int[] { x, y, z };
    }
}
