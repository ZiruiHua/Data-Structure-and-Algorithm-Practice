public class TuringSubtractor {
    public static void main(String args[]) {
        Turing machine1 = new Turing(7);

        State s0 = new State(0);
        s0.addTransition(new
                Transition('0', 'B', Transition.RIGHT, 1));

        State s1 = new State(1);
        s1.addTransition(new
                Transition('0', '0', Transition.RIGHT, 1));
        s1.addTransition(new
                Transition('1', '1', Transition.RIGHT, 2));

        State s2 = new State(2);
        s2.addTransition(new
                Transition('1', '1', Transition.RIGHT, 2));
        s2.addTransition(new
                Transition('0', '1', Transition.LEFT, 3));

        State s3 = new State(3);
        s3.addTransition(new
                Transition('0', '0', Transition.LEFT, 3));
        s3.addTransition(new
                Transition('1', '1', Transition.LEFT, 3));
        s3.addTransition(new
                Transition('B', 'B', Transition.RIGHT, 0));

        State s4 = new State(4);
        s2.addTransition(new
                Transition('B', 'B', Transition.LEFT, 4));
        s4.addTransition(new
                Transition('1', 'B', Transition.LEFT, 4));
        s4.addTransition(new
                Transition('0', '0', Transition.LEFT, 4));
        s4.addTransition(new
                Transition('B', '0', Transition.RIGHT, 6));

        State s5 = new State(5);
        s0.addTransition(new
                Transition('1', 'B', Transition.RIGHT, 5));
        s5.addTransition(new
                Transition('0', 'B', Transition.RIGHT, 5));
        s5.addTransition(new
                Transition('1', 'B', Transition.RIGHT, 5));
        s5.addTransition(new
                Transition('B', 'B', Transition.RIGHT, 6));

        machine1.addState(s0);
        machine1.addState(s1);
        machine1.addState(s2);
        machine1.addState(s3);
        machine1.addState(s4);
        machine1.addState(s5);

        String inTape = "0000100";     // Define some input

        System.out.println(inTape);

        String outTape = machine1.execute(inTape);  // Execute the machine

        System.out.println(outTape);  // Show the machine’s output
    }
}

