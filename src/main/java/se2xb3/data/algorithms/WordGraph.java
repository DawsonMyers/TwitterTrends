package se2xb3.data.algorithms;

import se2xb3.data.models.Tweet;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * A class that generates a graph of words and tweets. Each tweet is connected to all of the words
 * that is contained in the tweet text.
 *
 * @author Dawson
 * @version 1.0
 * @since 3/10/2017
 */
public class WordGraph {

    private Map<String, WordNode> words =  new ConcurrentHashMap<>();//new HashMap<>();
    private Map<String, WordNode> sortedMap;
    public WordGraph() {}

    public void addWord(String word, Tweet tweet) {
        String lowercase = word.toLowerCase();
        if(!words.containsKey(lowercase)) words.put(lowercase, new WordNode(word,tweet));
        else words.get(lowercase).add(tweet);
//        if(!words.containsKey(word)) words.put(word, new WordNode(word,tweet));
//        else words.get(word).add(tweet);
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

        // convert to list and filter out irrelevant words
        List<WordNode> list = words.values()
                                   .stream()
                                   .filter(w -> {
                                       String s = w.id;
                                       if(s.startsWith("#") || s.startsWith("@")) return true;
                                       if(s.length() < 5) return false;
                                       if(isBlacklisted(s)) return false;
                                       return true;
                                   })
                                   .collect(Collectors.toList());

        WordNode[] a =new WordNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    private String w = "";
    private boolean isBlacklisted(String s) {
        w = s;
        return eq("their") || eq("every") || eq("first") || eq("there") || eq("those") || eq("them")
                || eq("they") || eq("These");// || eq("")
    }

    private boolean eq(String a) {return eq(w, a);}
    private boolean eq(String a, String b) {
        return a.toLowerCase().equals(b.toLowerCase());
    }

    public void resetData() {
       words.clear();
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

