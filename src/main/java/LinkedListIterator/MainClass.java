package LinkedListIterator;

public class MainClass {
    public static void main(String[] args) {

        LinkedList<Integer> listOfIntegers = new LinkedList<Integer>();
        listOfIntegers.add(1);
        listOfIntegers.add(2);
        listOfIntegers.add(3);
        listOfIntegers.add(4);
        listOfIntegers.add(5);
        listOfIntegers.add(6);
        listOfIntegers.add(7);
        listOfIntegers.add(8);

        listOfIntegers.print();
        listOfIntegers.addToBeginning(99);
        listOfIntegers.print();
        listOfIntegers.checkIfEmpty();
        listOfIntegers.extractAndDeleteFromEnd();
        listOfIntegers.extractAndDeleteFromBeginning();
        listOfIntegers.print();
        listOfIntegers.extractFromBeginning();
        listOfIntegers.extractFromEnd();
        listOfIntegers.addToEnd(23);
        listOfIntegers.print();
        listOfIntegers.checkIfThereIsValue(6);
        //listOfIntegers.modifyEachElement(77);
        //listOfIntegers.print();

        System.out.println("");


        LinkedList<String> listOfStrings = new LinkedList<String>();
        listOfStrings.add("List");
        listOfStrings.add("is");
        listOfStrings.add("working");
        listOfStrings.add("somehow");
        listOfStrings.add("right");
        listOfStrings.add("now");

        listOfStrings.print();
        listOfStrings.addToBeginning("bzzzz");
        listOfStrings.print();
        listOfStrings.checkIfEmpty();
        listOfStrings.extractAndDeleteFromBeginning();
        listOfStrings.extractAndDeleteFromEnd();
        listOfStrings.print();
        listOfStrings.extractFromBeginning();
        listOfStrings.extractFromEnd();
        listOfStrings.addToEnd("proper");
        listOfStrings.print();
        listOfStrings.checkIfThereIsValue("working");
        //listOfStrings.modifyEachElement("modified");
        //listOfStrings.print();

        for (Integer t: listOfIntegers) {
            System.out.println(t);

        }

        for (String s: listOfStrings) {
            System.out.println(s);
            if(s.equals("proper"))
                break;
        }

        listOfIntegers.headForEach(3, x -> System.out.println(x));

        listOfIntegers.nodeForEach(x -> System.out.println(x), 3);

        System.out.println("");

        listOfStrings.headForEach("right", x -> System.out.println(x));

        listOfStrings.nodeForEach(x -> System.out.println(x), "right");
    }


}

