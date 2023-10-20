package assembler0;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Assembler {
    public static void main(String[] args) {
        if (args.length == 0) { // No file
            System.out.println("No source file");
            System.exit(1);
        }
        File infile = new File(args[0].trim());
        // File infile = new File("rect/Rect.asm");
        if (!infile.exists()) {
            System.out.println("File not found");
            System.exit(1);
        }
        String infilePath = infile.getAbsolutePath();
        String outfilePath = infilePath.substring(0, infilePath.lastIndexOf("/")+1);
        String infileName = infile.getName();
        String infileNoExt = infileName.substring(0,infileName.lastIndexOf("."));
        File outfile = new File(outfilePath + infileNoExt + ".hack");

        if (outfile.exists()) {
            outfile.delete();
        }
        try {
            outfile.createNewFile();
            parse(infile, outfile);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void addLabels(SymbolTable symbolTable, File infile) {
        Parser parser = new Parser(infile);
        while(parser.hasMoreCommands()) {
            parser.advance();
            if (parser.commandType().equals(CommandType.L_COMMAND)) {
                String symbol = parser.symbol();
                symbolTable.addEntry(symbol, symbolTable.getProgAddress());
            }
            else {
                symbolTable.incProgAddress();
            }
        }
    }

    private static void parse(File infile, File outfile) throws IOException{
        Parser parser = new Parser(infile);
        Code decode = new Code();
        FileWriter fWriter = new FileWriter(outfile);
        BufferedWriter writer = new BufferedWriter(fWriter);
        SymbolTable symbolTable = new SymbolTable();
        addLabels(symbolTable, infile);
        
        while(parser.hasMoreCommands()) {
            parser.advance();
            CommandType cType = parser.commandType();
            String instruction = null;
            if (cType.equals(CommandType.A_COMMAND)) {
                String symbol = parser.symbol();
                String binary = null;
                if (!Character.isDigit(symbol.charAt(0))) {
                    if (!symbolTable.contains(symbol)) {
                        symbolTable.addEntry(symbol, symbolTable.getDataAddress());
                        symbolTable.incDataAddress();
                    }
                    binary = Integer.toBinaryString(symbolTable.getAddress(symbol));
                }
                else {
                    binary = Integer.toBinaryString(Integer.parseInt(symbol));
                }
                instruction = String.format("%16s",binary).replace(" ", "0");

            }
            else if (cType.equals(CommandType.C_COMMAND)) {
                instruction = "111" + decode.comp(parser.comp()) + decode.dest(parser.dest()) + decode.jump(parser.jump());
            }
            if (!cType.equals(CommandType.L_COMMAND)) {
                //write to file
                writer.append(instruction);
                writer.newLine();
            }
        }
        writer.close();
    }
}