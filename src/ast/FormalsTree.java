package ast;

import visitor.*;

public class FormalsTree extends AST {

    public FormalsTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitFormalsTree(this);
    }

    public Object accept(OffsetVisitor v) {
        return v.visitFormalsTree(this);
    }
}
