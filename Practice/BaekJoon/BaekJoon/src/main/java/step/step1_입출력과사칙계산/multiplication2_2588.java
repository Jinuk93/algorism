/*
����
����

����
(�� �ڸ� ��) �� (�� �ڸ� ��)�� ������ ���� ������ ���Ͽ� �̷������.

(1)�� (2)��ġ�� �� �� �ڸ� �ڿ����� �־��� �� (3), (4), (5), (6)��ġ�� �� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� (1)�� ��ġ�� �� �� �ڸ� �ڿ�����, ��° �ٿ� (2)�� ��ġ�� �� ���ڸ� �ڿ����� �־�����.

���
ù° �ٺ��� ��° �ٱ��� ���ʴ�� (3), (4), (5), (6)�� �� ���� ����Ѵ�. 
*/

package step1_����°���Ģ���;

import java.util.Scanner;

//�� ������ ���� �״�� �����Դ�. �������� �����غ��� ���� �ĺ��ô�!
//�켱 ������ ���� ������������ �����غ��ô�

public class multiplication2_2588 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String one = sc.nextLine();
        String two = sc.nextLine();
 
        int t1 = Integer.parseInt(two.substring(2));
        int t10 = Integer.parseInt(two.substring(1,2));
        int t100 = Integer.parseInt(two.substring(0,1));        
        
        int o = Integer.parseInt(one);        
        
        System.out.println(o*t1);
        System.out.println(o*t10);
        System.out.println(o*t100);
 
        System.out.println(((o*t100)*100)+((o*t10)*10)+(o*t1));
    }
}