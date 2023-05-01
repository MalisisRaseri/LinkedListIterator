package LinkedListIterator;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;


public class LinkedList <T> implements Iterable<T> {

    private Node head;

    //добавление значения в список
    public void add(T data){
        if(head==null) {
            head = new Node();
            head.data = data;
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node();
            temp.next.data = data;
        }
    }

    //добавление значения в начало списка

    public void addToBeginning (T data){
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    // Извлечение значения из начала списка без его удаления из списка

    public T extractFromBeginning (){
        if (head == null) return null;
        if(head != null){
            T firstData = (T) head.data;
            System.out.println("The first value is " + firstData);
            return(T) firstData;
        }
        else
            throw new NullPointerException("The list is empty");
    }

    // Извлечение значения из начала списка с удалением из списка
    public T extractAndDeleteFromBeginning () {
        if (head != null) {
            T firstData = (T) head.data;
            head= head.next;
            return firstData;
        }
        else
            throw new NullPointerException("The list is empty");
    }

    // добавление значения в конец списка
    public void addToEnd (T data){
        Node node = new Node();
        node.data = data;
        if(head == null){
            head=node;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    //Извлечение значения из конца списка без его удаления
    public T extractFromEnd (){
        if (head != null){
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;}
            System.out.println("The final value is " + temp.data);
            return (T) temp.data;
        }
        else
            throw new IllegalArgumentException("The list is empty");
    }

    //Извлечение значения из конца списка с удалением
    public T extractAndDeleteFromEnd (){
        if (head != null && head.next == null) {
            T firstDate = (T) head.data;
            head = null;
            return firstDate;
        }
        else if(head != null && head.next != null){
            Node temp = head;
            Node tail= head;
            while (temp.next != null){
                tail = temp;
                temp = temp.next;
            }
            T newDate = (T) temp.data;
            temp = tail;
            temp.next= null;
            return newDate;
        }
        else
            throw new NullPointerException("The list is empty");
    }

    // Определение, содержит ли список заданное значение, или нет
    public boolean checkIfThereIsValue (T data) {
        Node temp = head;
        while (temp != null && temp.data != null) {
            if (temp.data.equals(data)) {
                System.out.println("The list contains " + data);
                return true;
            }
            temp = temp.next;

        }
        System.out.println("The list doesn't contain " + data);
        return false;

    }

    // Определение, является ли список пустым, или нет
    public boolean checkIfEmpty (){
        if (head != null)
            System.out.println("The list contains data");
        else System.out.println("The list is empty");

        return true;
    }



    // Метод перебирает при помощи оператора «for-each»: содержимое списка от головного
    // узла до узла с заданным значением; если список заданного значения не содержит,
    // то должно быть перебрано всё содержимое списка
    public void headForEach (T data, Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
            if(t.equals(data))
                break;
        }
    }

    // Метод перебирает при помощи оператора «for-each»: содержимое списка от узла с
    // заданным значением до конца списка; если список заданного значения не содержит,
    // то ничего происходить не должно
    public void nodeForEach (Consumer<? super T> action, T data){
        Objects.requireNonNull(action);
        boolean b = false;
        for (T t: this) {
            if (t.equals(data) == b)
                continue;
            b = true;
            action.accept(t);
        }
    }


    //выполнение действия, заданного в параметре метода, для каждого значения из списка
    public void modifyEachElement(T newData) {
        Node temp = head;

        while (temp != null) {
            temp.data = (T)(newData);
            temp = temp.next;
        }
    }


    //Печать всех значений списка
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(head);
    }

    private class Node <T> {
        Node next;
        T data;
    }

    private class MyIterator <T> implements Iterator<T> {
        private Node<T> current;

        MyIterator (Node<T> current){
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
