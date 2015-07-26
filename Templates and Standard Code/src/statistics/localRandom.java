package statistics;

import java.util.Random;

public class localRandom {

	public localRandom(long seed) {
		this.seed = (seed ^ multiplier) & mask;
	}

	private volatile long seed;
	private final static long multiplier = 0x5DEECE66DL;
	private final static long addend = 0xBL;
	private final static long mask = (1L << 48) - 1;
	
	//Testing local random against java library random
	//No difference between local random and java library random after 1B iterations
	//TODO: More concrete statistical analysis [Pearson's Chi-squared test]
	public static void main (String [] args) {
		System.out.println("begin");
		for (int j = 0; j < 100; j++) {
			long num = System.currentTimeMillis();
			Random rand = new Random(num);
			localRandom localRand = new localRandom(num);
			Random rand2 = new Random(num);
			int [] chiLocalTest = new int [10000000];
			int [] chiTest = new int [10000000];
			int [] rand2Test = new int [10000000];
			int range = 10;
			for (int i = 0; i < chiTest.length; i++) {
				chiLocalTest[i] = localRand.nextInt(range);
				chiTest[i] = rand.nextInt(range);
				rand2Test[i] = rand2.nextInt(range);
				if (chiTest[i] != chiLocalTest[i]) {
					System.out.println("rand1 differs local");
				}
				if (rand2Test[i] != chiLocalTest[i]) {
					System.out.println("rand2 differs local");
				}
				if (chiTest[i] != rand2Test[i]) {
					System.out.println("rand1 differs rand2");
				}
			}
		}
		//System.out.println("chi local test: " + chiSquaredTest.testing(chiLocalTest, chiLocalTest.length, range));
		//System.out.println("chi test: " + chiSquaredTest.testing(chiTest, chiTest.length, range));
		System.out.println("end");
	}

	public int nextInt(int n) {
		if ((n & -n) == n) { // i.e., n is a power of 2
			return (int) ((n * (long) next(31)) >> 31);
		}
		int bits, val;
		do {
			bits = next(31);
			val = bits % n;
		} while (bits - val + (n - 1) < 0);
		return val;
	}

	protected int next(int bits) {
		long oldseed, nextseed;
		long seed = this.seed;
		do {
			oldseed = seed;
			nextseed = (oldseed * multiplier + addend) & mask;
		} while (!compareAndSet(oldseed, nextseed));
		return (int) (nextseed >>> (48 - bits));
	}

	public boolean compareAndSet(long oldseed, long nextseed) {
		if (this.seed == oldseed) {
			this.seed = nextseed;
			return true;
		} else {
			this.seed = oldseed;
			return false;
		}
	}
}