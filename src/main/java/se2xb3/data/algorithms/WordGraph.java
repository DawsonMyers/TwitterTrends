package se2xb3.data.algorithms;

import se2xb3.data.models.Tweet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Dawson
 * @version 1.0
 * @since 3/10/2017
 */
public class WordGraph {

    private Map<String, WordNode> words = new HashMap<>();
    private Map<String, WordNode> sortedMap;
    public WordGraph() {}

    public void addWord(String word, Tweet tweet) {
        if(!words.containsKey(word)) words.put(word, new WordNode(word,tweet));
        else words.get(word).add(tweet);
    }

    public int size() {
        return words.size();
    }

    public WordNode max() {

         sortedMap =
                words.entrySet().stream()
                           .sorted((a,b)-> a.getValue().compareTo(b.getValue()))
                            .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        WordNode[] wn = words.values().stream()
                             .sorted((a,b)-> b.compareTo(a)).toArray(WordNode[]::new);

        WordNode[] wn1 = words.values().stream().toArray(WordNode[]::new);

        //WordNode[] wn = (WordNode[]) words.values().toArray();// Merge.sort();

        return sortedMap.get(1);
    }

    public void getTrends() {

    }



    /**
     * Get array of hashtag word nodes
     * @return all words that start with a #
     */
    public WordNode[] getHashtags() {

//        return words
//                .entrySet()
//                .stream()
//                .filter((a) -> !a.getKey().startsWith("#"))
//                .toArray(WordNode[]::new);
        List<WordNode> list = words.values()
                                   .stream()
                                   .filter((a) -> a.id.startsWith("#"))
                                   .collect(Collectors.toList());

        WordNode[] a = new WordNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;

    }

    /**
     * Get array of user mentions as an array of word nodes
     * @return all words that start with a #
     */
    public WordNode[] getUsers() {

//        return words
//                .entrySet()
//                .stream()
//                .filter((a) -> !a.getKey().startsWith("@"))
//                .toArray(WordNode[]::new);

        List<WordNode> list = words.values()
                                   .stream()
                                   .filter((a) -> a.id.startsWith("@"))
                                   .collect(Collectors.toList());

        WordNode[] a = new WordNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public WordNode[] getAllMentions() {
//        return words
//                .entrySet()
//                .stream()
//                .toArray(WordNode[]::new);

        List<WordNode> list = words.values().stream().collect(Collectors.toList());

        WordNode[] a =new WordNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
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

