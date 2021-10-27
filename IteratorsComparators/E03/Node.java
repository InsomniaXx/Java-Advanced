package Advanced.IteratorsComparators.E03;

import java.util.Iterator;

public class Node<Integer> {
    public int element;
    public Node<Integer> prev;

    public Node(int element) {
        this.element = element;
        this.prev = null;
    }


}
