
public abstract class Player {
    protected int playerId;

    public abstract Move move(Field field) throws NotImplementedException;

    public int getPlayerId() {
        return playerId;
    }
}
