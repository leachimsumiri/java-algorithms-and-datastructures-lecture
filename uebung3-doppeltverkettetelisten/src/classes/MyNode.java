package classes;

//LISTENELEMENT
public class MyNode {
    private MyNode next;
    private MyNode prev;
    private int key;
    private String data;

    public MyNode(int key, String data){
        this.next = null;
        this.prev = null;
        this.setKey(key);
        this.setData(data);
    }

    public MyNode getNext(){
        return next;
    }

    public void setNext(MyNode next){
        this.next = next;
    }

    public MyNode getPrev(){
        return prev;
    }

    public void setPrev(MyNode prev){
        this.prev = prev;
    }

    public int getKey(){
        return key;
    }

    public void setKey(int key){
        this.key = key;
    }

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }
}
