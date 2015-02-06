import java.util.Scanner;

//MainClass is the driving class containing the main method which runs upon Wordament and Board classes
public class MainClass {

	// main method which runs the Wordament
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Wordament game = new Wordament();
		String str;
		while (!(str = input.nextLine()).equals("EXIT")) {
			if (game.findWord(str))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
