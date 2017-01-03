package jugru;

import org.junit.*;

public class TestService {
	@Test
	public void testMsg() {
		String str = (new Service()).getMsg();
		System.out.println("MESSAGE " + str);
		Assert.assertEquals("2 B || ! 2 B", str);
	}
}