/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    /** Creates an empty list. */
    private Integer[] val;
    private int N;
    private int size;
    public AList() {
       N = 2;
       val = new Integer[N];
       size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == N) {
            N = 2 * N;
            Integer[] newVal = new Integer[N];
            for (int i = 0; i < size; i++) {
                newVal[i] = val[i];
            }
            val = newVal;
        }
        val[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        if (size == 0) {
            return 0;
        }

        return val[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        if (i >= size) {
            return -1;
        }
        return val[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        if (size == 0) {
            return 0;
        }
        int lastVal = val[size-1];
        val[size-1] = null;
        size -= 1;
        return lastVal;
    }

}
