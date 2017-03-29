package se2xb3.data.algorithms.sort;

import se2xb3.data.algorithms.sort.textbook.Merge;

/**
 * @author Dawson Myers
 * @version 1.0
 * @since 3/26/2017
 */
public class MergeSortStrategy implements ISort {

    public MergeSortStrategy() {}

    @Override
    public void sort(Comparable[] a) {
        Merge.sort(a);
    }
}
