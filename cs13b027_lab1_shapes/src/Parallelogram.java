//Parallelogram class which implements QuadFunctions
public class Parallelogram implements QuadFunctions {

	double length, breadth, area, perimeter;

	// input will be taken in degrees but here it is stored in radians
	double angle;

	// Constructor for Parallelogram
	public Parallelogram(double length, double breadth, double angle) {
		this.length = length;
		this.breadth = breadth;
		this.angle = Math.toRadians(angle);
	}

	// Method to computer Area
	public double area() {
		return length * breadth * Math.sin(angle);
	}

	// Method to computer perimeter
	public double perimeter() {
		return 2 * (length + breadth);
	}

}
