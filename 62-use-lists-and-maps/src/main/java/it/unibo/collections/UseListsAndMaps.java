package it.unibo.collections;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final double ELEMS = 100_000;
    private static final int ELEMSREAD = 1_000;
    private static final long AFRICA_POPULATION = 1_110_635_000L;
    private static final long AMERICA_POPULATION = 972_005_000L;
    private static final long ANTARCTICA_POPULATION = 0L;
    private static final long ASIA_POPULATION = 4_298_723_000L;
    private static final long EUROPE_POPULATION = 742_452_000L;
    private static final long OCEANIA_POPULATION = 38_304_000L;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        List<Integer> alist = new ArrayList<>();
        for (int i=1000;i<2000;i++) {
            alist.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        List<Integer> linkedlist = new LinkedList<>(alist);


        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        final int temp = alist.get(alist.size()-1);
        alist.set(alist.size()-1, alist.get(0));
        alist.set(0,temp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        for (int i : alist) {
            System.out.println (i + " ");
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        long time = System.nanoTime();
        
        for (int i=0;i<ELEMS-1;i++) {
            alist.add(0, i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Add " + ELEMS + " as first in a ArrayList took us " + time + " ns " + millis + " ms");

        time=System.nanoTime();

        for (int i=0;i<ELEMS-1;i++) {
            linkedlist.add(0, i);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Add " + ELEMS + " as first in a LinkedList took us " + time + " ns " + millis + " ms ");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        time = System.nanoTime();
        
        for (int i=0;i<ELEMSREAD-1;i++) {
            alist.get(alist.size()/2);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Read " + ELEMSREAD + " in the middle of an ArrayList took us " + time + " ns " + millis + " ms");

        time=System.nanoTime();

        for (int i=0;i<ELEMSREAD-1;i++) {
            linkedlist.get(linkedlist.size()/2);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Read " + ELEMSREAD + " in the middle of a LinkedList took us " + time + " ns " + millis + " ms ");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        final Map<String, Long> worldMap = new HashMap<>();
        worldMap.put("Africa", AFRICA_POPULATION);
        worldMap.put("Americas", AMERICA_POPULATION);
        worldMap.put("Antarctica", ANTARCTICA_POPULATION);
        worldMap.put("Asia",ASIA_POPULATION);
        worldMap.put("Europe",EUROPE_POPULATION);
        worldMap.put("Oceania",OCEANIA_POPULATION);

        /*
         * 8) Compute the population of the world
         */
    }
}
