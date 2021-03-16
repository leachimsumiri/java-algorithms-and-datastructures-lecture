import classes.DoublyLinkedList;
import classes.MyNode;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList(); //erzeuge die Liste

        for(int i = 1; i < 100; i++){            //Anzahl gewünschter Listenelemente
            dll.insertEnd(dll, i, "el"+i);      //erzeuge Listenelemnt
        }

        dll.delete(dll, 92);
        dll.insertBefore(dll, 15000, "el15000", 4);

        dll.print(dll);

        System.out.println(dll.find(dll, 46).getData());  //find verifizeren
    }
}
