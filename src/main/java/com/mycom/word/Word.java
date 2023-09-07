package com.mycom.word;

import java.util.ArrayList;

public class Word {
    private int wordId;
    private int wordLevel;
    private String word;
    private String wordMeaning;

    public Word(int wordId, int wordLevel, String word, String wordMeaning) {
        this.wordId = wordId;
        this.wordLevel = wordLevel;
        this.word = word;
        this.wordMeaning = wordMeaning;
    }

    @Override
    public String toString() {
        String levelOfWord = "";
        for(int i = 0; i < wordLevel; i++) {
            levelOfWord += "*";
        }
        String dictionaryWord;
        dictionaryWord= String.format("%-3s",levelOfWord) + String.format("%15s",word) + "  " + wordMeaning;
        return dictionaryWord;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public int getWordLevel() {
        return wordLevel;
    }

    public void setWordLevel(int wordLevel) {
        this.wordLevel = wordLevel;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordMeaning() {
        return wordMeaning;
    }

    public void setWordMeaning(String wordMeaning) {
        this.wordMeaning = wordMeaning;
    }
}
