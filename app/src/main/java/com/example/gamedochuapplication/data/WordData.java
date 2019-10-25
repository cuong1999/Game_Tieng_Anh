package com.example.gamedochuapplication.data;

public class WordData {

    String word;
    String mean;
    public WordData(){}
    public WordData(String word, String mean) {
        this.word = word;
        this.mean = mean;
    }
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    @Override
    public String toString() {
        return "WordData{" +
                "word='" + word + '\'' +
                ", mean='" + mean + '\'' +
                '}';
    }
}
