package ast;

import visitor.*;

public class IntTypeTree extends AST {

    public IntTypeTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitIntTypeTree(this);
    }

    public Object accept(OffsetVisitor v) {
        return v.visitIntTypeTree(this);
    }
}
