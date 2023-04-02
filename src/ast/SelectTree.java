package ast;

import visitor.*;

public class SelectTree extends AST {

    public SelectTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitSelectTree(this);
    }
}