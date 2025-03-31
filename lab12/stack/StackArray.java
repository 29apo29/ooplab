package stack;

import java.util.ArrayList;

public class StackArray implements Stack {
    private ArrayList<Object> stack = new ArrayList<>();

    @Override
    public void push(Object item) {
        this.stack.add(0, item);
    }

    @Override
    public Object pop() {
        return this.stack.remove(0);
    }

    @Override
    public boolean isEmpty() {
        // return this.stack.isEmpty();
        return stack.size() == 0;
    }
}
