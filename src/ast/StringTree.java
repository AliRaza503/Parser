package ast;

import lexer.Symbol;
import lexer.Token;
import visitor.*;

public class StringTree extends AST {

    private Symbol symbol;

    /**
     * @param token is the Token containing the String representation of the string
     *              literal; we keep the String
     *              so we don't introduce any machine dependencies with respect to string
     *              representations
     */
    public StringTree(Token token) {
        this.symbol = token.getSymbol();
    }

    public Object accept(ASTVisitor visitor) {
        return visitor.visitStringTree(this);
    }
    public Object accept(OffsetVisitor visitor) {
        return visitor.visitStringTree(this);
    }

    public Symbol getSymbol() {
        return symbol;
    }
}