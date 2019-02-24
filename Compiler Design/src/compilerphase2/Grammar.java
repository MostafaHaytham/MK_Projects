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
public class Grammar {

    int wordCount;
    int size;
    String error[];
    int errorCount;
    int stmtCheck;

    Grammar(int size) {
        wordCount = 0;
        this.size = size;
        error = new String[100];
        errorCount = 0;
        stmtCheck = 0;
    }

    public Boolean Function(String token[]) {
        if (Type(token)) {
            if (checkSize() && token[wordCount].equals("identifier")) {
                wordCount++;
                if (checkSize() && token[wordCount].equals("(")) {
                    wordCount++;
                    if (ArgList(token)) {
                        if (checkSize() && token[wordCount].equals(")")) {
                            wordCount++;
                            if (CompoundStmt(token)) {
                                return true;
                            }
                        } else {
                            error[errorCount] = "Missing )";
                            errorCount++;
                        }
                    } else {
                        error[errorCount] = "Wrong ArgList";
                        errorCount++;
                    }
                } else {
                    error[errorCount] = "Missing (";
                    errorCount++;
                }
            } else {
                error[errorCount] = "Missing identifier";
                errorCount++;
            }
        }
        return false;

    }

    public Boolean ArgList(String token[]) {
        Boolean check = false;
        if (Arg(token)) {
            if (checkSize() && token[wordCount].equals(",")) {
                wordCount++;
                if (ArgList(token)) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public Boolean Arg(String token[]) {
        if (Type(token)) {
            if (checkSize() && token[wordCount].equals("identifier")) {
                wordCount++;
                return true;
            }
        }
        return false;
    }

    public Boolean Declaration(String token[]) {
        if (Type(token)) {
            if (IdentList(token)) {
                wordCount++;
                if (checkSize() && token[wordCount].equals(";")) {
                    wordCount++;
                    return true;
                } else {
                    error[errorCount] = "Missing ;";
                    errorCount++;
                }
            } else {
                error[errorCount] = "Missing identifier";
                errorCount++;
            }
        }
        return false;
    }

    public Boolean Type(String token[]) {
        if (checkSize() && token[wordCount].equals("int") || checkSize() && token[wordCount].equals("float")) {
            wordCount++;
            return true;
        }
        return false;
    }

    public Boolean IdentList(String token[]) {
        if (checkSize() && token[wordCount].equals("identifier")) {
            wordCount++;
            if (token[wordCount].equals(",")) {
                wordCount++;
                IdentList(token);
            } else {
                return true;
            }
        }
        return false;
    }

    public Boolean Stmt(String token[]) {
        Boolean check = false;
        if (!check) {
            check = ForStmt(token);
        }
        if (!check) {
            check = WhileStmt(token);
        }
        if (!check) {
            check = Expr(token);
            if (check) {
                if (checkSize() && token[wordCount].equals(";")) {
                    wordCount++;
                    check = true;
                }
                else
                {
                    check=false;
                }
            }
        }
        if (!check) {
            check = IfStmt(token);
        }
        if (!check) {
            check = CompoundStmt(token);
        }
        if (!check) {
            check = Declaration(token);
        }
        
        if (!check) {
            if (checkSize() && token[wordCount].equals(";")) {
                wordCount++;
                check = true;
            }
        } 
        if (check) {
            return true;
        }
        return false;
    }

    public Boolean ForStmt(String token[]) {
        if (checkSize() && token[wordCount].equals("for")) {
            wordCount++;
            if (checkSize() && token[wordCount].equals("(")) {
                wordCount++;
                if (Expr(token)) {
                    if (checkSize() && token[wordCount].equals(";")) {
                        wordCount++;
                        if (OptExpr(token)) {
                            if (checkSize() && token[wordCount].equals(";")) {
                                wordCount++;
                                if (OptExpr(token)) {
                                    if (checkSize() && token[wordCount].equals(")")) {
                                        wordCount++;
                                        if (Stmt(token)) {
                                            return true;
                                        }
                                    } else {
                                        error[errorCount] = "Missing )";
                                        errorCount++;
                                    }

                                }
                            } else {
                                error[errorCount] = "Missing ;";
                                errorCount++;
                            }
                        }
                    } else {
                        error[errorCount] = "Missing ;";
                        errorCount++;
                    }
                }
            } else {
                error[errorCount] = "Missing )";
                errorCount++;
            }
        }
        return false;
    }

    public Boolean OptExpr(String token[]) {
        if (Expr(token)) {
            return true;
        } else if (!Expr(token)) {
            return true;
        }
        return false;
    }

    public Boolean WhileStmt(String token[]) {
        if (checkSize() && token[wordCount].equals("while")) {
            wordCount++;
            if (checkSize() && token[wordCount].equals("(")) {
                wordCount++;

                if (Expr(token)) {
                    if (checkSize() && token[wordCount].equals(")")) {
                        wordCount++;

                        if (Stmt(token)) {
                            return true;
                        } else {
                            error[errorCount] = "Missing )";
                            errorCount++;
                        }
                    }
                }
            } else {
                error[errorCount] = "Missing (";
                errorCount++;
            }
        }
        return false;
    }

    public Boolean IfStmt(String token[]) {
        if (checkSize() && token[wordCount].equals("if")) {
            wordCount++;
            if (checkSize() && token[wordCount].equals("(")) {
                wordCount++;
                if (Expr(token)) {
                    if (checkSize() && token[wordCount].equals(")")) {
                        wordCount++;
                        if (Stmt(token)) {
                            if (ElsePart(token)) {
                                return true;
                            }
                        }
                    } else {
                        error[errorCount] = "Missing )";
                        errorCount++;
                    }
                }
            } else {
                error[errorCount] = "Missing (";
                errorCount++;
            }
        }
        return false;
    }

    public Boolean ElsePart(String token[]) {
        if (checkSize() && token[wordCount].equals("else")) {
            wordCount++;
            if (Stmt(token)) {
                return true;
            }
        } else if (!checkSize()) {
            return true;
        }
        return false;
    }

    public Boolean CompoundStmt(String token[]) {
        if (checkSize() && token[wordCount].equals("{")) {
            wordCount++;
            if (StmtList(token)) {
                if (checkSize() && token[wordCount].equals("}")) {
                    wordCount++;
                    return true;
                } else {
                    error[errorCount] = "Missing }";
                    errorCount++;
                }
            }
        } else {
            error[errorCount] = "Missing {";
            errorCount++;
        }
        return false;
    }

    public Boolean StmtList(String token[]) {
        if (Stmt(token)) {
            StmtList(token);
            return true;
        } else if (!Stmt(token)) {
            return true;
        }
        return false;
    }

    public Boolean Expr(String token[]) {

        if (checkSize() && token[wordCount].equals("identifier")) {
            wordCount++;
            if (checkSize() && token[wordCount].equals("=")) {
                wordCount++;
                if (Expr(token)) {
                    return true;
                }
            } else {
                wordCount--;
            }
        }
        if (Rvalue(token)) {
            return true;
        }
        return false;
    }

    public Boolean Rvalue(String token[]) {
        int check = 0;
        if (Mag(token)) {
            check = 1;
            if (Compare(token)) {
                if (Mag(token)) {
                    return true;
                } else {
                    error[errorCount] = "Missing Number Or Identifier";
                    errorCount++;
                }
            } else {
                error[errorCount] = "Missing Operator or Wrong Operator";
                errorCount++;
            }
        }
        if (check == 1) {
            return true;
        }

        return false;
    }

    public Boolean Compare(String token[]) {
        if (checkSize()) {

            if (token[wordCount].equals("==") || token[wordCount].equals("<") || token[wordCount].equals(">") || token[wordCount].equals("<=") || token[wordCount].equals(">=") || token[wordCount].equals("!=")) {
                wordCount++;
                return true;
            }
        }
        return false;
    }

    public Boolean Mag(String token[]) {

        if (Term(token)) {
            if (checkSize() && token[wordCount].equals("+")) {
                wordCount++;
                if (Term(token)) {
                    return true;
                }
            } else if (checkSize() && token[wordCount].equals("-")) {
                wordCount++;
                if (Term(token)) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public Boolean Term(String token[]) {
        if (Factor(token)) {
            if (checkSize() && token[wordCount].equals("*")) {
                wordCount++;
                if (Factor(token)) {
                    return true;
                }
            } else if (checkSize() && token[wordCount].equals("/")) {
                wordCount++;
                if (Factor(token)) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public Boolean Factor(String token[]) {

        if (checkSize() && token[wordCount].equals("(")) {
            wordCount++;
            if (Expr(token)) {
                if (checkSize() && token[wordCount].equals(")")) {
                    return true;
                }
            } else {
                error[errorCount] = "Missing )";
                errorCount++;
            }
        } else if (checkSize() && token[wordCount].equals("-")) {
            wordCount++;
            if (checkSize() && isNumber(token) || checkSize() && token[wordCount].equals("identifier")) {
                wordCount++;
                return true;
            } else {
                error[errorCount] = "Missing Number";
                errorCount++;
            }
        } else if (checkSize() && token[wordCount].equals("+")) {
            wordCount++;
            if (checkSize() && isNumber(token) || checkSize() && token[wordCount].equals("identifier")) {
                wordCount++;
                return true;
            } else {
                error[errorCount] = "Missing Number";
                errorCount++;
            }
        } else if (checkSize() && token[wordCount].equals("identifier")) {
            wordCount++;
            return true;
        } else if (checkSize() && isNumber(token)) {
            wordCount++;
            return true;
        }
        return false;
    }

    public Boolean isNumber(String token[]) {

        try {
            double value = Double.parseDouble(token[wordCount]);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public Boolean checkSize() {
        if (wordCount == size) {
            return false;
        }
        return true;
    }
}
