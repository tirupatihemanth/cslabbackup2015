public class PolarComplex implements IComplex, Comparable<IComplex> {

	private double absoluteValue, argument;

	public PolarComplex(double absoluteValue, double argument) {
		// TODO Constructor for the class
		this.absoluteValue = absoluteValue;
		this.argument = argument;
	}

	@Override
	public int compareTo(IComplex o) {
		// TODO Compare two complex number based on their magnitudes
		if (Abs() > o.Abs()) {
			return 1;
		} else if (Abs() < o.Abs()) {
			return -1;
		}
		return 0;
	}

	@Override
	public double Re() {
		// TODO Get the real part of the complex number
		return absoluteValue * Math.cos(argument);
	}

	@Override
	public double Im() {
		// TODO Get the Imaginary Part of the Complex Number
		return absoluteValue * Math.sin(argument);
	}

	@Override
	public double Abs() {
		// TODO Get the Absolute Value of the complex number
		return absoluteValue;
	}

	@Override
	public double Arg() {
		// TODO Get the Argument of the complex number

		return argument;
	}

	@Override
	public IComplex conj() {
		// TODO Get the conjugate of the given complex number
		return new PolarComplex(absoluteValue, -argument);
	}

	@Override
	public IComplex log() {
		// TODO Get the logarithm of the given complex number
		return new PolarComplex(Math.sqrt(Math.pow(Math.log(absoluteValue), 2)
				+ Math.pow(argument, 2)), Math.atan2(argument,
				Math.log(absoluteValue)));
	}

	@Override
	public IComplex exp() {
		// TODO Get the exponential of the given complex number
		return new PolarComplex(Math.exp(Re()), Im());
	}

	@Override
	public IComplex rotate(double radians) {
		// TODO To rotate a given complex number without changing the magnitude
		return new PolarComplex(absoluteValue, argument + radians);
	}

	@Override
	public IComplex stretch(double scale) {
		// TODO Increase the magnitude of the complex number with the given
		// scale
		return new PolarComplex(absoluteValue * 2, argument);
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
