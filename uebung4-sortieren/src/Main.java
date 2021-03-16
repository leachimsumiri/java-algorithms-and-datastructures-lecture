public class Main {

    public static void main(String[] args) {

        int size = 90;
        Element[] elements = new Element[size];

        elements = createElements(elements, size);

        System.out.println("UNSORTIERT:");
        print(elements);
/*
        System.out.println();
        System.out.println("SELECTION SORT:");
        selectionSort(elements);
        print(elements);
*//*
        System.out.println();
        System.out.println("INSERTION SORT:");
        insertionSort(elements);
        print(elements);
*/
        System.out.println();
        System.out.println("QUICK SORT:");
        quickSort(elements, 0, elements.length-1);
        print(elements);
    }

    static Element[] createElements(Element[] e, int size){
        int r;
        //create random elements
        for(int i = 0; i < size; i++) {
            e[i] = new Element();
            r = (int)(Math.random()*size);
            e[i].setIcao("t"+r);
            e[i].setStation("test"+r);
        }/* Test data test data test data
        e[0] = new Element();
        e[0].setIcao("t6");
        e[0].setStation("test6");

        e[1] = new Element();
        e[1].setIcao("t5");
        e[1].setStation("test5");

        e[2] = new Element();
        e[2].setIcao("t1");
        e[2].setStation("test1");

        e[3] = new Element();
        e[3].setIcao("t3");
        e[3].setStation("test3");

        e[4] = new Element();
        e[4].setIcao("t8");
        e[4].setStation("test8");

        e[5] = new Element();
        e[5].setIcao("t4");
        e[5].setStation("test4");

        e[6] = new Element();
        e[6].setIcao("t7");
        e[6].setStation("test7");

        e[7] = new Element();
        e[7].setIcao("t9");
        e[7].setStation("test9");

        e[8] = new Element();
        e[8].setIcao("t2");
        e[8].setStation("test2");
*/
        return e;
    }

    public static void print(Element[] e) {
        for (int i = 0; i < e.length; i++) {
            System.out.println("ICAO: " + e[i].getIcao() + ";   Station: " + e[i].getStation());
        }
    }

    public static void selectionSort(Element[] e){
        for(int i = 0; i < e.length; i++){
            for(int j = i + 1; j < e.length; j++){
                int min = e[i].getStation().compareTo(e[j].getStation());
                //returns > 0 then the parameter passed to the compareTo method is lexicographically first.
                if (min > 0){
                    Element tmp = e[j];
                    e[j] = e[i];
                    e[i] = tmp;
                }
            }
        }
    }

    public static void insertionSort(Element[] e){
        Element temp;
        for(int i = 1; i < e.length; i++){
            temp = e[i];
            int j = i;
            int min = temp.getStation().compareTo(e[j-1].getStation());
            //returns > 0 then the parameter passed to the compareTo method is lexicographically first.
            while (j > 0 && min > 0){
                e[j] = e[j-1];
                j--;
                if(j > 0) {
                    min = temp.getStation().compareTo(e[j - 1].getStation());
                }
            }
            e[j] = temp;
        }
    }

    public static int partition(Element arr[], int left, int right)
    {
        int i = left, j = right;
        Element tmp;
        Element pivot = arr[(left + right) / 2];

        while (i <= j) {
            while ((arr[i].getStation().compareTo(pivot.getStation())) < 0)
                i++;
            while ((arr[j].getStation().compareTo(pivot.getStation())) > 0)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    public static void quickSort(Element arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    public static void mergeSort(Element [] e){

    }

}

