public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            T[] resizeItems = (T[]) new Object[items.length * 2];
            int position = (nextFirst + 1) % items.length;
            for (int i = 0; i < size; i++) {
                resizeItems[i] = items[position];
                position = (position + 1) % items.length;
            }
            items = resizeItems;
            nextFirst = items.length - 1;
            nextLast = size;
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            T[] resizeItems = (T[]) new Object[items.length * 2];
            int position = (nextFirst + 1) % items.length;
            for (int i = 0; i < size; i++) {
                resizeItems[i] = items[position];
                position = (position + 1) % items.length;
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
        int pos = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            System.out.println(items[pos]);
            pos = (pos + 1) % items.length;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int firstIndex = (nextFirst + 1) % items.length;
        T firstItem = items[firstIndex];
        items[firstIndex] = null;
        nextFirst = firstIndex;
        size -= 1;

        return firstItem;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int lastItemIndex = (nextLast - 1 + items.length) % items.length;
        T lastItem = items[lastItemIndex];
        items[lastItemIndex] = null;
        nextLast = lastItemIndex;
        size -= 1;

        return lastItem;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int pos = (nextFirst + 1 + index) % items.length;
        return items[pos];
    }
}
