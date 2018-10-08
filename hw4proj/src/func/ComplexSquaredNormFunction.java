package func;

public class ComplexSquaredNormFunction implements DoubleFunctionOfTwoInts{

	@Override
	public double fOfXY(int x, int y) {
		Complex function = new Complex(x,y);
		return Math.pow(function.norm(), 2);
	}

	@Override
	public String getName() {
		return "Complex Squared Norm";
	}

}
