//Main class which runs other class
public class MainClass {

	// main method which runs over all other classes
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(10.0, 20.0);
		Square square = new Square(10.0);
		Parallelogram parallelogram = new Parallelogram(10.0, 20.0, 45.0);
		// This is valid
		// Parallelogram rectangle1 = new Rectangle(4, 10);
		// This is not valid
		// Rectangle Rectangle1 = new Parallelogram(4,10);
		// A super class variable can reference a subclass object but the
		// converse is not true
		System.out.printf("Rectangle Area: %f\n", rectangle.area());
		System.out.printf("Rectangle Perimeter: %f\n", rectangle.perimeter());
		System.out.printf("Square Area: %f\n", square.area());
		System.out.printf("Square perimeter: %f\n", square.perimeter());
		System.out.printf("Parallelogram Area: %f\n", parallelogram.area());
		System.out.printf("Parallelogram perimeter: %f\n",
				parallelogram.perimeter());

	}
}
