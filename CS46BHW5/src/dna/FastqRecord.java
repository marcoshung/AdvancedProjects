package dna;

//
// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
//


public class FastqRecord implements DNARecord {
	
	//The Defline is the Dna's identifer
	String defline;
	
	//the sequence is the Dna's amino acid sequence
	String sequence;
	
	//the quality of the DNA
	String quality;
	

	//ctor with three String arguments. Checks to see if defline starts with @
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException{
		if(defline.charAt(0) != '@') {
			throw new RecordFormatException("Bad 1st char in defline in fastq record: saw, "+ defline.charAt(0) + " expected @");
		}else {
			this.defline = defline;
		}
		this.sequence = sequence;
		this.quality = quality;
	}
	

	//getter for the defline.
	public String getDefline() {
		return this.defline;
	}
		
	//getter for the sequence.
	public String getSequence() {
		return this.sequence;
	}

	//checks to see if all three instance variables are the same as the variables of the arguement's variables.
	public boolean equals(FastqRecord q) {
		if(this.defline.equals(q.getDefline()) && this.sequence.equals(q.getSequence()) && this.quality.equals(q.getQuality())){
			return true;
		}
		return false;
	}
	
	//returns true if quality contains ! or #
	public boolean qualityIsLow(){
		if(this.quality.indexOf("!") != -1 || this.quality.indexOf("#") != -1) {
			return true;
		}
		return false;
	}
	
	// Returns the sum of the hash codes of defline, sequence, and quality.
	public int hashCode(){
		return (this.defline.hashCode() + this.sequence.hashCode() + this.quality.hashCode());
	}
	
	//getter of the record's quality
	public String getQuality() {
		return this.quality;
	}
}