/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerphase2;

import java.util.Scanner;

/**
 *
 * @author Haytham
 */
public class Split {
    public int lineCounter=0;
    public int Split( String lines[][]) {
        String newWords[]=new String [1000];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Your code line by line and write (end) to start compiling.");
        System.out.println("Enter your code: ");
        int end = 0;
        int lastWordInLine=0;
        String sentence = scan.nextLine();
        if (sentence.equals("end")) {
            end = 1;
        }
        int sentenceCounter = 0;
        for (int k = 0; k < 1000; k++) {
            newWords[k] = "";
        }
        while (end == 0) {
            sentence = sentence + " ";
            int lastCounter = 0;
            char[] charArray = sentence.toCharArray();
            for (int u = 0; u < sentence.length(); u++) {
                if (charArray[u] == ';' || charArray[u] == ',' || charArray[u] == '(' || charArray[u] == ')' || charArray[u] == '{' || charArray[u] == '}'  || charArray[u] == '*' || charArray[u] == '/' || charArray[u] == '+' || charArray[u] == '-' ) {
                    for (int f = lastCounter; f < u; f++) {
                        newWords[sentenceCounter] = newWords[sentenceCounter] + charArray[f];
                    }
                    if (lastCounter != u) {
                        sentenceCounter++;
                    }
                    newWords[sentenceCounter] = newWords[sentenceCounter] + charArray[u];
                    sentenceCounter++;
                    lastCounter = u + 1;
                } else if (charArray[u] == '=' || charArray[u] == '!' || charArray[u] == '>' || charArray[u] == '<') {
                    for (int f = lastCounter; f < u; f++) {
                        newWords[sentenceCounter] = newWords[sentenceCounter] + charArray[f];
                    }
                    if (lastCounter != u) {
                        sentenceCounter++;
                    }
                    if (charArray[u] == '=' || charArray[u] == '!' || charArray[u] == '>' || charArray[u] == '<') {
                        if (charArray[u + 1] == '=') {
                            newWords[sentenceCounter] = newWords[sentenceCounter] + charArray[u] + charArray[u + 1];
                            sentenceCounter++;
                            u = u + 1;
                        } else {
                            newWords[sentenceCounter] = newWords[sentenceCounter] + charArray[u];
                            sentenceCounter++;
                        }
                    }
                    lastCounter = u + 1;
                } else if (charArray[u] == ' ' || charArray[u] == '\t' ) {
                    for (int f = lastCounter; f < u; f++) {
                        newWords[sentenceCounter] = newWords[sentenceCounter] + "" + charArray[f];
                    }
                    if (lastCounter != u) {
                        sentenceCounter++;
                    }
                    lastCounter = u + 1;

                } else if (charArray[u] == '/') {
                    for (int f = lastCounter; f < u; f++) {
                        newWords[sentenceCounter] = newWords[sentenceCounter] + charArray[f];
                    }
                    if (lastCounter != u) {
                        sentenceCounter++;
                    }
                    if (charArray[u + 1] == '/') {
                        u = sentence.length() + 1;
                    } else {
                        newWords[sentenceCounter] = newWords[sentenceCounter] + charArray[u];
                        sentenceCounter++;
                    }
                    lastCounter = u + 1;
                } else if (charArray[u] == '\"') {
                    for (int f = lastCounter; f < u; f++) {
                        newWords[sentenceCounter] = newWords[sentenceCounter] + "" + charArray[f];
                    }
                    if (lastCounter != u) {
                        sentenceCounter++;
                    }
                    lastCounter = u;
                    for (int d = u + 1; d < sentence.length(); d++) {
                        if (charArray[d] == '\"') {
                            u = d;
                            d = sentence.length() + 1;
                        }
                    }
                    for (int f = lastCounter; f < u + 1; f++) {
                        newWords[sentenceCounter] = newWords[sentenceCounter] + "" + charArray[f];
                    }
                    if (lastCounter != u) {
                        sentenceCounter++;
                    }
                    lastCounter = u + 1;
                } else if (charArray[u] == '\'') {
                    for (int f = lastCounter; f < u; f++) {
                        newWords[sentenceCounter] = newWords[sentenceCounter] + "" + charArray[f];
                    }
                    if (lastCounter != u) {
                        sentenceCounter++;
                    }
                    lastCounter = u;
                    for (int d = u + 1; d < sentence.length(); d++) {
                        if (charArray[d] == '\'') {
                            u = d;
                            d = sentence.length() + 1;
                        }
                    }
                    for (int f = lastCounter; f < u + 1; f++) {
                        newWords[sentenceCounter] = newWords[sentenceCounter] + "" + charArray[f];
                    }
                    if (lastCounter != u) {
                        sentenceCounter++;
                    }
                    lastCounter = u + 1;
                }

            }
            int loopCounter=0;
            for(int t=lastWordInLine; t<sentenceCounter; t++)
            {
                lines[lineCounter][loopCounter]=newWords[t];
                loopCounter++;
            }
            lines[lineCounter][loopCounter]="lastWord";
            lastWordInLine=sentenceCounter;
            lineCounter++;
            sentence = scan.nextLine();
            if (sentence.equals("end")) {
                end = 1;
            }
        }
        return sentenceCounter;
    }

}
