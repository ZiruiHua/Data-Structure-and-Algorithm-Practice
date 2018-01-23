public class Transition {

    public static final char LEFT = 'l';
    public static final char RIGHT = 'r';

    private char originInTape;
    private char writeToTape;
    private char direction;
    private int nextState;


    public Transition(char originInTape, char writeToTape, char direction, int nextState) {
        this.originInTape = originInTape;
        this.writeToTape = writeToTape;
        this.direction = direction;
        this.nextState = nextState;
    }

    public char getOriginInTape() {
        return originInTape;
    }

    public char getWriteToTape() {
        return writeToTape;
    }

    public char getDirection() {
        return direction;
    }

    public int getNextState() {
        return nextState;
    }
}
