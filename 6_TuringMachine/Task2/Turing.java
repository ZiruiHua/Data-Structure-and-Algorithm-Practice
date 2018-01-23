import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Turing {

    final int MAXLENGTH = 99;
    char[] inTape;
    int state_num;
    int header = 0;
    int currentStateIndex = 0;
    int haltStateIndex;
    //ArrayList<State> states = new ArrayList<>();
    HashMap<Integer, State> map= new HashMap<>();


    public Turing(int state_num) {
        this.state_num = state_num;
        haltStateIndex = state_num - 1;
    }

    public void addState(State state) {
        //states.add(state);
        map.put(state.getIndex(), state);
    }

    public String execute(String input) {
        inTape = new char[MAXLENGTH];
        // fill inTape array with 'B'
        Arrays.fill(inTape, 'B');
        for (int i = 0; i < input.length(); i++) {
            inTape[i] = input.charAt(i);
        }
        // inTape array now is 0101010101010BB...BBB
        // state 0 - '0' -> state 0 ['0'->'1'] go_right
        // state 0 - '1' -> state 0 ['1' -> '0'] go_right
        // state 0 - 'B' -> state 1 ['b' -> 'B'] go_right
        while (currentStateIndex != haltStateIndex) {
            State currentState = map.get(currentStateIndex);
            char currentCharacter = inTape[header];
            // find proper transition
            Transition t = currentState.getStateMap().get(currentCharacter);
            inTape[header] = t.getWriteToTape();
            switch (t.getDirection()) {
                case 'l':
                    header--;
                    break;
                case 'r':
                    header++;
                    break;
            }
            currentStateIndex = t.getNextState();
        }

        return String.valueOf(inTape);
    }

}
