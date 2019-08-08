package com.example.basicapp.data;

public class WordPath implements Comparable<WordPath> {

    private String word;
    private String path;

    public WordPath(String path)
    {
        this.path = path;
        this.word = path.substring(path.lastIndexOf("/") + 1);
    }

    public String word() { return word; }

    public String path() { return path; }

    @Override
    public int compareTo(WordPath wordPath) {
        return word.compareTo(wordPath.word);
    }
}
