import java.util.Scanner;
public class Sumofnatnum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		int n = sc.nextInt();
		int i=0,sum = 0;
		while(i<=n)
		{
			sum+=i;
			i++;
		}
		System.out.println(sum);
		sc.close();
	}

}
