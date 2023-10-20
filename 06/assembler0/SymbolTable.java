package assembler0;

import java.util.Hashtable;

public class SymbolTable {
    private Hashtable<String, Integer> symbolAddress;
    private int dataAddress;
    private int progAddress;
    public SymbolTable() {
        this.initTable();
        dataAddress = 16;
        progAddress = 0;
    }
    public void initTable(){
        this.symbolAddress = new Hashtable<String, Integer>();
        // v built in symbols v
		this.symbolAddress.put("SP", Integer.valueOf(0));
		this.symbolAddress.put("LCL", Integer.valueOf(1));
		this.symbolAddress.put("ARG", Integer.valueOf(2));
		this.symbolAddress.put("THIS", Integer.valueOf(3));
		this.symbolAddress.put("THAT", Integer.valueOf(4));
		this.symbolAddress.put("R0", Integer.valueOf(0));
		this.symbolAddress.put("R1", Integer.valueOf(1));
		this.symbolAddress.put("R2", Integer.valueOf(2));
		this.symbolAddress.put("R3", Integer.valueOf(3));
		this.symbolAddress.put("R4", Integer.valueOf(4));
		this.symbolAddress.put("R5", Integer.valueOf(5));
		this.symbolAddress.put("R6", Integer.valueOf(6));
		this.symbolAddress.put("R7", Integer.valueOf(7));
		this.symbolAddress.put("R8", Integer.valueOf(8));
		this.symbolAddress.put("R9", Integer.valueOf(9));
		this.symbolAddress.put("R10", Integer.valueOf(10));
		this.symbolAddress.put("R11", Integer.valueOf(11));
		this.symbolAddress.put("R12", Integer.valueOf(12));
		this.symbolAddress.put("R13", Integer.valueOf(13));
		this.symbolAddress.put("R14", Integer.valueOf(14));
		this.symbolAddress.put("R15", Integer.valueOf(15));
		this.symbolAddress.put("SCREEN", Integer.valueOf(16384));
		this.symbolAddress.put("KBD", Integer.valueOf(24576));
    }
    public void addEntry(String symbol, int address) {
        this.symbolAddress.put(symbol, address);
    }

    public boolean contains(String symbol) {
        return this.symbolAddress.containsKey(symbol);
    }

    public int getAddress(String symbol) {
        return this.symbolAddress.get(symbol);
    }

    public void incProgAddress() {
        this.progAddress++;
    }
    public int getProgAddress() {
        return this.progAddress;
    }

    public void incDataAddress() {
        this.dataAddress++;
    }
    public int getDataAddress() {
        return this.dataAddress;
    }
}
