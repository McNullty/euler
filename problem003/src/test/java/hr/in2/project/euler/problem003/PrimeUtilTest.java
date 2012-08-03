package hr.in2.project.euler.problem003;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

public class PrimeUtilTest {
	
	private PrimeUtil primeUtil;
	
	@Before
	public void setUp(){
		primeUtil = new PrimeUtil();
	}

	@Test
	public void testGetGratestPrimeFactor25() {
		// 5 * 5
		BigInteger resault = primeUtil.getGratestPrimeFactor(new BigInteger("25"));
		assertEquals(new BigInteger("5"), resault);
	}
	
	@Test
	public void testGetGratestPrimeFactor21() {
		// 3 * 7
		BigInteger resault = primeUtil.getGratestPrimeFactor(new BigInteger("21"));
		assertEquals(new BigInteger("7"), resault);
	}
	
	@Test
	public void testGetGratestPrimeFactor165() {
		// 3 * 5 * 11
		BigInteger resault = primeUtil.getGratestPrimeFactor(new BigInteger("165"));
		assertEquals(new BigInteger("11"), resault);
	}
	
	@Test
	public void testGetGratestPrimeFactor1815() {
		// 3 * 5 * 11 * 11
		BigInteger resault = primeUtil.getGratestPrimeFactor(new BigInteger("1815"));
		assertEquals(new BigInteger("11"), resault);
	}
	
	@Test
	public void testGetGratestPrimeFactor825() {
		// 3 * 5 * 5 * 11 
		BigInteger resault = primeUtil.getGratestPrimeFactor(new BigInteger("825"));
		assertEquals(new BigInteger("11"), resault);
	}
	
	@Test
	public void testIsDivisable(){
		boolean check = primeUtil.isDivisable(new BigInteger("3"), new BigInteger("2"));
		assertFalse(check);
		
		check = primeUtil.isDivisable(new BigInteger("6"), new BigInteger("3"));
		assertTrue(check);
		
		check = primeUtil.isDivisable(new BigInteger("21"), new BigInteger("7"));
		assertTrue(check);
		
		check = primeUtil.isDivisable(new BigInteger("23"), new BigInteger("7"));
		assertFalse(check);
	}
	
	@Test
	public void testNextPrime(){
		BigInteger i = primeUtil.getNextPrime();
		assertEquals(new BigInteger("3"), i);
		
		i = primeUtil.getNextPrime();
		assertEquals(new BigInteger("5"), i);
		
		i = primeUtil.getNextPrime();
		assertEquals(new BigInteger("7"), i);
		
		i = primeUtil.getNextPrime();
		assertEquals(new BigInteger("11"), i);
		
		i = primeUtil.getNextPrime();
		assertEquals(new BigInteger("13"), i);
		
		i = primeUtil.getNextPrime();
		assertEquals(new BigInteger("17"), i);
		
		i = primeUtil.getNextPrime();
		assertEquals(new BigInteger("19"), i);
		
		i = primeUtil.getNextPrime();
		assertEquals(new BigInteger("23"), i);
	}

}
