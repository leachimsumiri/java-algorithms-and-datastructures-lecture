public class App implements Runnable{



    public void run() {
    }

    public App(int[] arr, int size, int s1, int s2){
        long startTime = System.nanoTime();
        slowSort(arr, s1, s2);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        for(int n = 0; n < size; n++){
            System.out.print(arr[n] + " ");
        }

        System.out.println();
        System.out.println(duration/1000000+"msec");
    }

    public static void slowSort(int[] arr, int i, int j){
        if(i >= j) return;

        int m = (int)((i+j)/2);
        slowSort(arr, i, m);
        slowSort(arr, m+1, j);

        if(arr[j] < arr[m]){
            int temp = arr[j];
            arr[j] = arr[m];
            arr[m] = temp;
        }

        slowSort(arr, i, j-1);
    }

}

