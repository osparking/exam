package exam1.prob2.answer2;

class Calculator {
	int add(int i, int j) {
		return i + j;
	}
	int multiply(int i, int j) {
		return i * j;
	}
}

/**
 * 함수적 인터'와 람다식의 우수성을 클래스 버전과 비교하며 배우는 사례
 * 차(빼기), 제(나누기) 가 추가되면 어떻게 확장되어야 하는가?
 * @author Jongbum Park
 *
 */
public class Academy {
	void useCalculator(int i, int j) {
		Calculator c = new Calculator();
		System.out.println("합: " + c.add(i, j));
		System.out.println("곱: " + c.multiply(i, j));
	}	

	public static void main(String[] args) {
		Academy academy = new Academy();
		academy.useCalculator(3, 4);
	}
}
