package dna;

import java.io.*;
import java.util.*;


public class FileConverter {
	//This file will be a fastqRecord
	private File fastq;
	//This file will be a fastaRecord
	private File fasta;

	
	//ctor and stores the files into their respective variables/
	public FileConverter(File q, File a) {
		this.fastq = q;
		this.fasta = a;
	}
	
	
	public void convert() throws IOException, RecordFormatException, FileNotFoundException{
		//  chain of readers.
		FileReader fr = new FileReader(this.fastq);
		BufferedReader br =  new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		//  chain of writers.
		FileWriter fw = new FileWriter(this.fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);
		
		//continues the loop until there is no value left to read
		boolean done = false;
		while(!done) {
			try {
				//constructs a new FastqRecord using the value in the file
				FastqRecord file = fqr.readRecord();
				//makes sure that the file is not empty
				if(file != null ) {
					//checks to see if the quality is low
					if(!file.qualityIsLow()) {
						//writes the contents of the FastqRecord into the fastaRecord
						faw.writeRecord(new FastaRecord(file));
					}
				}else {
					//if there is no value in the file it will end the loop
					done = true;
				}	
			}
			//prints exception messages if it occurs
			catch (RecordFormatException e){
				System.out.println(e.getMessage());
			}
		}
		
		
		
		// Closes fr, br, fw, and pw in reverse order of creation.
		pw.close();
		fw.close();
		br.close();
		fr.close();
	}
	
		
	
	public static void main(String[] args) throws RecordFormatException
	{
		System.out.println("Starting");
		try
		{
			File fastq = new File("data/HW5.fastq");
			if (!fastq.exists())
			{
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW5.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		}catch (IOException x)
		{
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}