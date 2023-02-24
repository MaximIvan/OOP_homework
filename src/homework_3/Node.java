package homework_3;

public class Node<Z> {
    private Z info;
    private Node<Z> link;

    public Node(Z info, Node<Z> link) {
        this.info = info;
        this.link = link;
    }

    public Z getInfo() {
        return info;
    }

    public Node<Z> getLink() {
        return link;
    }

    public void setLink(Node<Z> link) {
        this.link = link;
    }
}
