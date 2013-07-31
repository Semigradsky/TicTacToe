
// ToDo: change to n size arrays
public class Field {

    private int[][] field;

    public Field(int fieldWidth, int fieldHeight){
        field = new int[fieldWidth][fieldHeight];
        for (int i = 0; i < fieldWidth; i++) {
            for (int j = 0; j < fieldHeight; j++) {
                field[i][j] = -1;
            }
        }
    }

    public boolean hasAvailableMoves() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[][] getField() {
        return field;
    }
}