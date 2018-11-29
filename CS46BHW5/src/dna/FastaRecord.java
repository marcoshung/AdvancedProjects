package dna;

//
public class FastaRecord implements DNARecord {
	//The Defline is the Dna's identifer
	String defline;
	
	//the sequence is the Dna's amino acid sequence
	String sequence;
	 
	//ctor that takes two Strings and ensure the defline begins with >
	public FastaRecord(String defline, String sequence) throws RecordFormatException{
		if(defline.charAt(0) != '>') {
			throw new RecordFormatException("Bad 1st char in defline in fastq record: saw, "+ defline.charAt(0) + " expected >");
		}else {
			this.defline = defline;
		}
		this.sequence = sequence;
	}
	
	
	//ctor that takes a FastqRecord instead of Strings
	public FastaRecord(FastqRecord fastqRec){
		this.sequence = fastqRec.getSequence();
		this.defline = ">" + fastqRec.getDefline().substring(1);
	}
	
	
	//getter that returns the defline.
	public String getDefline() {
		return this.defline;
	}
	
	//getter that returns the sequence
	public String getSequence() {
		return this.sequence;
	}
	
	
	//tests whether sequence and defline are equal.
	public boolean equals(FastaRecord r) {
		if(this.sequence.equals(r.getSequence()) && this.defline.equals(r.getDefline())) {
			return true;
		}
		return false;
	}

	
	//returns the sum of the instance variable's hashcodes.
	public int hashCode() {
		return this.defline.hashCode() + this.sequence.hashCode();
	}
}