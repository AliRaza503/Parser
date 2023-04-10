package lexer.reader;

public interface IReader {
    public char read();

    public int getColumn();

    public int getLineNumber();

    public void close();
}