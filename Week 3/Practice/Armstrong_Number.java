import java.util.Scanner;
public class Armstrong_Number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		int origNumber = sc.nextInt();
		int n = origNumber;
		int sum = 0;
		int d;
		while(n!=0)
		{
			d=n%10;
			sum = sum+d*d*d;
			n=n/10;
		}
		if(sum==origNumber)
		{
			System.out.println("It is an Armstrong number.");
		}
		else
		{
			System.out.println("It is not an Armstrong number.");
		}
		sc.close();
	}

}
