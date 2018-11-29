package dna;

import java.io.*;


//this class will be able to printout the lines of a FastaRecord.
public class FastaWriter {
	
	private PrintWriter thePrintWriter;
	//constructor that takes a printwriter
	public FastaWriter(PrintWriter p) {
		this.thePrintWriter = p;
	}

	// Write the rec as 2 separate lines: first the defline, then the sequence.
	// To write something on a separate line, use the println() method of PrintWriter.
	public void writeRecord(FastaRecord rec) throws IOException{
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());
	}
	
}