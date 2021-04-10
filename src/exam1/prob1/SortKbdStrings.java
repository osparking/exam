package exam1.prob1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class SortByLen implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
	}
}

/** 
 * 이 프로그램은 한 줄에 여러 단어를 키보드에서 입력받아 단어 길이로 정렬하여 출력한다.
 * 빈 행이 입력되면 실행이 종료된다. 특히, 4가지 정렬 방법을 사용하여 출력이 4회 이루어진다.
 * @author Jongbum Park
 *
 */
public class SortKbdStrings {

	void sortWordsUsingVariousOptions(String[] words, int option) {
		switch (option) {
		case 1:
			/**
			 * 제 1 방법: Comparator 를 구현하는 SortByLen 클래스 객체 사용
			 */
			Arrays.sort(words, new SortByLen());
			break;
		case 2:
			/**
			 * 제 2 방법: Comparator 를 구현하는 익명 객체 사용
			 * (Comparator 인터'를 구현하는 (익명)클래스 객체가 생성되어 sort 로 전달된다.)
			 */
			Arrays.sort(words, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return Integer.compare(o1.length(), o2.length());
				}
			});
			break;
		case 3:
			/**
			 * 제 3 방법: Comparator<T> 반환하는 Comparator의 정적 메소드 사용
			 * 사용되는 정적 메소드 comparing 은 각 String에 length 함수를 적용하여 순서를 정한다.
			 * 그 length 속성 값을 사용한다. 여기서 words 가 String 배열이어야 된다.
			 * Double salaries[] = {-55., 67., -180.};
			 * Arrays.sort(salaries, Comparator.comparing(Math::abs));
			 * System.out.println(Arrays.toString(salaries));
			 */
			Arrays.sort(words, Comparator.comparing(String::length));
			break;

		case 4:
			/**
			 * 제 4 방법: 함수적 인터페'인 Comparator 의 유일 추상 메소드와 일치하는 람다식을 인자로 전달
			 */
			Arrays.sort(words, (s1, s2) -> (s1.length() - s2.length()));
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		SortKbdStrings agency = new SortKbdStrings();
		try (Scanner scanner = new Scanner(System.in)) {
			String line = null;
			while (true) {
				System.out.println("좋아하는 단어들을 콤마(,), 점(.) 혹은 빈칸으로 분리하며 입력하시오: ");
				line = scanner.nextLine();
				if (line.length() == 0)
					break;
				String unsorted[] = line.split("[,. ]");
				String toBeSorted[] = Arrays.copyOf(unsorted, unsorted.length);

				for (int option = 0; option < 4; option++) {
					agency.sortWordsUsingVariousOptions(toBeSorted, option + 1);
					System.out.println(Arrays.toString(toBeSorted));
					toBeSorted = Arrays.copyOf(unsorted, unsorted.length);
				}
			}
			System.out.println(".");
		}
	}
}
