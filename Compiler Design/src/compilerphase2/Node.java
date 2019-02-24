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
public class Node {
    public String name;
    public Node parent;
    public Node children[];
    public int childrenCount;
    
    Node()
    {
        children=new Node[100];
        childrenCount=0;
        name="";
    }
    
}
