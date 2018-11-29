package dna;

import java.io.*;

//Reads values from a file and constructs a FastqRecord using the information.

public class FastqReader {
	//bufferedReader that will be reading values from the file
	BufferedReader theBufferedReader;
	
	//constructor 
	public FastqReader(BufferedReader br) {
		this.theBufferedReader = br;
	}
	// Returns next record in the file, or null if EOF (end-of-file).
	public FastqRecord readRecord() throws IOException, RecordFormatException {

		//reads the first line, which would be the defline, and sets the value.
		String defline = theBufferedReader.readLine();
		
		//if defline doesnt have a value it will return null and end the method
		if( defline == null) {
			return null;
		}
		
		//reads the next three lines of the record and sets their values accordingly
		String sequence = theBufferedReader.readLine();
		String sign = theBufferedReader.readLine();
		String quality = theBufferedReader.readLine();
		
		//returns a FastqRecord using the appropriate values;
		return new FastqRecord(defline,sequence, quality);
	}
}