package assembler0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
    private Scanner reader;
    private File asm;
    private String currentLine;

    public Parser(File file) {
        try {
            this.asm = file;
            this.reader = new Scanner(this.asm);
            this.currentLine = null;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print("File was not found\n");
        }
    }
    
    private boolean isComment(String line) {
        return line.startsWith("//");
    }
    private String removeComment(String line) {
        return line.substring(0, line.indexOf("//")).trim();
    }

    public boolean hasMoreCommands() {
        return this.reader.hasNextLine();
    }
    public void advance() {
        if (hasMoreCommands()) {
            this.currentLine = this.reader.nextLine().trim();
            if(isComment(currentLine) || this.currentLine.isBlank()) {
                advance();
            }
            else if(!(this.currentLine.indexOf("//") == -1)) {
                this.currentLine = removeComment(currentLine);
            }
        }
    }
    public CommandType commandType() {
        String line = this.currentLine;
        if(line.startsWith("(") && line.endsWith(")")) {
            return CommandType.L_COMMAND;
        }
        else if(line.startsWith("@")) {
            return CommandType.A_COMMAND;
        }
        else {
            return CommandType.C_COMMAND;
        }
    }
    public String symbol() {
        String line = this.currentLine;

        if(commandType().equals(CommandType.L_COMMAND)){
            return line.substring(1, line.length()-1);
        }
        else if (commandType().equals(CommandType.A_COMMAND)) {
            return line. substring(1);
        }
        else {
            return null;
        }
    }
    public String dest() {
        String line = this.currentLine;
        int index = line.indexOf("=");
        if(index == -1) {
            return null;
        }
        else {
            return line.substring(0, index);
        }
    }
    public String comp() {
        String line = this.currentLine;
        int destIndex = line.indexOf("=");
        if (destIndex != -1) {
            return line.substring(destIndex+1);
        }
        int jumpIndex = line.indexOf(";");
        if (jumpIndex == -1) {
            return line;
        }
        else {
            return line.substring(0, jumpIndex);
        }
    }
    public String jump() {
        String line = this.currentLine;
        int jumpIndex = line.indexOf(";");
        if(jumpIndex == -1) {
            return null;
        }
        else {
            return line.substring(jumpIndex+1);
        }
    }
}