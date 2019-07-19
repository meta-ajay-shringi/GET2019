import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MathOperationTest {
	MathOperation MathOperation;
	
	@Before
	public void test()
	{
	  MathOperation = new MathOperation();
	}
	@Test 
	public void lcmTest() {
		
		assertEquals(20,MathOperation.lcm(4,5));
		assertEquals(6,MathOperation.lcm(6,1));
		assertEquals(21,MathOperation.lcm(7,3));
	}
	
	@Test
	public void hcfTest() {
		assertEquals(1,MathOperation.hcf(7,13));
		assertEquals(4,MathOperation.hcf(32,20));
		assertEquals(3,MathOperation.hcf(15,3));
	}

}
