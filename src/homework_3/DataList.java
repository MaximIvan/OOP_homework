package homework_3;

import java.util.Iterator;

public class DataList<Z> implements Iterable<Z> {
    private Node<Z> first;
    private Node<Z> second;
    public void add(Z data) {
        Node<Z> node = new Node<Z> (data, null);
        if (first == null) {
            first = second = node;
        }else {
            second.setLink(node);
            second = node;
        }
    }
    public Node<Z> getHead() {
        return first;
    }

    public Node<Z> getSecond() {
        return second;
    }

    @Override
    public Iterator<Z> iterator() {
        return new MyIterator<Z>(this);
    }
}
