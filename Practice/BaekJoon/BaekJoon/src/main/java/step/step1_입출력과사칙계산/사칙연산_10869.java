/*
����
��Ģ����

����
�� �ڿ��� A�� B�� �־�����. �̶�, A+B, A-B, A*B, A/B(��), A%B(������)�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 

�Է�
�� �ڿ��� A�� B�� �־�����. (1 �� A, B �� 10,000)

���
ù° �ٿ� A+B, ��° �ٿ� A-B, ��° �ٿ� A*B, ��° �ٿ� A/B, �ټ�° �ٿ� A%B�� ����Ѵ�.
*/
package step1_����°���Ģ���;

import java.util.Scanner;

public class ��Ģ����_10869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); //intŸ���� �� ������ ������ '��°��'�� ����, intŸ���̱� �����̴�
		int B = sc.nextInt(); //������ ����ؾߵǴ� ���� �� ���ξ���Ѵ�

		System.out.println(A+B);
		System.out.println(A-B);
		System.out.println(A*B);
		System.out.println(A/B);
		System.out.println(A%B); // '%'�� '��ⷯ'��� �д´�
		
	}
}
