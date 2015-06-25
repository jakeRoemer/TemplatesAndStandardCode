package statistics;

import org.apache.commons.math3.stat.interval.ConfidenceInterval;
import org.apache.commons.math3.stat.interval.IntervalUtils;

public class confidenceIntervals {
	public static void main(String [] args) {
		ConfidenceInterval cpi = IntervalUtils.getClopperPearsonInterval(10, 9, 0.95);
		System.out.println("confidence level: " + cpi.getConfidenceLevel());
		System.out.println("lower bound: " + cpi.getLowerBound());
		System.out.println("upper bound: " + cpi.getUpperBound());
		ConfidenceInterval aci = IntervalUtils.getAgrestiCoullInterval(10, 9, 0.95);
		System.out.println("confidence level: " + aci.getConfidenceLevel());
		System.out.println("lower bound: " + aci.getLowerBound());
		System.out.println("upper bound: " + aci.getUpperBound());
		ConfidenceInterval wsi = IntervalUtils.getWilsonScoreInterval(10, 9, 0.95);
		System.out.println("confidence level: " + wsi.getConfidenceLevel());
		System.out.println("lower bound: " + wsi.getLowerBound());
		System.out.println("upper bound: " + wsi.getUpperBound());
		ConfidenceInterval nai = IntervalUtils.getNormalApproximationInterval(10, 9, 0.95);
		System.out.println("confidence level: " + nai.getConfidenceLevel());
		System.out.println("lower bound: " + nai.getLowerBound());
		System.out.println("upper bound: " + nai.getUpperBound());
	}
}
