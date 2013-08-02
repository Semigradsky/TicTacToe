public class Main {
    public static void main(String[] args) {
        XOGame game = new XOGame();
        try {
            game.startGame();
        } catch (NotImplementedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}