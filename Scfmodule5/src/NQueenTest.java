import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenTest {

	NQueen solve = new NQueen();

	@Test
	public void nQueenProblemTest() {
		assertEquals(false,solve.nQueen(new int[][] { { 0, 0, 0 }, { 0, 0, 0 },{ 0, 0, 0 } }, 0, 3));
		assertEquals(true,solve.nQueen(new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 },{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } }, 0, 4));
		assertEquals(true,solve.nQueen(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 } }, 0, 8));
	}

}