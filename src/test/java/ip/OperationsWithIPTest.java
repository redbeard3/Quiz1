
import ip.OperationsWithIP;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class OperationsWithIPTest{
	private static OperationsWithIP operationsWithIP;

	@Before
	public static void initOperationWithIP(){
		operationsWithIP = new OperationsWithIP();
	}

	@After
	public static void clearOperationsWithIP(){
		operationsWithIP = null;
	}

	@Test
	public void ipToLongTest() throws UnknownHostException{
		long expected = 3232235525L;
		long actual = operationsWithIP.ipToLong(InetAddress.getByName("192.168.0.5"));
		assertEquals("ip to long:", expected, actual);
	}

	@Test void longToIpTest(){
		String expected = "192.168.0.5";
		String actual = operationsWithIP.longToIp(3232235525L);
		assertEquals("long to ip:", expected, actual);
	}

	@Test
	public void checkIpTest(){
		assertTrue(operationsWithIP.checkIP("192.168.0.5"));
		assertFalse(operationsWithIP.checkIP("192.168/0/5"));
	}

}