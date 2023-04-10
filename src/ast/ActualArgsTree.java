package ast;

import visitor.*;

public class ActualArgsTree extends AST {

    public ActualArgsTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitActualArgsTree(this);
    }

    public Object accept(OffsetVisitor v) {
        return v.visitAssignTree(this);
    }
}
