/*
����
���輺��

����
���� ������ �Է¹޾� 90 ~ 100���� A, 80 ~ 89���� B, 70 ~ 79���� C, 60 ~ 69���� D, ������ ������ F�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� ������ �־�����. ���� ������ 0���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�.

���
���� ������ ����Ѵ�.
*/
package step2_���ǹ�;

import java.util.Scanner;

public class print_���輺��_9498 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		if(x<=100 && x>=90) {
			System.out.println("A");
		}else if(x<=89 && x>=80) {
			System.out.println("B");
		}else if(x<=79 && x>=70) {
			System.out.println("C");
		}else if(x<=69 && x>=60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
	}	
}
