package func;

public class ComplexNormFunction implements DoubleFunctionOfTwoInts{

	@Override
	public double fOfXY(int x, int y) {
		Complex function = new Complex(x,y);
		return function.norm();
	}

	@Override
	public String getName() {
		return "Complex Norm";
	}

}
