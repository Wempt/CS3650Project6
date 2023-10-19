package assembler0;

import java.util.Hashtable;

public class Code {
    private Hashtable<String, String> destmnemonics;
    private Hashtable<String, String> compmnemonics;
    private Hashtable<String, String> jumpmnemonics;

    public Code() {
        this.destmnemonics = new Hashtable<String, String>();
        this.populateDest();
        this.compmnemonics = new Hashtable<String, String>();
        this.populateComp();
        this.jumpmnemonics = new Hashtable<String, String>();
        this.populateJump();
    }
    private void populateDest() {
        this.destmnemonics.put("NULL","000");
        this.destmnemonics.put("M","001");
        this.destmnemonics.put("D","010");
        this.destmnemonics.put("MD","011");
        this.destmnemonics.put("A","100");
        this.destmnemonics.put("AM","101");
        this.destmnemonics.put("AD","110");
        this.destmnemonics.put("AMD","111");
    }
    private void populateComp() {
        this.compmnemonics.put("0","101010");
        this.compmnemonics.put("1","111111");
        this.compmnemonics.put("-1","111010");
        this.compmnemonics.put("D","001100");
        this.compmnemonics.put("A","110000");
        this.compmnemonics.put("M","110000");
        this.compmnemonics.put("!D","001101");
        this.compmnemonics.put("!A","110001");
        this.compmnemonics.put("!M","110001");
        this.compmnemonics.put("-D","001111");
        this.compmnemonics.put("-A","110011");
        this.compmnemonics.put("-M","110011");
        this.compmnemonics.put("D+1","011111");
        this.compmnemonics.put("A+1","110111");
        this.compmnemonics.put("M+1","110111");
        this.compmnemonics.put("D-1","001110");
        this.compmnemonics.put("A-1","110010");
        this.compmnemonics.put("M-1","110010");
        this.compmnemonics.put("D+A","000010");
        this.compmnemonics.put("D+M","000010");
        this.compmnemonics.put("D-A","010011");
        this.compmnemonics.put("D-M","010011");
        this.compmnemonics.put("A-D","000111");
        this.compmnemonics.put("M-D","000111");
        this.compmnemonics.put("D&A","000000");
        this.compmnemonics.put("D&M","000000");
        this.compmnemonics.put("D|A","010101");
        this.compmnemonics.put("D|M","010101");
    }
    private void populateJump() {
        this.jumpmnemonics.put("NULL","000");
        this.jumpmnemonics.put("JGT","001");
        this.jumpmnemonics.put("JEQ","010");
        this.jumpmnemonics.put("JGE","011");
        this.jumpmnemonics.put("JLT","100");
        this.jumpmnemonics.put("JNE","101");
        this.jumpmnemonics.put("JLE","110");
        this.jumpmnemonics.put("JMP","111");
    }
}
