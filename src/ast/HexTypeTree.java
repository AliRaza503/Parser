package ast;

import visitor.ASTVisitor;

public class HexTypeTree extends AST {
    public HexTypeTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitHexTypeTree(this);
    }
}
