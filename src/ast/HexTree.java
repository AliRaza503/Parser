package ast;

import lexer.Symbol;
import lexer.Token;
import visitor.*;

public class HexTree extends AST {

    private Symbol symbol;

    /**
     * @param token is the Token containing the String representation of the Hex
     *              literal; we keep the String
     *              so we don't introduce any machine dependencies with respect to hex
     *              representations
     */
    public HexTree(Token token) {
        this.symbol = token.getSymbol();
    }

    public Object accept(ASTVisitor visitor) {
        return visitor.visitHexTree(this);
    }

    public Object accept(OffsetVisitor v) {
        return v.visitHexTree(this);
    }

    public Symbol getSymbol() {
        return symbol;
    }
}