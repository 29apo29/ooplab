package stack;

public class StackImpl implements Stack{

    StackItem top = null;

    @Override
    public void push(Object item) {
        StackItem box = new StackItem(item);
        StackItem previousTop = this.top;
        this.top = box;
        top.setNext(previousTop);
    }

    @Override
    public Object pop() {
        Object topItem = this.top.getItem();
        this.top = this.top.getNext();
        return topItem;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

}
