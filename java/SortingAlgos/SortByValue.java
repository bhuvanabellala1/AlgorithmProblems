import java.util.*;

/**
 * Created by bhuvanabellala on 2/11/17.
 *
 *
 * Given a hashmap sort by value -
 * A hashmap in Java permits null values and the null key and is unsunchronized
 * Makes No promises as to the order of the map
 *
 * A Treemap on the otherhand is a red-black tree based implementation. So can be sorted either by natural ordering or
 * by a comparator. ContainsKey, get, put, and remove take O(log n) time. TreeMap will only sort on keys;
 *
 * First approach: Using a TreeSet :( Doesn't work if you have duplicate key values and your comparator solely sorts
 * on key values. I then changed the comparator to compare keys if values are equal
 *
 * Second approach: Using a linked list - straight forward comparator
 *
 * Finally to have hashmap if we want constant access to sorted elements based on key use LinkedHashMap to preserve order
 */
public class SortByValue {

    public static void main(String[] args) {
        Map<String, Integer> names_ = new HashMap<>();
        names_.put("Steve", 22);
        names_.put("Monica", 30);
        names_.put("Ross", 40);
        names_.put("Rachel", 13);
        names_.put("Phoebe", 20);
        names_.put("Joey", 6);
        names_.put("Gunther", 17);
        names_.put("Gus", 52);
        names_.put("Shawn", 25);
        names_.put("Liz", 30);

        //Comparator to sort the values
        final Comparator<Map.Entry<String, Integer>> comparator =
                (o1, o2) -> o1.getValue().compareTo(o2.getValue()) == 0 ? o1.getKey().compareTo(o2.getKey()) :
                        o1.getValue().compareTo(o2.getValue());

        TreeSet<Map.Entry<String, Integer>> sorted = new TreeSet<>(comparator);
        sorted.addAll(names_.entrySet());

        System.out.println("USING TREESET");
        for (Map.Entry<String, Integer> kV : sorted) {
            System.out.println(kV.getKey() + " - " + kV.getValue());
        }
        System.out.println();


        //Using LinkedList

        //Anonymous class but changed
        final Comparator<Map.Entry<String, Integer>> listComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                Integer value1 = o1.getValue();
                Integer value2 = o2.getValue();
                return value1.compareTo(value2);
            }
        };
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(names_.entrySet());
        Collections.sort(list, listComparator);

        System.out.println("USING LINKED LIST");
        for (Map.Entry<String, Integer> kV : list) {
            System.out.println(kV.getKey() + " - " + kV.getValue());
        }

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> kV : sorted) {
            sortedMap.put(kV.getKey(), kV.getValue());
        }
        System.out.println();

        System.out.println("FINAL LINKED HASH MAP");
        for (Map.Entry<String, Integer> kV : sortedMap.entrySet()) {
            System.out.println(kV.getKey() + " - " + kV.getValue());
        }
    }
}
