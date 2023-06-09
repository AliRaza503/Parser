package ast;

import lexer.Symbol;
import lexer.Token;
import visitor.*;

public class MultOpTree extends AST {

    private Symbol symbol;

    /**
     *  @param token contains the Symbol that indicates the specific multiplying operator
     */
    public MultOpTree(Token token) {
        this.symbol = token.getSymbol();
    }

    public Object accept(ASTVisitor visitor) {
        return visitor.visitMultOpTree(this);
    }
    public Object accept(OffsetVisitor visitor) {
        return visitor.visitMultOpTree(this);
    }

    public Symbol getSymbol() {
        return symbol;
    }
}