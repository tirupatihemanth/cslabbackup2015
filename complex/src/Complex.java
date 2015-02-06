//Implements the complex number functionality using x+iy format

public class Complex implements IComplex, Comparable<IComplex> {

	private double real, imaginary;

	public Complex(double real, double imaginary) {

		this.real = real;
		this.imaginary = imaginary;
	}

	@Override
	public double Re() {
		// TODO Get the real part of the complex number
		return real;

	}

	@Override
	public double Im() {
		// TODO Get the Imaginary Part of the Complex Number
		return imaginary;
	}

	@Override
	public double Abs() {
		// TODO Get the Absolute Value of the complex number
		return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
	}

	@Override
	public double Arg() {
		// TODO Get the Argument of the complex number
		return Math.atan2(imaginary, real);
	}

	@Override
	public IComplex conj() {
		// TODO Get the conjugate of the given complex number
		return new Complex(real, -imaginary);
	}

	@Override
	public IComplex log() {
		// TODO Get the logarithm of the given complex number
		return new Complex(Math.log(Abs()), Arg());
	}

	@Override
	public IComplex exp() {
		// TODO Get the exponential of the given complex number
		return new Complex(Math.exp(real) * Math.cos(imaginary), Math.exp(real)
				* Math.sin(imaginary));
	}

	@Override
	public IComplex rotate(double radians) {
		// TODO To rotate a given complex number without changing the magnitude
		return new Complex(Abs() * Math.cos(Arg() + radians), Abs()
				* Math.sin(Arg() + radians));
	}

	@Override
	public IComplex stretch(double scale) {
		// TODO Increase the magnitude of the complex number with the given
		// scale
		return new Complex(real * 2, imaginary * 2);
	}

	@Override
	public int compareTo(IComplex o) {
		// TODO Comparing Complex numbers based on their magnitudes
		if (Abs() > o.Abs()) {
			return 1;
		} else if (Abs() < o.Abs()) {
			return -1;
		}
		return 0;
	}

	/*
	 * public double Arg(double real, double imaginary){
	 * 
	 * if(real>0){ return Math.atan(imaginary/real); } else if(real<0){ return
	 * imaginary>0? Math.atan(Math.PI-Math.abs(imaginary)/Math.abs(real)):
	 * -Math.PI+Math.atan(Math.abs(imaginary)/Math.abs(real)); } else
	 * if(imaginary>0){ return Math.PI/2; } else if(imaginary<0){ return
	 * -Math.PI/2; } else{
	 * System.out.println("Input Error Returning 0 as argument\n"); return 0; }
	 * }
	 */

}
