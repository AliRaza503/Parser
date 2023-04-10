package ast;

import visitor.*;

public class AssignTree extends AST {

    public AssignTree() {}

    public Object accept(ASTVisitor visitor) {
        return visitor.visitAssignTree(this);
    }

    public Object accept(OffsetVisitor v) {
        return v.visitAssignTree(this);
    }
}
