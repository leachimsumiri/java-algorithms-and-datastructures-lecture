package fh.campus.wien.algorithmen.datenstrukturen.ue.lib;

public class Leaf {

    public Node n;
    public Leaf prev;
    public Leaf next;
    int key;
    public Leaf(Node n){
        this.n = n;
        key = n.endTime;
        this.prev = this.next = null;
    }


}
