package classes;

//LISTE
public class DoublyLinkedList {
    private int count;
    private MyNode head;
    private MyNode tail;

    public DoublyLinkedList(){
        this.count = 0;
        this.head = null;
        this.tail = null;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public MyNode getHead() {
        return head;
    }

    public void setHead(MyNode head) {
        this.head = head;
    }

    public MyNode getTail() {
        return tail;
    }

    public void setTail(MyNode tail) {
        this.tail = tail;
    }

    //Am Ende der Liste ein Element einfügen
    public void insertEnd(DoublyLinkedList dll, int key, String data){
        setCount(getCount()+1);                     //counter um eins erhöhen weil Anzahl der Elemente verändert sich
        MyNode new_node = new MyNode(key, data);
        if (count == 1){
            dll.setHead(new_node);
        } else {
            dll.getTail().setNext(new_node);        //ursprünglicher Blattknoten kriegt neuen untergeordneten Knoten
            new_node.setPrev(dll.getTail());        //neuer Knoten kriegt den ursprüunglichen Blattknoten als PREV
        }
        dll.setTail(new_node);                      //zuletzt erstellter Knoten ist immer Blattknoten
    }

    //Vor einem bestimmten Knoten einen anderen Knoten einfügen
    public void insertBefore(DoublyLinkedList dll, int key, String data, int key2){
        setCount(getCount()+1);
        MyNode new_node = new MyNode(key, data);
        if(find(dll,key2) == dll.getHead()){                //exception handling
            dll.setHead(new_node);
        } else if(find(dll,key2) == dll.getTail()){         //exception handling
            dll.setTail(new_node);
        } else {
            new_node.setPrev(find(dll, key2).getPrev());    //neuer Node kriegt den PREV vom initial Node
            new_node.setNext(find(dll, key2));              //der initial Node ist nun der NEXT vom neuen Node
            find(dll, key2).getPrev().setNext(new_node);    //neuer Node wird NEXT vom PREV vom initial Node
            find(dll, key2).setPrev(new_node);              //neuer Node wird PREV vom inital node
        }
    }

    //Node löschen
    public void delete(DoublyLinkedList dll, int key){
        setCount(getCount()-1);
        MyNode new_node = find(dll, key);                   //nicht zwingend
        new_node.getPrev().setNext(new_node.getNext());     //der PREV vom gesuchten Node kriegt den NEXT vom gesuchten
        new_node.getNext().setPrev(new_node.getPrev());     //der NEXT vom gesuchten Node kriegt den PREV vom gesuchten
    }

    //Gibt einen gewünschten Knoten zurück
    public MyNode find(DoublyLinkedList dll, int key){
        int j = 1;
        MyNode new_node = dll.getHead();            //beginne die Suche beim Kopf
        while(j <= dll.getCount()){                 //gehe tatsächlich bis zum letzten ( <= )
            if(new_node.getKey() == key) {
                return new_node;
            } else {
                new_node = new_node.getNext();      //gehe zum nächsten knoten wenn keys nicht übereinstimmen
            }
            j++;
        }
        return new_node;
    }

    //Gibt die Liste aus
    public void print(DoublyLinkedList dll){
        if(count == 0){                                         //exception handling
            System.out.println("Achtung die Liste ist leer!");
            return;
        }

        int i = 1;
        MyNode new_node = dll.getHead();           //beginne Ausgabe beim Kopf

        while(i <= dll.getCount()){                     //<= weil der sprung zum Next nach dem Println erfolgt
            System.out.println(new_node.getData());
            new_node = new_node.getNext();
            i++;
        }

        //nochmal Head und Tail verifizieren
        System.out.println("HEAD: " + dll.getHead().getData());
        System.out.println("TAIL: " + dll.getTail().getData());
    }
}
