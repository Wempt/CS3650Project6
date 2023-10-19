package assembler0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assembler {
    public static void main(String[] args) {
        if (args.length == 0) { // No file
            System.println("No source file");
            System.exit(1);
        }
        try { // File not found
            File infile = new File(args[0].trim());
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }

        
    }
}