/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerphase2;

/**
 *
 * @author Haytham
 */
public class codeReader {

    public int lineCounter = 0;

    public void enterCode(String[][] tokens) {
        String lines[][]= new String [1000][1000];
        String reservedWords[] = {"for", "while", "else", "main", "if"};
        String operators[] = {"==", "<", ">", "<=", ">=", "!=", "=", "*", "/", "-", "+"};
        String symbols[] = {"{", "}", "(", ")", ",", ";"};
        String dataTypes[] = {"int", "float"};
        Split s = new Split();
        int sentenceCounter = s.Split(lines);
        lineCounter = s.lineCounter;
        int wordCheck = 0;
        for (int k = 0; k < lineCounter; k++) {
            for (int l = 0; l < lines.length; l++) {

                int WordDone = 0;                
                char[] charArray1 = lines[k][l].toCharArray();
                if (lines[k][l].equals("lastWord")) {
                    WordDone = 1;
                    tokens[k][l]="lastWord";
                    break;
                }
                if (tokens[k][l] == null && WordDone == 0) {
                    for (int i = 0; i < reservedWords.length; i++) {
                        wordCheck = 0;
                        char[] charArray2 = reservedWords[i].toCharArray();
                        if (charArray1.length == charArray2.length) {
                            wordCheck = 1;
                            for (int c = 0; c < charArray1.length; c++) {
                                if (charArray1[c] != charArray2[c]) {
                                    wordCheck = 0;
                                }
                            }
                            if (wordCheck != 0) {
                                tokens[k][l] = lines[k][l];
                                WordDone = 1;
                            }
                        }
                    }
                }
                if (tokens[k][l] == null && WordDone == 0) {
                    for (int z = 0; z < operators.length; z++) {
                        wordCheck = 0;
                        char[] charArray2 = operators[z].toCharArray();
                        if (charArray1.length == charArray2.length) {
                            wordCheck = 1;
                            for (int c = 0; c < charArray1.length; c++) {
                                if (charArray1[c] != charArray2[c]) {
                                    wordCheck = 0;
                                }
                            }
                            if (wordCheck != 0) {
                                tokens[k][l] = lines[k][l];
                            }
                        }
                    }
                }
                if (tokens[k][l] == null && WordDone == 0) {
                    for (int x = 0; x < dataTypes.length; x++) {
                        wordCheck = 0;
                        char[] charArray2 = dataTypes[x].toCharArray();
                        if (charArray1.length == charArray2.length) {
                            wordCheck = 1;
                            for (int c = 0; c < charArray1.length; c++) {
                                if (charArray1[c] != charArray2[c]) {
                                    wordCheck = 0;
                                }
                            }
                            if (wordCheck != 0) {
                                tokens[k][l] = lines[k][l];
                                WordDone = 1;
                            }
                        }
                    }
                }
                if (tokens[k][l] == null && WordDone == 0) {
                    for (int x = 0; x < symbols.length; x++) {
                        wordCheck = 0;
                        char[] charArray2 = symbols[x].toCharArray();
                        if (charArray1.length == charArray2.length) {
                            wordCheck = 1;
                            for (int c = 0; c < charArray1.length; c++) {
                                if (charArray1[c] != charArray2[c]) {
                                    wordCheck = 0;
                                }
                            }
                            if (wordCheck != 0) {
                                tokens[k][l] = lines[k][l];
                                WordDone = 1;
                            }
                        }
                    }
                }
                if (tokens[k][l] == null && WordDone == 0) {
                    int checkNumber = 0;
                    try {
                        double value = Double.parseDouble(lines[k][l]);
                        checkNumber = 1;
                    } catch (NumberFormatException e) {
                        checkNumber = -1;
                    }
                    if (checkNumber == 1) {
                        tokens[k][l] = lines[k][l];
                        WordDone = 1;
                    }
                }
                if (tokens[k][l] == null && WordDone == 0 && !lines[k][l].equals("")) {
                    if (charArray1[0] == '\'' || charArray1[0] == '\"') {
                        tokens[k][l] = "Literals";
                        WordDone = 1;
                    }
                }
                if (tokens[k][l] == null && WordDone == 0 && !lines[k][l].equals("")) {
                    if (charArray1[0] == '_' || charArray1[0] == '$' || Character.isLetter(charArray1[0])) {
                        tokens[k][l] = "identifier";
                        WordDone = 1;
                    }
                }
                if (tokens[k][l] == null && WordDone == 0) {
                    tokens[k][l] = "Error";
                }
            }
        }
        /*
        for (int w = 0; w < lineCounter; w++) {
            System.out.println("Line " + "(" + (w + 1) + "): ");
            for (int h = 0; h < 100; h++) {
                if (lines[w][h].equals("lastWord")) {
                    break;
                } else {
                    System.out.format("%20s%15s%20s", lines[w][h], "  | ", tokens[w][h]);
                    System.out.println();
                }
            }
            System.out.println();
        }
        */
    }
}
