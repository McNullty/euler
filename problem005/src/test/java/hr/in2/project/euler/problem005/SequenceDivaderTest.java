package hr.in2.project.euler.problem005;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class SequenceDivaderTest {
	
	@Test
	public void testCalculate10(){
		SequenceDivader sd = new SequenceDivader(10);
		int n = sd.calculateNumber();
		
		assertEquals(2520, n);
	}

	@Test
	public void testGetDivaderSet() {
		TreeSet<Integer> expected = new TreeSet<Integer>();
		expected.add(10);
		expected.add(9);
		expected.add(8);
		expected.add(8);
		expected.add(7);
		expected.add(6);

		TreeSet<Integer> actual = SequenceDivader.getDivaderSet(10);

		assertEquals(expected, actual);

		expected = new TreeSet<Integer>();
		expected.add(20);
		expected.add(19);
		expected.add(18);
		expected.add(17);
		expected.add(16);
		expected.add(15);
		expected.add(14);
		expected.add(13);
		expected.add(12);
		expected.add(11);

		actual = SequenceDivader.getDivaderSet(20);

		assertEquals(expected, actual);
	}

}
