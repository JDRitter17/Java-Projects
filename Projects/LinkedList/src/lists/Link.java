package lists;

public class Link<E> {
    private E item;
    private Link<E> next;
    private Link<E> prev;

    public Link(E anItem) {
        item = anItem;
    }

    public void setNext(Link<E> aLink) {
        next = aLink;
    }

    public void setPrev(Link<E> aLink) {
        prev = aLink;
    }

    public E getItem() {
        return item;
    }

    public Link<E> getNext() {
        return next;
    }

    public Link<E> getPrev() {
        return prev;
    }
}