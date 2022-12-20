public class LinkedListDeque<T> {
    public static class ItemNode<T> {
        T item;
        ItemNode<T> next;
        ItemNode<T> prev;

        public ItemNode(T item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    private ItemNode<T> sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new ItemNode<>(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new ItemNode<>(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        ItemNode<T> otherFirst = other.sentinel.next;
        for (int i = 0; i < other.size(); i++) {
            addLast(otherFirst.next.item);
            size += 1;
        }
    }

    public void addFirst(T item) {
        ItemNode<T> newNode = new ItemNode<>(item);
        if (size == 0) {
            sentinel.next = newNode;
            sentinel.prev = newNode;
            newNode.next = sentinel;
            newNode.prev = sentinel;
        } else {
            ItemNode<T> originFirst = sentinel.next;
            sentinel.next = newNode;
            newNode.next = originFirst;
            originFirst.prev = newNode;
            newNode.prev = sentinel;
        }
        size += 1;
    }

    public void addLast(T item) {
        ItemNode<T> newNode = new ItemNode<>(item);
        if (size == 0) {
            sentinel.next = newNode;
            sentinel.prev = newNode;
            newNode.next = sentinel;
            newNode.prev = sentinel;
        } else {
            ItemNode<T> originEnd = sentinel.prev;
            sentinel.prev = newNode;
            newNode.prev = originEnd;
            originEnd.next = newNode;
            newNode.next = sentinel;
        }
        size += 1;
    }

    public boolean isEmpty() {
       return size == 0;
    }

    public int size() {
       return size;
    }

    public void printDeque() {
        ItemNode<T> p = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.println(p.next.item);
            p = p.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        ItemNode<T> first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size -= 1;
        return first.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        ItemNode<T> last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size -= 1;
        return last.item;
    }

    public T get(int index) {
        if (index >= size || index < 0)
            return null;

        ItemNode<T> p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }

    public T getRecursiveHelper(ItemNode<T> start, int index) {
        if (size == 0) {
            return null;
        }
        if (start == sentinel) {
            return null;
        }
        if (index == 0) {
            return start.item;
        }
        return getRecursiveHelper(start.next, index - 1);
    }

    private int getCurrent(ItemNode<T> current) {
        if (current == sentinel) {
            return 0;
        }
        return getCurrent(current.prev) + 1;
    }
}
