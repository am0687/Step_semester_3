import java.util.Scanner;
public class GCD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 numbers: ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int r;
		while(n2!=0)
		{
			r=n1%n2;
			n1 = n2;
			n2 = r;
		}
		System.out.println("GCD: "+ n1);
		sc.close();
	}

}
