import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class IntSetTest {

	@Test(expected = AssertionError.class)
	public void throwsAssertionErrorIfSetIsEmpty() {
		IntSet intSet = new IntSet(new int[] {});
	}
	
	@Test(expected = AssertionError.class)
	public void throwsAssertionErrorIfSetIsNull() {
		IntSet intSet = new IntSet(null);
	}

	@Test(expected = AssertionError.class)
	public void throwsAssertionErrorIfSetIsNotInRange() {
		IntSet intSet = new IntSet(new int[] { 1, 3, 5, 1111 });
	}

	@Test
	public void isMemberTest() {
		IntSet intSet = new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18, 40 });
		assertEquals(true, intSet.isMember(5));
		assertEquals(false, intSet.isMember(2));
		assertEquals(true, intSet.isMember(12));
	}

	@Test
	public void isSubSetTest() {
		IntSet intSet = new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18, 40 });
		assertEquals(true, intSet.isSubSet(new IntSet(new int[] { 8, 15 })));
		assertEquals(true, intSet.isSubSet(new IntSet(new int[] { 8, 15, 40 })));
		assertEquals(true,intSet.isSubSet(new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18,40 })));
		assertEquals(true,intSet.isSubSet(new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18,40 })));
	}

	@Test
	public void getComplementTest() {

		IntSet intSet = new IntSet(new int[] { 1, 2, 4, 7, 8, 9, 23, 60 });
		int[] expectedArray = new int[1001 - intSet.size()];
		int increment = 0;
		
		for (int index = 0; index <= 1000; index++) {

			if (!(intSet.isMember(index))) {
				expectedArray[increment] = index;
				increment++;
			}
		}
		assertArrayEquals(expectedArray, (intSet.getComplement()));
	}

	@Test
	public void unionTest() {
		IntSet intSet1 = new IntSet(new int[] { 4, 4, 6, 9, 1 });
		IntSet intSet2 = new IntSet(new int[] { 1, 4, 2, 8 });
		int expectedArray[] = { 1, 2, 4, 6, 8, 9 };

		assertArrayEquals(expectedArray, IntSet.union(intSet1, intSet2).setArray);

	}
}
