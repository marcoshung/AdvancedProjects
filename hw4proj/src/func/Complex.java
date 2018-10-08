package func;

public class Complex {
	private double			real;
	private double			imaginary;
	
	//constructor that takes in two doubles
	public Complex(double real, double imaginary){
		this.real = real;
		this.imaginary =imaginary;
	}
	
	
	// Constructs an instance that duplicates source.
	// Complete this constructor, then remove this comment line.
	public Complex(Complex source){
		this.real = source.getReal();
		this.imaginary = source.getImaginary();
	}
	
	
	// Getter method.
	public double getReal(){
		return this.real;
	}
	

	// Getter method.
	public double getImaginary(){
		return this.imaginary;
	}
	
	public static Complex add(Complex c1, Complex c2){
		return new Complex(c1.getReal() + c2.getReal(), c1.getImaginary() + c2.getImaginary());
	}
	
	
	public static Complex multiply(Complex c1, Complex c2){
		double firstTerm = (c1.getReal() * c2.getReal()) - (c1.getImaginary() * c2.getImaginary());
		double secondTerm = (c1.getReal() * c2.getImaginary()) + (c1.getImaginary() * c2.getReal());
		return new Complex(firstTerm, secondTerm);
	}

	public double norm(){
		return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
	}
}