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
        this.compmnemonics.put("0","0101010");
        this.compmnemonics.put("1","0111111");
        this.compmnemonics.put("-1","0111010");
        this.compmnemonics.put("D","0001100");
        this.compmnemonics.put("A","0110000");
        this.compmnemonics.put("M","1110000");
        this.compmnemonics.put("!D","0001101");
        this.compmnemonics.put("!A","0110001");
        this.compmnemonics.put("!M","1110001");
        this.compmnemonics.put("-D","0001111");
        this.compmnemonics.put("-A","0110011");
        this.compmnemonics.put("-M","1110011");
        this.compmnemonics.put("D+1","0011111");
        this.compmnemonics.put("A+1","0110111");
        this.compmnemonics.put("M+1","1110111");
        this.compmnemonics.put("D-1","0001110");
        this.compmnemonics.put("A-1","0110010");
        this.compmnemonics.put("M-1","1110010");
        this.compmnemonics.put("D+A","0000010");
        this.compmnemonics.put("D+M","1000010");
        this.compmnemonics.put("D-A","0010011");
        this.compmnemonics.put("D-M","1010011");
        this.compmnemonics.put("A-D","0000111");
        this.compmnemonics.put("M-D","1000111");
        this.compmnemonics.put("D&A","0000000");
        this.compmnemonics.put("D&M","1000000");
        this.compmnemonics.put("D|A","0010101");
        this.compmnemonics.put("D|M","1010101");
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

    public String dest(String mnemonic) {
        return this.destmnemonics.get(mnemonic);
    }
    public Sting comp(String mnemonic) {
        return this.compmnemonics.get(mnemonic);
    }
    public String jump(String mnemonic) {
        return this.jumpmnemonics.get(mnemonic);
    }
}
