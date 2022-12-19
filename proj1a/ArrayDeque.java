public class ArrayDeque<T> {
    //    Glorp[] items = (Glorp[]) new Object[8];
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 8;
    }

    public void addFrist(T item) {
        if (size == items.length) {
            T[] resizeItems = (T[]) new Object[items.length * 2];
            int position = nextFirst;
            for (int i = 0; i < size; i++) {
                resizeItems[i] = items[position];
                position = (position + 1) % size;
            }
            items = resizeItems;
            nextFirst = items.length - 1;
            nextLast = size;
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst + 1) % items.length;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            T[] resizeItems = (T[]) new Object[items.length * 2];
            int position = nextFirst;
            for (int i = 0; i < size; i++) {
                resizeItems[i] = items[position];
                position = (position + 1) % size;
            }
            items = resizeItems;
            nextFirst = items.length - 1;
            nextLast = size;
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        if (size == 0) {
            return;
        }
        int pos = nextFirst;
        for (int i = 0; i < size; i++) {
            System.out.println(items[pos]);
            pos = (pos + 1) % items.length;
        }
    }

    public T removeFirst() {
        return null;
    }

    public T removeLast() {
        return null;
    }

    public T get(int index) {
        return null;
    }
}
