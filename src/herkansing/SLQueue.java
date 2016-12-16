package herkansing;

/**
 * Created by thom
 * On 16-12-2016.
 */
public class SLQueue<T> {
    SLList start;
    SLList einde;

    public void enqueue(T item){
        if(start == null) {
            start = new SLList(item);
        } else {
            start.add(item);
        }
        einde = start.getReversedSLList();
    }

    public T dequeue() {
        T temp = (T) einde.hd();
        start.removeFirst();
        einde = start.getReversedSLList();
        return temp;
    }

    public String toString(){

        return einde.toString() + "|" + start.toString();
    }
}
