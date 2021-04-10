package exam1.prob2.answer1;

@FunctionalInterface
interface Calculator {
	int calculate(int i, int j);
}

public class Academy {
	void useCalculator(String label, Calculator c, int i, int j) {
		System.out.println(label + ": " + c.calculate(i, j));
	}
	
	public static void main(String[] args) {
		Academy academy = new Academy();
		academy.useCalculator("합", (i, j) -> i + j, 3, 4);
		academy.useCalculator("곱", (i, j) -> i * j, 3, 4);
	}
}
