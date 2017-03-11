package se2xb3.data.algorithms;

import se2xb3.data.models.Tweet;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Dawson
 * @version 1.0
 * @since 3/10/2017
 */
public class WordIndexer {

    Map<String, WordNode> words = new HashMap<>();

    public WordIndexer() {}

    public void addWord(String word, Tweet tweet) {
        if(!words.containsKey(word)) words.put(word, new WordNode(word,tweet));
        else words.get(word).add(tweet);
    }

    public int size() {
        return words.size();
    }

    public WordNode max() {

        Map<String, WordNode> sortedMap =
                words.entrySet().stream()
                           .sorted((a,b)-> a.getValue().compareTo(b.getValue()))
                            .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        //Map.Entry.<String, WordNode>comparingByValue().

//        WordNode[] wn = words.values().stream()
//                     .sorted((a,b)-> a.compareTo(b)).toArray(WordNode[]::new);
        WordNode[] wn = words.values().stream()
                             .sorted((a,b)-> b.compareTo(a)).toArray(WordNode[]::new);

        WordNode[] wn1 = words.values().stream().toArray(WordNode[]::new);

        //WordNode[] wn = (WordNode[]) words.values().toArray();// Merge.sort();

        return sortedMap.get(1);
    }

///////////////////////////////////////////////////////////////////////////////
//    class WordNode {
//        ArrayList<Tweet> list = new ArrayList<>();
//        String id;
//
//        WordNode(String wordId, Tweet tweet) {
//            id = wordId;
//            list.add(tweet);
//        }
//
//        void add(Tweet tweet) {
//            list.add(tweet);
//        }
//
//        int size() {
//            return list.size();
//        }
//
//    public String toString() {
//        return id + " : " + size();
//    }
//
//    }
}

