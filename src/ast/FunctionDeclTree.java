package ast;

import visitor.*;

public class FunctionDeclTree extends AST {

    public FunctionDeclTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitFunctionDeclTree(this);
    }

    public Object accept(OffsetVisitor v) {
        return v.visitFunctionDeclTree(this);
    }
}
