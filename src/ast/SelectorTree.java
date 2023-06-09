package ast;

import visitor.*;

public class SelectorTree extends AST {

    public SelectorTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitSelectorTree(this);
    }
    public Object accept(OffsetVisitor visitor) {
        return visitor.visitSelectorTree(this);
    }
}