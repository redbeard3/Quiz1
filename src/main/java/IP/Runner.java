import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;


public class Runner{

	public static void main(String[] args) throws UnknownHostException{
		String stringLowIP = "";
		String stringHighIP="";

		Scanner in = new Scanner(System.in);
		
		boolean check = false;
		do{
		System.out.println("Enter first bound of IP (example: 192.168.0.0)");
		stringLowIP = in.nextLine();
		check = OperationsWithIP.checkIP(stringLowIP);
		if (check == false) System.out.println("Wrong format IP. Try again!");}
		while (!check);

		check = false;
		do{
		System.out.println("Enter second bound of IP (example: 192.168.0.10)");
		stringHighIP = in.nextLine();
		check = OperationsWithIP.checkIP(stringHighIP);
		if (check == false) System.out.println("Wrong format IP. Try again!");}
		while (!check);

		

		long lowIP = OperationsWithIP.ipToLong(InetAddress.getByName(stringLowIP));
		long highIP = OperationsWithIP.ipToLong(InetAddress.getByName(stringHighIP));
		
		long diff = Math.abs(highIP - lowIP);
		System.out.println("Permissible IP addresses:");
		if (lowIP < highIP) {
			for (long i =1; i < diff; i++)
				System.out.println(OperationsWithIP.longToIp(lowIP + i));}
			else if (lowIP > highIP) {
				for (long i =1; i < diff; i++)
					System.out.println(OperationsWithIP.longToIp(highIP + i));
			} else if ((lowIP == highIP) || (diff == 1))  System.out.println("Nothing to show.");   // diff == 1 ??
		}
			

	
	}
