package dna;

//Exception in which the format of the record is incorrect
public class RecordFormatException extends Exception{
	
	// Sends the exception message back to the user.
	public RecordFormatException(String message) {
		super(message);
	}

}