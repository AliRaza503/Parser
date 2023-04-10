package ast;

import visitor.*;

public class CallTree extends AST {

    public CallTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitCallTree(this);
    }

    public Object accept(OffsetVisitor v) {
        return v.visitCallTree(this);
    }
}