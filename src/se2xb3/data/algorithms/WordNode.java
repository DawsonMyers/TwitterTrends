package se2xb3.data.algorithms;

import se2xb3.data.models.Tweet;

import java.util.ArrayList;

/**
 * @author Dawson
 * @version 1.0
 * @since 3/10/2017
 */
public class WordNode implements Comparable<WordNode>{
    ArrayList<Tweet> list = new ArrayList<>();
    String id;

    WordNode(String wordId, Tweet tweet) {
        id = wordId;
        list.add(tweet);
    }

    void add(Tweet tweet) {
        list.add(tweet);
    }

    int size() {
        return list.size();
    }

    public String toString() {
        return id + " : " + size();
    }

    @Override public int compareTo(WordNode other) {

        return this.size() > other.size() ? 1: this.size() == other.size() ? 0: -1;
    }
}


