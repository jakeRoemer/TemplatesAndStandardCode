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
		Random rand = new Random(System.currentTimeMillis());
		localRandom localRand = new localRandom(System.currentTimeMillis());
		System.out.println("begin");
		for (int i = 0; i < 1000000000; i++) {
			if (rand.nextInt(1073741824) != localRand.nextInt(1073741824)) {
				System.out.println("differs");
			}
		}
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