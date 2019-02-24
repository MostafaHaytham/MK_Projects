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
public class Tree {

    Node nodes[];
    int nodeCount;
    Node currentParent;
    int currentChar;

    Tree() {
        nodes = new Node[100];
        nodeCount = 0;
        currentChar = 0;
    }

    public void parent(String s) {
        nodes[nodeCount] = new Node();
        nodes[nodeCount].name = s;
        nodes[nodeCount].parent = null;
        currentParent = nodes[nodeCount];
        nodeCount++;
    }

    public void addChild(Node child, Node parent) {

        parent.children[parent.childrenCount] = child;
        parent.childrenCount++;
        child.parent = parent;
    }

    public void addNodes(String s[], int lineLength) {
        while (currentChar != lineLength) {
            nodes[nodeCount] = new Node();
            if (s[currentChar].equals("while") || s[currentChar].equals("for") || s[currentChar].equals("if") || s[currentChar].equals("{")) {
                if (s[currentChar].equals("while")) {
                    nodes[nodeCount].name = "WhileStmt";
                    addChild(nodes[nodeCount], currentParent);
                    currentParent = nodes[nodeCount];
                } else if (s[currentChar].equals("for")) {
                    nodes[nodeCount].name = "ForStmt";
                    addChild(nodes[nodeCount], currentParent);
                    currentParent = nodes[nodeCount];
                } else if (s[currentChar].equals("if")) {
                    nodes[nodeCount].name = "IfStmt";
                    addChild(nodes[nodeCount], currentParent);
                    currentParent = nodes[nodeCount];
                } else if (s[currentChar].equals("{")) {
                    nodes[nodeCount].name = "CompoundStmt";
                    addChild(nodes[nodeCount], currentParent);
                    currentParent = nodes[nodeCount];
                    nodeCount++;
                    nodes[nodeCount] = new Node();
                    nodes[nodeCount].name = "{";
                    addChild(nodes[nodeCount], currentParent);
                    nodeCount++;
                    nodes[nodeCount] = new Node();
                    nodes[nodeCount].name = "StmtList";
                    addChild(nodes[nodeCount], currentParent);
                    currentParent = nodes[nodeCount];
                }
            } else if (s[currentChar].equals("(")) {
                nodes[nodeCount].name = "(";
                addChild(nodes[nodeCount], currentParent);
                if (s[currentChar - 1].equals("while") || s[currentChar - 1].equals("for") || s[currentChar - 1].equals("if")) {
                    nodeCount++;
                    nodes[nodeCount] = new Node();
                    nodes[nodeCount].name = "Expr";
                    addChild(nodes[nodeCount], currentParent);
                    currentParent = nodes[nodeCount];
                } else if (s[currentChar - 1].equals("identifier")) {
                    nodeCount++;
                    nodes[nodeCount] = new Node();
                    nodes[nodeCount].name = "ArgList";
                    addChild(nodes[nodeCount], currentParent);
                    currentParent = nodes[nodeCount];
                } else {
                    nodeCount++;
                    nodes[nodeCount] = new Node();
                    nodes[nodeCount].name = "Expr";
                    addChild(nodes[nodeCount], currentParent);
                    currentParent = nodes[nodeCount];
                }
            } else if (s[currentChar].equals(")") || s[currentChar].equals("}")) {
                if (s[currentChar].equals(")")) {
                    currentParent = getSpecificParent("(");
                    nodes[nodeCount].name = ")";
                    addChild(nodes[nodeCount], currentParent);
                    if (s[currentChar + 1].equals("{")) {
                        currentChar++;
                        nodeCount++;
                        nodes[nodeCount] = new Node();
                        nodes[nodeCount].name = "CompoundStmt";
                        addChild(nodes[nodeCount], currentParent);
                        currentParent = nodes[nodeCount];
                        nodeCount++;
                        nodes[nodeCount] = new Node();
                        nodes[nodeCount].name = "{";
                        addChild(nodes[nodeCount], currentParent);
                        nodeCount++;
                        nodes[nodeCount] = new Node();
                        nodes[nodeCount].name = "StmtList";
                        addChild(nodes[nodeCount], currentParent);
                        currentParent = nodes[nodeCount];
                    } else {
                        nodeCount++;
                        nodes[nodeCount] = new Node();
                        nodes[nodeCount].name = "Stmt";
                        addChild(nodes[nodeCount], currentParent);
                        currentParent = nodes[nodeCount];
                    }
                } else if (s[currentChar].equals("}")) {

                    currentParent = getSpecificParent("{");
                    nodes[nodeCount].name = "}";
                    addChild(nodes[nodeCount], currentParent);
                }
            } else if (s[currentChar].equals("int") || s[currentChar].equals("float")) {
                if (s[currentChar + 2].equals("(")) {
                    nodes[nodeCount].name = "Function";
                    addChild(nodes[nodeCount], currentParent);
                    currentParent = nodes[nodeCount];
                    nodeCount++;
                    nodes[nodeCount] = new Node();
                    nodes[nodeCount].name = s[currentChar];
                    addChild(nodes[nodeCount], currentParent);
                } else if (s[currentChar + 2].equals(")") || s[currentChar + 2].equals(",") && !s[currentChar + 3].equals("identifier")) {
                    nodes[nodeCount].name = "Arg";
                    addChild(nodes[nodeCount], currentParent);
                    currentParent = nodes[nodeCount];
                    nodeCount++;
                    nodes[nodeCount] = new Node();
                    nodes[nodeCount].name = s[currentChar];
                    addChild(nodes[nodeCount], currentParent);
                } else if (s[currentChar + 2].equals(";")|| currentChar==0) {
                    nodes[nodeCount].name = "Declaration";
                    addChild(nodes[nodeCount], currentParent);
                    currentParent = nodes[nodeCount];
                    nodeCount++;
                    nodes[nodeCount] = new Node();
                    nodes[nodeCount].name = s[currentChar];
                    addChild(nodes[nodeCount], currentParent);
                }
                else
                {                    
                    nodes[nodeCount].name = s[currentChar];
                    addChild(nodes[nodeCount], currentParent);
                }
            } else if (s[currentChar].equals(",")) {
                if (s[currentChar + 1].equals("identifier") && s[currentChar - 2].equals("int") || s[currentChar + 1].equals("identifier") && s[currentChar - 2].equals("float")) {
                    currentParent = getSpecificParent(s[currentChar - 2]);
                    nodes[nodeCount].name = ",";
                    addChild(nodes[nodeCount], currentParent);
                }
                else if (s[currentChar + 1].equals("identifier") && s[currentChar - 1].equals("identifier") ) {
                    currentParent = getSpecificParent(s[currentChar - 1]);
                    nodes[nodeCount].name = ",";
                    addChild(nodes[nodeCount], currentParent);
                }
                else {
                    currentParent = getSpecificParent("(");
                    currentParent = currentParent.children[0];
                    nodes[nodeCount].name = ",";
                    addChild(nodes[nodeCount], currentParent);
                }
            } else if (s[currentChar].equals("else")) {
                currentParent = getSpecificParent("(");
                nodes[nodeCount].name = "ElsePart";
                addChild(nodes[nodeCount], currentParent);
                currentParent = nodes[nodeCount];
                nodeCount++;
                nodes[nodeCount] = new Node();
                nodes[nodeCount].name = "Stmt";
                addChild(nodes[nodeCount], currentParent);
                currentParent = nodes[nodeCount];
            } else if (s[currentChar].equals("/") || s[currentChar].equals("*") || s[currentChar].equals("+") || s[currentChar].equals("-") || s[currentChar].equals("==") || s[currentChar].equals("<") || s[currentChar].equals(">") || s[currentChar].equals("<=") || s[currentChar].equals(">=") || s[currentChar].equals("!=")) {
                currentParent = getSpecificParent(s[currentChar - 1]);
                nodes[nodeCount].name = s[currentChar];
                addChild(nodes[nodeCount], currentParent);
            } else if (s[currentChar].equals(";")) {
                if(s[0].equals("int")||s[0].equals("float") )
                {
                    currentParent=getSpecificParent(s[0]);
                    nodes[nodeCount].name = s[currentChar];
                    addChild(nodes[nodeCount], currentParent);
                }
                else if(s[currentChar-1].equals(")") || s[currentChar-1].equals("else") )
                {
                    currentParent=getSpecificParent("Stmt");
                    nodes[nodeCount].name=";";
                    addChild(nodes[nodeCount], nodes[nodeCount-1]);
                    
                }
                else if(getSpecificParent("(")!=null)
                {
                    currentParent=getSpecificParent("(");
                    nodes[nodeCount].name = s[currentChar];
                    addChild(nodes[nodeCount], currentParent);
                    nodeCount++;
                    nodes[nodeCount]=new Node();
                    nodes[nodeCount].name="OptExpr";
                    addChild(nodes[nodeCount], currentParent);
                    currentParent=nodes[nodeCount];
                }
            }  
            else if (s[currentChar].equals("identifier") && s[currentChar - 1].equals("(") || isNumber(s[currentChar]) && s[currentChar - 1].equals("(")) {
                nodes[nodeCount].name = s[currentChar];
                addChild(nodes[nodeCount], currentParent);
            }
            else // number or identifier or ;
            {
                nodes[nodeCount].name = s[currentChar];
                addChild(nodes[nodeCount], currentParent);
            }
            nodeCount++;
            currentChar++;
        }
    }

    public Node getParent() {
        return nodes[0];
    }

    public Node getSpecificParent(String s) {

        for (int i = nodeCount - 1; i >= 0; i--) {
            if (nodes[i].name.equals(s)) {
                return nodes[i].parent;
            }
        }
        return null;
    }

    public Node getNode(String s) {

        for (int i = nodeCount - 1; i >= 0; i--) {
            if (nodes[i].name.equals(s)) {
                return nodes[i];
            }
        }
        return null;
    }

    public Boolean isNumber(String number) {

        try {
            double value = Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
