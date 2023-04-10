package ast;

import visitor.*;

public class IfTree extends AST {

    public IfTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitIfTree(this);
    }

    public Object accept(OffsetVisitor v) {
        return v.visitIfTree(this);
    }
}