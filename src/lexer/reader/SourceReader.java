package lexer.reader;

import java.io.*;

/**
 * This class is used to manage the source program input stream;
 * each read request will return the next usable character; it
 * maintains the source column position of the character
 */
public class SourceReader implements IReader {

    private BufferedReader source;
    // line number of source program
    private int lineNumber = 1;
    // position of last character processed
    private int column = -1;

    public static String allChars = "";
    private StringBuffer currentLine = new StringBuffer();
    private boolean completedLine = false;

    private void readFileAtOnce(String sourceFile) {
        try {
            File file = new File(sourceFile);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    sb.append(String.format("%3d:%s\n", lineNumber, line));
                } else {
                    sb.append(String.format("%3d: %s\n", lineNumber, line));
                }
                lineNumber++;
            }
            sb.deleteCharAt(sb.length()-1);
            allChars = sb.toString();
            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Construct a new SourceReader
     *
     * @param sourceFile the String describing the user's source file
     * @exception IOException is thrown if there is an I/O problem
     */
    public SourceReader(String sourceFile) throws IOException {
        this(new BufferedReader(new FileReader(sourceFile)));
        readFileAtOnce(sourceFile);
    }

    public SourceReader(BufferedReader reader) throws IOException {
        this.source = reader;
    }

    public void close() {
        try {
            source.close();
        } catch (Exception e) {
            /* no-op */
        }
    }

    private char advance() throws IOException {
        column++;

        int i = source.read();

        if (i == -1) {
            return '\0';
        }
        currentLine.append((char) i);

        return (char) i;
    }

    /**
     * read next char; track line #
     *
     * @return the character just read in
     * @IOException is thrown for IO problems such as end of file
     */
    public char read() {
        try {
            if (completedLine) {
                lineNumber++;
                column = -1;
                completedLine = false;
            }

            char character = advance();

            if (character == '\r') {
                character = advance();
            }

            if (character == '\n') {
                currentLine.delete(0, currentLine.length());
                completedLine = true;
            }

            return character;
        } catch (Exception e) {
            return '\0';
        }
    }

    public int getColumn() {
        return column;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}