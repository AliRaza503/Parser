package ast;

import visitor.ASTVisitor;
import visitor.OffsetVisitor;

public class HexTypeTree extends AST {
    public HexTypeTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitHexTypeTree(this);
    }

    public Object accept(OffsetVisitor v) {
        return v.visitHexTypeTree(this);
    }
}
