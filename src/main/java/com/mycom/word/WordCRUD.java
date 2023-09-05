package com.mycom.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    ArrayList<Word> list;
    Scanner inputStream;

    WordCRUD(Scanner inputStream) {
        list = new ArrayList<>();
        this.inputStream = inputStream;
    }
public void listAll(){

}
    @Override
    public Object add() {
        return 0;
    }

    public void addWord(){

    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }
}
