
public class Players {
    private Player[] players;

    private int currentMovingPlayerNumber = 0;

    public Players(int countHumans, int countRobots) {
        players = new Player[countHumans + countRobots];
        int playerIndex = 0;
        for (int i = 0; i < countHumans; i++) {
            players[playerIndex] = new Human(playerIndex);
            playerIndex++;
        }
        for (int i = 0; i < countRobots; i++) {
            players[playerIndex] = new Robot(playerIndex);
            playerIndex++;
        }
    }

    public Move move(Field field) throws NotImplementedException {
        return players[currentMovingPlayerNumber].move(field);
    }

    public void nextPlayer() {
        if (currentMovingPlayerNumber == players.length - 1) {
            currentMovingPlayerNumber = 0;
        } else {
            currentMovingPlayerNumber++;
        }
    }

    public Player currentPlayer() {
        return players[currentMovingPlayerNumber];
    }
}