package cs146F19.Hung.project2;

public class MaxValue {
	private int beginIndex;
	private int endIndex;
	private int	value;
	
	public MaxValue(int value, int beginIndex, int endIndex) {
		this.value = value;
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getBeginIndex() {
		return this.beginIndex;
	}
	
	public int getEndIndex() {
		return this.endIndex;
	}
}
