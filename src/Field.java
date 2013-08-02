import java.util.ArrayList;
import java.util.Collection;

public class Field {

    int[][] d2Field;
    int[][][] d3Field;

    private int dimension;

    public Field(int dimension, int[] fieldSize) throws NotImplementedException {
        this.dimension = dimension;
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

    public Collection<int[][]> getField() throws NotImplementedException {
        Collection<int[][]> result = new ArrayList<int[][]>();
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
}