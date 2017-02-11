package SortingAlgos;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;


/**
 * Created by bhuvanabellala on 2/8/17.
 */
public class SortingAlgosTest {


    @Test
    public void test1() {

        int n = 156;
        int limit = 1000;
        int[] original = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            original[i] = random.nextInt(limit);
        }

       // int[] original = {3, 2, 1}
        int[] expected = new int[n];
        System.arraycopy(original,0, expected, 0, n);

        SortAlg[] algorithms = {
                new SortingAlgos.BubbleSort(),
                new SortingAlgos.InsertionSort(),
                new SortingAlgos.SelectionSort(),
                new SortingAlgos.MergeSort(),
                new SortingAlgos.HeapSort(),
                new SortingAlgos.QuickSort(),
                new SortingAlgos.CountingSort(limit),
                new SortingAlgos.LSDSort()
        };

        Arrays.sort(expected);

        for (SortAlg sa : algorithms) {
            sa.sort(original);
            assertArrayEquals("Result for " + sa + " incorrect: ",
                    expected, original);
        }


    }

}
