package cast;

public class Primitive {
	public static void dumpMaxValues() {
		System.out.println("Max byte value: " + (Byte.MAX_VALUE) ) ;
		System.out.println("Max short value: " + (Short.MAX_VALUE));
		System.out.println("Max int value: " + (Integer.MAX_VALUE));
		System.out.println("Max long value: " + (Long.MAX_VALUE));
		System.out.println("Max float value: " + (Float.MAX_VALUE));
		System.out.println("Max double value: " + (Double.MAX_VALUE));
	}
	
	public static void main(String[] args) {
		dumpMaxValues();
		
		//long to int
		long u = Long.MAX_VALUE;
		int h =  (int)u;
		System.out.println("long to int: " + u +", " + h);
		
		//long to int
		long z = Long.MAX_VALUE - 5;
		int c =  (int)z;
		System.out.println("long to int: " + z +", " + c);
		
		//int to long
		int r = Integer.MAX_VALUE;
		long w =  r;
		System.out.println("int to long: " + r +", " + w);
		
		//byte to double
		byte t = 100;
		double k =  (double)t;
		System.out.println("byte to double: " + t +", " + k);
		
		//double to byte
		double p = 45.67;
		byte o =  (byte)p;
		System.out.println("double to byte: " + p +", " + o);
		
		//double to byte
		double s = 456.789;
		byte d =  (byte)s;
		System.out.println("double to byte: " + s +", " + d);
		
		//float to long
		float a = 12345.6789f;
		long b =  (long)a;
		System.out.println("float to long: " + a +", " + b);
				
		//float to long
		float f = Float.MAX_VALUE;
		long l =  (long)f;
		System.out.println("float to long: " + f +", " + l);
		
		//long to float
		long y = Long.MAX_VALUE;
		float x =  y;
		System.out.println("long to float: " + y +", " + x);
	}
}
