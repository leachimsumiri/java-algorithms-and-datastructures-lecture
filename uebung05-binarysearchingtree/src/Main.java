import classes.MyNode;
import classes.Tree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Tree binaryTree = new Tree();

        Scanner sc = new Scanner(System.in);

        binaryTree.insertNode(binaryTree, 5, "Peter5");
        binaryTree.insertNode(binaryTree, 100, "Peter100");
        binaryTree.insertNode(binaryTree, 1, "Peter1");
        binaryTree.insertNode(binaryTree, 10, "Peter10");

        System.out.println();
        binaryTree.print(binaryTree.getRootNode());
        System.out.println();

        System.out.println("0 = QUIT");
        System.out.println("1 = ADD");
        System.out.println("2 = SEARCH");
        int input = sc.nextInt();

        switch(input){
            case 1:
                System.out.println("Key:");
                int personKey = sc.nextInt();
                System.out.println("Name:");
                String personName = sc.next();

                MyNode newNode = binaryTree.search(binaryTree.getRootNode(),personKey);

                if(newNode== null){
                    binaryTree.insertNode(binaryTree, personKey, personName);
                }else{
                    System.out.print("Diese Personennummer ist bereits vergeben!");
                }

                System.out.println();
                System.out.println("New Tree:");
                System.out.println();
                binaryTree.print(binaryTree.getRootNode());
                System.out.println();
            case 2:
                while(true) {
                    System.out.println();
                    System.out.println("Search Key: (type 0 to quit)");
                    int searchKey = sc.nextInt();
                    if (searchKey == 0) {
                        return;
                    }
                    MyNode searching = binaryTree.search(binaryTree.getRootNode(), searchKey);
                    if(searching == null){
                        System.out.println("Personaldaten nicht gefunden!");
                    } else {
                        System.out.println("Gefunden! Name von Key " + searching.getKey() + ": " + searching.getName());
                    }
                }
            default:
                return;
        }
    }
}
