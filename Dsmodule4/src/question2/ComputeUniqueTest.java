package question2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
/**
 * Test case for compute unique class.
 */
public class ComputeUniqueTest {

	private ComputeUnique uniques = new ComputeUnique();
	
	@Test
	public void allDifferentChartest() {
		Integer uniqueResult = uniques.computeUnique("mahendar");
		
		assertEquals((Integer)7, uniqueResult);
	}

	@Test
	public void sameAndCapitalChartest()  {
		
		Integer uniqueResult = uniques.computeUnique("mahendarSaRan");
		assertEquals((Integer)8, uniqueResult);
	}
	
	@Test
	public void specialCharacterAndNumericChartest() {
		
		Integer uniqueResult = uniques.computeUnique("R0H!TSh4RM@");
		assertEquals((Integer)9, uniqueResult);
	}
	
	
	@Test
	public void cachePresencetest() {
		uniques.computeUnique("mahendar");

		assertTrue(uniques.getCacheMemory().isPresent("mahendar".toUpperCase()));
		assertFalse(uniques.getCacheMemory().isPresent("rahul".toUpperCase()));
	}
	
	@Test
	public void allSpaceChartest() {
		Integer uniqueResult = uniques.computeUnique("    ".toUpperCase());
		
		assertEquals((Integer)1, uniqueResult);
	}
	
	
}
