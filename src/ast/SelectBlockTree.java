package ast;

import visitor.*;

public class SelectBlockTree extends AST {

    public SelectBlockTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitSelectBlockTree(this);
    }
    public Object accept(OffsetVisitor visitor) {
        return visitor.visitSelectBlockTree(this);
    }
}