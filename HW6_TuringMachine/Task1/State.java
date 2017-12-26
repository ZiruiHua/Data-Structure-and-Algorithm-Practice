import java.util.ArrayList;
import java.util.HashMap;

public class State {

    private int index;
    private ArrayList<Transition> transitions = new ArrayList<>();
    private HashMap<Character, Transition> stateMap = new HashMap<>();
    public State(int state) {
        this.index = state;
    }

    public void addTransition(Transition transition) {
        stateMap.put(transition.getOriginInTape(), transition);
        transitions.add(transition);
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public int getIndex() {
        return index;
    }

    public HashMap<Character, Transition> getStateMap() {
        return stateMap;
    }
}
