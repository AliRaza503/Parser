package parser;

import lexer.Token;
import lexer.Tokens;

import java.io.Serial;

public class SyntaxError extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Token tokenFound;
    private final Tokens kindExpected;

    /**
     * record the syntax error just encountered
     *
     * @param tokenFound   is the token just found by the parser
     * @param kindExpected is the token we expected to find based on the current
     *                     context
     */
    public SyntaxError(Token tokenFound, Tokens kindExpected) {
        this.tokenFound = tokenFound;
        this.kindExpected = kindExpected;
    }

    void print() {
        System.out.println("Expected: " + kindExpected);
        return;
    }

    @Override
    public String toString() {
        return String.format("Expected [%s], found [%s]", kindExpected, tokenFound);
    }
}
