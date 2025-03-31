package stack;

public class StackItem <T> {
    private T item;
    private StackItem<T> next;


    public StackItem(T item) {
        this.item = item;
    }

    public StackItem<T> getNext() {
        return this.next;
    }

    public void setNext(StackItem<T> next) {
        this.next = next;
    }

    public T getItem() {
        return this.item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
