import java.util.Scanner;
public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int origNumber = sc.nextInt();
		int reversedNumber = 0;
		int n = origNumber;
		int d;
		while(n!=0)
		{
			d = n%10;
			reversedNumber = reversedNumber*10 + d;
			n=n/10;
		}
		if(reversedNumber==origNumber)
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not Palindrome");
		}
		sc.close();
	}

}
