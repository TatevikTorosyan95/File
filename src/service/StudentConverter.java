package service;

import main.FileService;

public class StudentConverter {
    public String[][] converter(){
        String[] strings = FileService.readLines("lesson\\\\java\\\\java.txt");
        String[] arrSplit = new String[strings[0].split(",").length];
        String[][] array = new String[strings.length][arrSplit.length];
        for (int i = 0; i < array.length; i++) {
            arrSplit = strings[i].split(",");
            for (int j = 0; j < arrSplit.length; j++) {
                array[i][j] = arrSplit[j];
            }
        }
        return array;
    }
}
