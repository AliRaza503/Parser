package ast;

import visitor.*;

public class BlockTree extends AST {

    public BlockTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitBlockTree(this);
    }

    public Object accept(OffsetVisitor v) {
        return v.visitBlockTree(this);
    }
}