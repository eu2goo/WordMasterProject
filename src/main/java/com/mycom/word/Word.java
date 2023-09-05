package com.mycom.word;

import java.util.ArrayList;

public class Word {
    private int level;
    private int id;
    private String word;
    private String meaning;

    public Word(int level, int id, String word, String meaning) {
        this.level = level;
        this.id = id;
        this.word = word;
        this.meaning = meaning;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
