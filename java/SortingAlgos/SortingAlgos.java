package SortingAlgos;

/**
 * Created by bhuvanabellala on 2/8/17.
 * Sorting Algorithms Implemented
 */
public class SortingAlgos {

    /**
     * Bubble Sort
     * Average: O(n^2), Worst: O(n^2), Memory: O(1), Best: O(n)
     * Stable: yes
     * Advantages: the ability to detect that the list is sorted
     * Optimizations
     * 1) i-th pass finds the n-ith largest element and puts it into its final place.
     * So, the inner loop can avoid looking at the last n − i items when running for the ith time:
     */
    public static class BubbleSort implements SortAlg {

        public void sort(int[] arr) {

            boolean swapped = true;
            while (swapped) {

                swapped = false;
                for (int i = 0; i < arr.length - 1; i++) {

                    if (arr[i] > arr[i + 1]) {
                        swapped = true;
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }
            }
        }
    }

    /**
     * Insertion sort
     * Average: O(n^2), Worst: O(n^2), Memory: O(1), Best: O(n)
     * Adaptive, stable, and in place
     * Advantages: the ability to detect that the list is sorted
     * Optimizations:
     * 1) optimize by finding the index of jth element, as you are trying to find the index, shift elements over
     */
    public static class InsertionSort implements SortAlg {

        public void sort(int[] arr) {


            for (int i = 1; i < arr.length; i++) {

                for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {

                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;

                }
            }
        }
    }

    /**
     * Selection sort
     * Average: O(n log n), Worst: O(n log n), Memory: O(n), Best: O(n log n)
     * Not stable, and in place
     * Advantages: the ability to detect that the list is sorted
     * Optimizations:
     * 1) Use a heap to remove min - heap sort
     */
    public static class SelectionSort implements SortAlg {

        public void sort(int[] arr) {


            for (int i = 0; i < arr.length; i++) {

                int min = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[min] > arr[j]) {
                        min = j;
                    }
                }

                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    /**
     * Merge sort
     * Average: O(n log n), Worst: O(n log n), Memory: O(n), Best: O(n log n)
     * Could be stable but not in place or adaptive
     * Variants of merge sort are primarily concerned with reducing the space complexity and the cost of copying.
     */
    public static class MergeSort implements SortAlg {

        public void sort(int[] arr) {
            mergeSort(arr, 0, arr.length - 1);
        }

        private static void mergeSort(int[] arr, int lo, int hi){

            if(lo >= hi){
                return;
            }

            int mid = (lo + hi)/2;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid+1, hi);
            merge(arr, lo, mid, hi);
        }

        private static void merge(int[] arr, int lo, int mid, int hi){
            int[] aux = new int[hi - lo + 1];
            System.arraycopy(arr, lo, aux, 0, hi - lo + 1);

            int i = 0;
            int j = aux.length/2;
            for(int k = lo; k<=hi; k++){

                if(i >= aux.length/2 || (j < aux.length && aux[i] > aux[j] )){
                    arr[k] = aux[j];
                    j++;
                }else{
                    arr[k] = aux[i];
                    i++;
                }
            }
        }
    }

    /**
     * Heap sort
     * Average: O(n log n), Worst: O(n log n), Memory: O(n), Best: O(n log n)
     * Not in place, adaptive or stable
     *
     */
    public static class HeapSort implements SortAlg {

        public void sort(int[] arr) {
            buildMaxHeap(arr);

            //once we built the heap, we want to sort;
            for(int i = 0; i < arr.length; i++){
                swap(arr, 0, arr.length - i - 1);
                percolateDown(arr, 0, arr.length - i - 1);
            }

        }

        private static void buildMaxHeap(int[] arr){

            for(int i = parent(arr.length - 1); i >= 0; i--){
                percolateDown(arr, i, arr.length);
            }

        }


        private static void percolateDown(int[] arr, int index, int lastIndex){

            int lC = leftChild(index);
            int rC = rightChild(index);

            int max = index;
            if(lC < lastIndex && arr[max] < arr[lC]){
                max = lC;
            }

            if(rC < lastIndex && arr[max] < arr[rC]){
                max = rC;
            }

            if(max != index){
                swap(arr, max, index);
                percolateDown(arr, max, lastIndex);
            }

        }


        private static int parent(int i){
            if(i == 0){
                return -1;
            }else if(i % 2 == 0){
                return (i/2) - 1;
            }else{
                return i/2;
            }
        }

        private static int leftChild(int i){
            return (i*2) + 1;
        }

        private static int rightChild(int i){
            return (i*2) + 2;
        }

        private static void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public String toString(){
            return "Heap Sort";
        }

    }


    /**
     * Quick sort
     * Average: O(n log n), Worst: O(n^2), Memory: O(log n), Best: O(n log n)
     * In place algorithms is most likely not stable
     * Using Lomuto Partition Scheme
     */
    public static class QuickSort implements SortAlg {

        public void sort(int[] arr) {
            qSort(arr, 0, arr.length - 1);
        }

        private static void qSort(int[] arr, int p, int q){
            if(p < q){
                int part = lomutoPartition(arr, p, q);
                qSort(arr, p, part - 1);
                qSort(arr, part + 1, q);
            }
        }

        /**
         * Not stable
         */
        private static int lomutoPartition(int[] arr, int p, int q){

            int pivot = arr[q];
            int i = p - 1;
            for(int j = p; j < q; j++){
                if(arr[j] <= pivot){
                    i++;
                    swap(arr, i, j);
                }
            }

            swap(arr, i+1, q);
            return i+1;
        }

        private static void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        }


    /**
     * Counting Sort
     * Average: O(n+k), Worst: O(n+k), Memory: O(n+k), Best: O(n+k)
     * Stable - start from the end of the list
     */
    public static class CountingSort implements SortAlg {

        private int _k;

        public CountingSort(int k){
            _k = k;
        }

        public void sort(int[] arr) {

            int[] countArr = new int[_k];
            int[] sortedArr = new int[arr.length];

            for(int i = 0; i < arr.length; i++){
                countArr[arr[i]]++;
            }

            for(int i = 1; i < _k; i++){
                countArr[i] = countArr[i-1] + countArr[i];
            }

            for(int i = arr.length - 1; i >= 0; i--){

                sortedArr[countArr[arr[i]] - 1] = arr[i];
                countArr[arr[i]]--;

            }

            System.arraycopy(sortedArr, 0, arr, 0, arr.length);

        }

        public String toString(){
            return "Counting Sort";
        }

    }

    /**
     * Counting Sort
     * Average: O(n+k), Worst: O(n+k), Memory: O(n+k), Best: O(n+k)
     * Stable - start from the end of the list
     */
    public static class LSDSort implements SortAlg {

        public void sort(int[] arr) {

           //Get the max element to determine num digits
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < arr.length; i++){
                max = arr[i] > max ? arr[i] : max;
            }

            for(int d = 1; max != 0; d *= 10){

                //do stable count sort
                int[] count = new int[10];
                for(int i = 0; i < arr.length; i++){
                    count[(arr[i] / d) % 10]++;
                }

                for(int i = 0; i < 9; i++){
                    count[i+1] += count[i];
                }


                int[] aux = new int[arr.length];
                for(int i = arr.length - 1; i >= 0; i--){
                    int index = count[(arr[i] / d) % 10]--;
                    aux[index - 1] = arr[i];
                    //count[index]--;
                }

                for(int i = 0; i < arr.length; i++){
                    arr[i] = aux[i];
                }

                max = max / 10;


            }



        }

        public String toString(){
            return "LSD Sort";
        }

    }






}


