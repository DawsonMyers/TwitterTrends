package se2xb3.data.algorithms;

import se2xb3.data.models.Tweet;

import java.util.ArrayList;

/**
 * A class for word nodes that are used to build the word graph.
 *
 * @author Dawson
 * @version 1.0
 * @since 3/10/2017
 */
public class WordNode implements Comparable<WordNode> {
    ArrayList<Tweet> list = new ArrayList<>();
    public String id;

    /**
     * WordNode constructor
     *
     * @param wordId the word
     * @param tweet  the tweet that uses it
     */
    public WordNode(String wordId, Tweet tweet) {
        id = wordId;
        list.add(tweet);
    }

    /**
     * Adds a reference to a tweet that uses this word.
     *
     * @param tweet a tweet that uses the word
     */
    void add(Tweet tweet) {
        list.add(tweet);
    }

    /**
     * Gets the number of tweets that uses this word.
     *
     * @return the number of references to tweets that use this word
     */
    public int size() {
        return list.size();
    }

    /**
     * The string representation of this node.
     *
     * @return a string containing the id and size of this node
     */
    public String toString() {
        return id + " : " + size();
    }

    /**
     * Compare another word node to this word node. The comaprison is configured to sort nodes in
     * decending order according to their size.
     *
     * @param other a node to compare to
     * @return -1 if this node is larger, 0 if the same, and 1 if smaller
     */
    @Override
    public int compareTo(WordNode other) {

        // descending order
        return this.size() > other.size() ? -1 : this.size() == other.size() ? 0 : 1;
        // ascending order
//        return this.size() > other.size() ? 1: this.size() == other.size() ? 0: -1;
    }
}


