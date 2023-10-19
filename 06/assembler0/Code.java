package assembler0;

import java.util.Hashtable;

public class Code {
    private Hashtable<String, String> destmnemonics;
    private Hashtable<String, String> compmnemonics;
    private Hashtable<String, String> jumpmnemonics;

    public Code(){
        this.destmnemonics = new Hashtable<String, String>();
        this.populateDest();
        //test
    }
    private void populateDest(){
        this.destmnemonics.put("NULL","000");
        this.destmnemonics.put("M","001");
        this.destmnemonics.put("D","010");
        this.destmnemonics.put("MD","011");
        this.destmnemonics.put("A","100");
        this.destmnemonics.put("AM","101");
        this.destmnemonics.put("AD","110");
        this.destmnemonics.put("AMD","111");
    }
}
