package hr.in2.project.euler.problem003;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Program pokušava podjeljiti zadani broj sa zadnjim poznatim prim brojem, ako
 * ne uspije traži sljedeći prim broj i ponavlja akociju
 * 
 * @author mladenc
 * 
 */
public class PrimeUtil {
	private static Logger log = LoggerFactory.getLogger(PrimeUtil.class);

	private Set<BigInteger> primes = new TreeSet<BigInteger>();
	private BigInteger lastPrime = new BigInteger("2");

	public PrimeUtil() {
		// 2 je sigurno prim broj
		primes.add(new BigInteger("2"));
	}

	public BigInteger getGratestPrimeFactor(BigInteger n) {
		for (;;) {
			if (isDivisable(n, lastPrime)) {
				// ako je djeljiv sa najvećim poznatim prim brojem
				BigInteger n2 = n.divide(lastPrime);
				log.debug("new check number: {}", n2);

				
				if (n2.compareTo(lastPrime) < 0  && checkIsPrime(n2)) {
					// n2 <  lastPrime 
					return lastPrime;
				} else {
					return getGratestPrimeFactor(n2);
				}
			} else {
				lastPrime = getNextPrime();
			}
		}
	}

	protected BigInteger getNextPrime() {
		try {
			log.trace("start getNextPrime");

			for (;;) {
				lastPrime = lastPrime.add(new BigInteger("1"));

				if (checkIsPrime(lastPrime)) {
					return lastPrime;
				}
			}
		} finally {
			log.trace("end getNextPrime");
		}
	}

	/**
	 * Ako se prođe kroz sve poznate prim brojeve i broj nije djeljiv to znači
	 * da je taj broj prim broj
	 * 
	 * @param checkPrime
	 * @return
	 */
	private boolean checkIsPrime(BigInteger checkPrime) {
		try {
			if (primes.contains(checkPrime)) {
				return true;
			}
			log.trace("start checkIsPrime");

			for (BigInteger n : primes) {
				if (isDivisable(checkPrime, n)) {
					return false;
				}
			}

			log.debug("Found new prime number: {}", checkPrime);
			primes.add(checkPrime);
			return true;
		} finally {
			log.trace("end checkIsPrime");
		}
	}

	protected boolean isDivisable(BigInteger checkPrime, BigInteger n) {
		try {
			log.trace("stat isDivisable");
			log.debug("Broj koji se provjerava {}", checkPrime);
			log.debug("Potencijalni djelitelj {}", n);
			BigInteger i = checkPrime.mod(n);
			log.debug("ostatak djeljenja je {}", i);

			if (i.equals(new BigInteger("0"))) {
				return true;
			} else {
				return false;
			}
		} finally {
			log.trace("end isDivisable");
		}
	}
}
