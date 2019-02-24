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
public class CompilerPhase2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here       
        String token[][] = new String[1000][1000];
        String lines[][] = new String[1000][1000];
        String Errors[] = new String[1000];
        codeReader cr = new codeReader();
        Boolean code = false;
        cr.enterCode(token);
        Tree t[] = new Tree[100];
        int treeNode[] = new int[100];
        int lineCounter = cr.lineCounter;
        String line = "if ( identifier = identifier < 3 ) ;";
        String line2 = "for ( identifier = 2 ; identifier > 3 ; identifier + 2 ) ;";
        String line3 = "float identifier ( int identifier , float identifier , int identifier ) { }";
        String line4 = "if ( identifier < 3 ) ; else ; ";
        String line5 = "int identifier";
        for (int l = 0; l < lineCounter; l++) {
            System.out.println();
            String tokens[] = new String[1000];
            int tokensLength = 0;
            for (int j = 0; j < token.length; j++) {
                if (token[l][j].equals("lastWord")) {
                    tokensLength = j;
                    break;
                } else {
                    tokens[j] = token[l][j];
                }
            }
            for (int z = 0; z < tokensLength; z++) {
                System.out.print(tokens[z] + " ");
            }
            System.out.println();
            System.out.println("Line Number (" + l + "):");
            System.out.println("Number of words of the line: " + tokensLength);
            Grammar g = new Grammar(tokensLength);
            Boolean check = false;
            check = g.Function(tokens);
            Boolean check2 = false;
            if (!check) {
                g = new Grammar(tokensLength);
                check2 = g.Stmt(tokens);
            }
            System.out.println("Last reached word number : " + g.wordCount);
            if (g.wordCount != tokensLength) {
                System.out.println("Error Word: " + tokens[g.wordCount]);
            }
            if (check && g.wordCount == tokensLength || check2 && g.wordCount == tokensLength) {
                t[l] = new Tree();
                t[l].parent("Tree");
                t[l].addNodes(tokens, tokensLength);
                treeNode[l] = t[l].nodeCount;
                code = true;
            } else {
                Errors[l] = g.error[0];
                code = false;
            }
        }
        if (!code) {
            for (int er = 0; er < lineCounter; er++) {
                System.out.println(Errors[er]);
            }
        } else {
            for (int li = 0; li < lineCounter; li++) {
                Node nodesIndex[] = new Node[100];
                int currentIndex = 1;
                Tree currentTree = t[li];
                nodesIndex[li] = currentTree.getParent();
                Node currentNode;
                System.out.println(nodesIndex[li].children[0].name);
                System.out.println("Line("+(li+1)+")");
                System.out.print("Level(0): Tree");
                int level = 1;
                for (int j = 0; j < treeNode[li]; j++) {
                    Boolean output = false;
                    currentNode = nodesIndex[j];
                    int childrenCounter = 0;
                    if (j == 0) {
                        System.out.println();
                        System.out.print("Level(" + level + "): ");
                        level++;
                    }
                    while (currentNode.children[childrenCounter]!= null) {
                        System.out.print(currentNode.children[childrenCounter].name + " ");
                        nodesIndex[currentIndex] = currentNode.children[childrenCounter];
                        currentIndex++;
                        childrenCounter++;
                        output = true;
                    }
                    if (output && currentNode.parent != nodesIndex[j + 1].parent) {
                        System.out.println();
                        System.out.print("Level(" + level + "): ");
                        level++;
                    }

                }
            }
            //if ( identifier = identifier < 3 ) ;
            //float identifier ( int identifier , float identifier , int identifier ) { }
        }
    }

}
