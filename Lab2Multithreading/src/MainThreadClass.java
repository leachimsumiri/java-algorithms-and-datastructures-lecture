public class MainThreadClass {
    public static int size = 300;
    public static int[] arr = new int [size];
    public static int[] arr1 = new int [size/3];
    public static int[] arr2 = new int [size/3];
    public static int[] arr3 = new int [size/3];

    public static void main(String args[]) {
        for(int i = 0; i < size; i++) {
            arr[i] = size - (i + 1);
            //System.out.print(arr[i] + " ");
        }

        App r1 = new App(arr1, size/3, 0, 99);
        Thread t1 = new Thread(r1);
        t1.start();
/*
        App r2 = new App(arr, size/3, 100, 199);
        Thread t2 = new Thread(r2);
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        App r3 = new App(arr, size/3, 200, 299);
        Thread t3 = new Thread(r3);
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*App r4 = new App(151, 299);
        Thread t4 = new Thread(r4);
        t4.start();*/
    }
}