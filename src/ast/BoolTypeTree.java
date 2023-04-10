package ast;

import visitor.*;

public class BoolTypeTree extends AST {

    public BoolTypeTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitBoolTypeTree(this);
    }

    public Object accept(OffsetVisitor v) {
        return v.visitBoolTypeTree(this);
    }
}