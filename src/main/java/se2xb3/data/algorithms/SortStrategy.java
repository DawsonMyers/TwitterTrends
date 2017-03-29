package se2xb3.data.algorithms;

import se2xb3.data.algorithms.sort.ISort;
import se2xb3.data.algorithms.sort.MergeSortStrategy;
import se2xb3.data.algorithms.sort.textbook.Merge;
import se2xb3.data.models.Tweet;

import java.util.List;

/**
 * @author Dawson Myers
 * @version 1.0
 * @since 3/12/2017
 */
public class SortStrategy {

    private Merge mergeSort;
    private ISort sortStrategy;

    public SortStrategy() {setStrategy();}

    public List<Tweet> sortTweetList(List<Tweet> tweetList) {

        return null;
    }
    public void setStrategy() {
        sortStrategy = new MergeSortStrategy();
    }


    public void sort(Comparable[] a) {
        sortStrategy.sort(a);
    }



}
