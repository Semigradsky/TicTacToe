import java.util.ArrayList;

public class Field {

    private int[][] d2Field;
    private int[][][] d3Field;

    private int dimension;
    private int countInRowForWin;

    public Field(int dimension, int[] fieldSize, int countInRowForWin) throws NotImplementedException {
        this.dimension = dimension;
        this.countInRowForWin = countInRowForWin;
        switch (dimension) {
            case 2:
                d2Field = new int[fieldSize[0]][fieldSize[1]];
                for (int i = 0; i < fieldSize[0]; i++) {
                    for (int j = 0; j < fieldSize[1]; j++) {
                        d2Field[i][j] = -1;
                    }
                }
                break;
            case 3:
                d3Field = new int[fieldSize[0]][fieldSize[1]][fieldSize[2]];
                for (int i = 0; i < fieldSize[0]; i++) {
                    for (int j = 0; j < fieldSize[1]; j++) {
                        for (int z = 0; z < fieldSize[2]; z++) {
                            d3Field[i][j][z] = -1;
                        }
                    }
                }
                break;
            default:
                throw new NotImplementedException();
        }
    }

    public boolean hasAvailableMoves() throws NotImplementedException {
        switch (dimension) {
            case 2:
                return hasAvailableMoves(d2Field);
            case 3:
                return hasAvailableMoves(d3Field);
            default:
                throw new NotImplementedException();
        }
    }

    public ArrayList<int[][]> getField() throws NotImplementedException {
        ArrayList<int[][]> result = new ArrayList<int[][]>();
        switch (dimension) {
            case 2:
                result.add(d2Field);
                return result;
            case 3:
                for (int[][] field : d3Field) {
                    result.add(field);
                }
                return result;
            default:
                throw new NotImplementedException();
        }
    }

    private boolean hasAvailableMoves(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == -1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasAvailableMoves(int[][][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                for (int z = 0; z < field[0][0].length; z++) {
                    if (field[i][j][z] == -1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean playerIsWin(Player player) throws NotImplementedException {
        int playerId = player.getPlayerId();

        // countInRowForWin

        switch (dimension) {
            case 2:

                return false;
            case 3:
                // ToDo: implement
                return false;
            default:
                throw new NotImplementedException();
        }
    }

    public void writeMove(Move move, Player player) throws NotImplementedException {
        int[] moveCoordinate = move.getMoveCoordinate();
        switch (dimension) {
            case 2:
                d2Field[moveCoordinate[0]][moveCoordinate[1]] = player.getPlayerId();
                break;
            case 3:
                d3Field[moveCoordinate[0]][moveCoordinate[1]][moveCoordinate[2]] = player.getPlayerId();
                break;
            default:
                throw new NotImplementedException();
        }
    }
}