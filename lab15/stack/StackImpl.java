package stack;

public class StackImpl<T> implements Stack<T>{

    StackItem<T> top = null;

    @Override
    public void push(T item) {
        StackItem<T> box = new StackItem<T>(item);
        StackItem<T> previousTop = this.top;
        this.top = box;
        top.setNext(previousTop);
    }

    @Override
    public T pop() {
        T topItem = this.top.getItem();
        this.top = this.top.getNext();
        return topItem;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }



}
