import static org.junit.Assert.*;

import org.junit.Test;


public class AreaTest {
	
      Area	area = new Area();

     @Test(expected = AssertionError.class)
     public void triangleAreaTest_exceptionExpected() {
    	 double input = area.triangleArea(-4,3);
		assertEquals(-3,(int) input);
    }	
		
	@Test
	public void triangleAreaTest() {
		double input1 = area.triangleArea(4,3);
		assertEquals(6,(int)input1);
	}

	@Test(expected = AssertionError.class)
     public void rectangleAreaTest_exceptionExpected() {
		double input = area.rectangleArea(-4,3);
		assertEquals(-3,(int) input);
    }

	
	@Test
	public void rectangleAreaTest() {
		double input = area.rectangleArea(4,3);
		assertEquals(12,(int)input);
		double input1 = area.rectangleArea(8,3);
		assertEquals(24,(int)input1);
		double input2 = area.rectangleArea(2,2);
		assertEquals(4,(int)input2);
	}
	
	@Test(expected = AssertionError.class)
     public void squareArea_exceptionExpected() {
		double input = area.squareArea(-4);
		assertEquals(16,(int)input);
    }	
		
	@Test
	public void squareAreaTest() {
		double input = area.squareArea(4);
		assertEquals(16,(int)input);
		double input1 = area.squareArea(3);
		assertEquals(9,(int)input1);
		double input2 = area.squareArea(2);
		assertEquals(4,(int)input2);
	}
	
	@Test(expected = AssertionError.class)
    public void circleArea_exceptionExpected() {
		double input = area.circleArea(-4);
		assertEquals(16,(int)input);
   }	
		
	@Test
	public void circleAreaTest() {
		double input = area.circleArea(5);
		assertEquals((int)78.5,(int)input);
		double input1 = area.circleArea(6);
		assertEquals((int)113.04,(int)input1);
	}
	
}