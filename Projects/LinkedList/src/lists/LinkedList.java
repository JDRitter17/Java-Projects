package lists;

public class LinkedList<E> {
    private Link<E> first;
    private Link<E> last;
    private int count;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size (first);

    }
    private int size (Link<E> aLink){
        if(aLink == null){
            return 0;
        }
        return 1 + size(aLink.getNext());
    }

    public void addFirst(E anItem) {
        Link<E> aLink = new Link<>(anItem);
        if (!isEmpty()) {
            first.setPrev(aLink);
            aLink.setNext(first);
            first = aLink;
        }
        if (isEmpty()) {
            last = aLink;
            aLink.setNext(first);
            first = aLink;

        }
    }

    public void addLast(E anItem) {
        Link<E> aLink = new Link<>(anItem);
        if (!isEmpty()) {
            last.setNext(aLink);
            aLink.setPrev(last);
            last = aLink;

        }
        if (isEmpty()) {
            first = aLink;
            aLink.setPrev(last);
            last = aLink;
        }
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E removedItem = first.getItem();
        first = first.getNext();

        if (first == null) {
            last = null;
        } else {
            first.setPrev(null);
        }
        return removedItem;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E removedItem = last.getItem();
        last = last.getPrev();

        if (last == null) {
            first = null;
        } else {

            last.setNext(null);

        }
        return removedItem;
    }

    public E get(int index) {
        if (index < 0) {
            return null;
        }
        Link<E> aLink = first;
        count = 0;
        while (count < index && aLink != null) {
            count++;
            aLink = aLink.getNext();
        }
        if (aLink == null) {
            return null;
        }
        return aLink.getItem();
    }
}
