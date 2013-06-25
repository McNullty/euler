package hr.in2.project.euler.problem005;

import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequenceDivader {
	private static Logger log = LoggerFactory.getLogger(SequenceDivader.class);

	private TreeSet<Integer> dividers;
	private int gratestDivider;

	public SequenceDivader(int n) {

		dividers = getDivaderSet(n);
		gratestDivider = dividers.last();

		dividers.remove(gratestDivider);
		log.trace("dividers: {}", dividers);
	}

	public int calculateNumber() {

		int i = 1;
		int ret;
		boolean dividedByAll;

		while (true) {
			ret = gratestDivider * i;
			log.trace("Potetianl Return: {}", ret);

			dividedByAll = true;
			for (Integer n : dividers) {
				if (ret % n != 0) {
					dividedByAll = false;
					break;
				}
			}

			if (dividedByAll) {
				break;
			}
			i++;

		}

		return ret;
	}

	static TreeSet<Integer> getDivaderSet(int n) {
		TreeSet<Integer> ret = new TreeSet<Integer>();

		// add all numbers to set
		for (int i = 1; i <= n; i++) {
			ret.add(i);
		}

		log.trace("Reverse set: {}", ret.descendingSet());

		TreeSet<Integer> reverse = (TreeSet<Integer>) ret.descendingSet();
		@SuppressWarnings("unchecked")
		TreeSet<Integer> reverseClone = (TreeSet<Integer>) reverse.clone();
		@SuppressWarnings("unchecked")
		TreeSet<Integer> clone = (TreeSet<Integer>) ret.clone();
		for (Integer integer : reverseClone) {
			for (Integer j : clone) {
				if (j.equals(integer)) {
					break;
				}

				if (integer % j == 0) {
					ret.remove(j);
				}
			}
		}

		return ret;
	}
}
