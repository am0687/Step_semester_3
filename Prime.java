import java.util.Scanner;
public class Prime {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			boolean isPrime = true;
			System.out.println("Enter an integer: ");
			int n = sc.nextInt();
			for(int i=2;i<=n/2;i++)
			{
				if(n%i==0)
				{
					isPrime = false;
					break;
				}
			}
			if(isPrime==true)
			{
				System.out.println("Number is prime.");
			}
			else
			{
				System.out.println("Number is not prime.");
			}
			sc.close();
	}

}
