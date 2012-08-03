package hr.in2.project.euler.problem003;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Problem003 {
	private static Logger log = LoggerFactory.getLogger(Problem003.class);
	
	public static void main(String[] args) {
		PrimeUtil pu = new PrimeUtil();
		BigInteger n = new BigInteger("600851475143");
		
		log.info("Start calculation");
		BigInteger resault = pu.getGratestPrimeFactor(n);
		log.info("End calculation");
		System.out.println("resault = " + resault);
	}
}
