package homework_3;


import java.util.Iterator;

public class MyIterator<Z> implements Iterator<Z> {
    Node<Z> current;

    public MyIterator(DataList<Z> dl) {
        current = dl.getHead();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Z next() {
        Z data = current.getInfo();
        current = current.getLink();
        return data;
    }
}
