package ast;

import visitor.ASTVisitor;
import visitor.OffsetVisitor;

public class StringTypeTree extends AST {
    public StringTypeTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitStringTypeTree(this);
    }

    public Object accept(OffsetVisitor visitor) {
        return visitor.visitStringTypeTree(this);
    }
}
