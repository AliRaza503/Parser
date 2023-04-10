package ast;

import visitor.*;

public class DeclTree extends AST {

    public DeclTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitDeclTree(this);
    }

    public Object accept(OffsetVisitor v) {
        return v.visitDeclTree(this);
    }
}
