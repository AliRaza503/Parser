package ast;

import visitor.*;

public class UnlessTree extends AST {

    public UnlessTree() {
    }

    public Object accept(ASTVisitor visitor) {
        return visitor.visitUnlessTree(this);
    }
}
