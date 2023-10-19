package assembler0;

import java.io.File;
import java.io.IOException;

public class Assembler {
    public static void main(String[] args) {
        if (args.length == 0) { // No file
            System.out.println("No source file");
            System.exit(1);
        }
        File infile = new File(args[0].trim());
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
        }
        catch(IOException e) {
            e.printStackTrace();
        }


    }
}