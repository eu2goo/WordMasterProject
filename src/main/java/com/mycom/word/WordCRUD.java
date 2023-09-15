package com.mycom.word;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordCRUD implements ICRUD {
    Scanner inputScanner;
    ArrayList<Word> wordList;

    WordCRUD(Scanner inputScanner){
        wordList = new ArrayList<>();
        this.inputScanner = inputScanner;
    }
    public void listWords(){
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
        int wordLevel = inputScanner.nextInt();
        String word = inputScanner.next();
        inputScanner.nextLine();
        System.out.print("뜻 입력: ");
        String wordMeaning = inputScanner.nextLine();

        return new Word(0, wordLevel, word, wordMeaning);
    }
    public void addWord(){
        Word newWord = (Word) add();
        wordList.add(newWord);
        System.out.println("새 단어가 단어장에 추가되었습니다 !!! \n");

    }
    @Override
    public void update() {
        if(wordList.isEmpty()){
            System.out.println("입력된 단어가 없습니다!");
        }else {
            System.out.print("=> 수정할 단어 검색:  ");
            String s = inputScanner.next();
            ArrayList<Word> searchList = searchWordFromList(s);
            System.out.println("________________________________________________");
            for(int i = 0; i < searchList.size(); i++){
                System.out.println(i+1 + " " + searchList.get(i).toString());
            }
            System.out.println("________________________________________________");
            System.out.print("=> 수정할 번호 선택: ");
            int indexUpdate = inputScanner.nextInt();

            System.out.print("=> 뜻 입력: ");
            inputScanner.nextLine();
            String wordMeaning = inputScanner.nextLine();

            Word selectedWord = (Word) searchList.get(indexUpdate - 1);
            selectedWord.setWordMeaning(wordMeaning);

            System.out.println("\n단어 수정이 성공적으로 되었습니다!");

        }
    }

    @Override
    public void delete() {
        if(wordList.isEmpty()){
            System.out.println("입력된 단어가 없습니다!");
        }else {
            System.out.print("=> 삭제할 단어 검색:  ");
            String s = inputScanner.next();
            ArrayList<Word> searchList = searchWordFromList(s);
            showList(searchList);
            System.out.print("=> 삭제할 번호 선택: ");
            int indexDelete = inputScanner.nextInt();

            System.out.print("=> 정말로 삭제하시겠습니다?(Y/n): ");
            inputScanner.nextLine();
            String confirm = inputScanner.next();
            if(confirm.equals("Y")){
                wordList.remove(searchList.get(indexDelete-1));
                System.out.println("\n 선택한 단어 삭제 완료 !!!");
            }
        }
    }

    @Override
    public void searchLevel() {
        System.out.print("=> 레벨(1:초금, 2:중급, 3:고급) 선택:  ");
        int l = inputScanner.nextInt();
        ArrayList<Word> searchList;
        searchList = wordList.stream()
                .filter(word -> word.getWordLevel()==l)
                .collect(Collectors.toCollection(ArrayList::new));
        showList(searchList);
    }

    @Override
    public void searchWordList(){
        System.out.print("=> 검색할 단어 입력:  ");
        String s = inputScanner.next();
        ArrayList<Word> searchList = searchWordFromList(s);
        showList(searchList);
    }

    public ArrayList<Word> searchWordFromList(String s) {
        ArrayList<Word> searchList;
        searchList = wordList.stream()
                .filter(word -> word.getWord().contains(s))
                .collect(Collectors.toCollection(ArrayList::new));
//        ArrayList<Word> searchList  = new ArrayList<>();
//        for (Word word : wordList) {
//            if (word.getWord().contains(s)) {
//                searchList.add(word);
//            }
//        }
        return searchList;
    }
    public void showList(ArrayList<Word> list){
        System.out.println("________________________________________________");
        for(int i = 0; i < list.size(); i++){
            System.out.println(i+1 + " " + list.get(i).toString());
        }
        System.out.println("________________________________________________");

    }

    public void loadFile(){
        try{
            BufferedReader inputReader = new BufferedReader(new FileReader("Dictionary.txt"));
             String line;
             int count = 0;
             while(true){
                 line = inputReader.readLine();
                if(line == null) break;
                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String wordMeaning = data[2];

                wordList.add(new Word(0, level, word, wordMeaning));
                count++;
             }
             inputReader.close();
             System.out.println("===> "+count+"개 로딩 완료!!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveFile(){
        PrintWriter outputWriter = null;

        try {
            outputWriter = new PrintWriter("Dictionary.txt");

            for (Word currentWord : wordList) {
                outputWriter.println(currentWord.getWordLevel() + "|" +
                        currentWord.getWord() + "|" +
                        currentWord.getWordMeaning());
            }

            System.out.println("모든 단어 파일 저장 완료!!!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputWriter != null) {
                outputWriter.close();
            }
        }
    }

}
