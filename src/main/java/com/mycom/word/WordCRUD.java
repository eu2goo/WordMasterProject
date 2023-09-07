package com.mycom.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    Scanner inputStream = new Scanner(System.in);
    ArrayList<Word> wordList;

    WordCRUD(Scanner inputStream){
        wordList = new ArrayList<>();
        this.inputStream = inputStream;
    }
    public void listDictionary(){
        System.out.println("________________________________________________");
        for(int i = 0; i < wordList.size();i++){
            System.out.print((i+1) + " ");
            System.out.println(wordList.get(i).toString());
        }
        System.out.println("________________________________________________");
    }
    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력: ");
        int wordLevel = inputStream.nextInt();
        String word = inputStream.nextLine();

        System.out.print("뜻 입력: ");
        String wordMeaning = inputStream.nextLine();

        return new Word(0, wordLevel, word, wordMeaning);
    }
    public void addWord(){
        Word newWord = (Word) add();
        wordList.add(newWord);
        System.out.println("새 단어가 단어장에 추가되었습니다. \n");

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
