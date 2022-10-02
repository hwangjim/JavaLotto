package test;

import java.util.Random; // 랜덤 클래스 사용
import java.util.Scanner; // 스캐너 클래스 사용

public class TEST {

	// 배열을 입력하면 배열을 콘솔창에 출력해주는 함수
	static void f1(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

	// 개수를 입력하면 그 개수만큼의 복권을 반환해주는 함수
	static int[] f2(int num) {
		Random rand = new Random(); // 랜덤 사용
		int[] lotto = new int[num]; // 로또는 개수만큼 복권 번호 반환

		for (int i = 0; i < num; i++) { // 개수는 0 ~ 4까지 == 인덱스 넘버로
			lotto[i] = rand.nextInt((50) + 1); // 1 ~ 50까지 랜덤
			// 중복검사 실행
			for (int j = 0; j < i; j++) {
				// 만약, 다른 인덱스 넘버의 로또 번호가 서로 같다면 중복이므로
				// 이를 방지해주는 for문 코드
				if (lotto[i] == lotto[j]) {
					// i--;로 인해 숫자가 같지 않게끔 한다.
					i--;
					break;
				}
			}
		}
		// 완성된 로또 값을 "반환" 한다.
		return lotto;
	}

	public static void main(String[] args) {
		// 입력하기 위해 스캐너 실행
		Scanner sc = new Scanner(System.in);
		// 유효성 검사 실행 
		// 얼마나 틀릴지 모르고, 틀릴때마다 반복해서 알려줘야하기 떄문에 while문 사용
		while (true) {
			// 입력이 잘 되었는지 판별하는 boolean 메소드 사용
			// true로 값을 놓고 정수가 1에서 50사이라면 true값 
			boolean flag = true;
			System.out.print("정수입력: ");
			int num = sc.nextInt(); 	// 정수 입력 
			
			// num을 사용한 이유는 num이 배열의 개수이기때문에
			// 1 ~ 50까지의 숫자기 때문에 0이하, 50 이상으로 뽑으면 다시 입력해야하는 문구 출력 필요
			if (num <= 0 || num > 50) {
				System.out.println("잘못된 숫자입니다. 1에서 50사이의 숫자로 다시 입력하세요");
				// if 문 내의 조건식에 해당될 경우 false
				// false일 경우 while문의 처음인 "정수 입력" 으로 돌아감
				flag = false;
			} else {
				// 입력한 번호 개수를 랜덤으로 뽑아 내는 f2코드
				int[] lotto = f2(num);
				// f2코드를 f1코드에 맞게 출력
				f1(lotto);
				// 올바르게 입력했다면 while문을 멈추는 break 사용 
				break;
			}
			
		}

	}
}