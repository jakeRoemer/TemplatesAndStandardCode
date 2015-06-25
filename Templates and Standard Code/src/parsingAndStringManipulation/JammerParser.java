package parsingAndStringManipulation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class JammerParser {

	//Step 1: calculate confidence interval for each race for each configuration
	public static HashMap<String,JammerParser> configSet = new HashMap<String, JammerParser>();
	public LinkedList<String> raceSet;
	public LinkedList<int []> trialSet;
	public LinkedList<LinkedList<Float>> confidenceSet;
	public static int total = 0;
	private static final float t = 1.397f; //90% confidence for 10 trials
	//Step 2: compare intervals
	public static HashMap<String, LinkedList<Boolean>> universalRaceSet = new HashMap<String, LinkedList<Boolean>>(); //bitset instead of linkedlist<boolean>
	public static LinkedList<String> interestingSet = new LinkedList<String>();
	
	
	public JammerParser() {
	    raceSet = new LinkedList<String>();
	    trialSet = new LinkedList<int []>();
	    confidenceSet = new LinkedList<LinkedList<Float>>();
	}
	
	public static void main(String [] args) {
		String s1 = "V:0(9) <--> V:0(4)";
		String s2 = "V:1099(45) <--> V:1081(23)";
		String s3 = "V:0(4) <--> V:0(9)";
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < 30; i++) {
			//races[i] = "V:" + rand.nextInt(2000) + "(" + rand.nextInt(100) + ") <--> V:" + rand.nextInt(2000) + "(" + rand.nextInt(100) + ")";
			process(s1, i, 30, "config 1");
			process(s2, i, 30, "config 1");
			process(s3, i, 30, "config 1");
		}
		for (int i = 0; i < 30; i++) {
			process(s2, i, 30, "config 2");
		}
		for (int i = 0; i < 30; i++) {
			process(s3, i, 30, "config 3");
		}
		generateConfidence();
	}
    
    
    public static void process(String line, int trial, int totalTrials, String config) {
        if (!configSet.containsKey(config)) {
            configSet.put(config, new JammerParser());
        }
        if (total == 0) {
            total = totalTrials;
        }
        String [] fields = line.split("<-->");
        String s1 = fields[0].trim() + fields[1].trim();
        String s2 = fields[1].trim() + fields[0].trim();
        if (!universalRaceSet.containsKey(s1) && !universalRaceSet.containsKey(s2)) {
            universalRaceSet.put(s1, new LinkedList<Boolean>());
        }
        if (configSet.get(config).raceSet.contains(s1)) {
            configSet.get(config).trialSet.get(configSet.get(config).raceSet.indexOf(s1))[trial] = 1; //only count a race being found once per trail
            //configSet.get(config).trialSet.get(configSet.get(config).raceSet.indexOf(s1))[trial] = configSet.get(config).trialSet.get(configSet.get(config).raceSet.indexOf(s1))[trial] + 1;
        } else if (configSet.get(config).raceSet.contains(s2)) {
            configSet.get(config).trialSet.get(configSet.get(config).raceSet.indexOf(s2))[trial] = 1; //only count a race being found once per trail
            //configSet.get(config).trialSet.get(configSet.get(config).raceSet.indexOf(s2))[trial] = configSet.get(config).trialSet.get(configSet.get(config).raceSet.indexOf(s2))[trial] + 1;
        } else {
        	if (universalRaceSet.containsKey(s1)) {
        		configSet.get(config).raceSet.add(s1);
        	} else {
        		configSet.get(config).raceSet.add(s2);
        	}
            configSet.get(config).trialSet.add(new int[totalTrials]);
            configSet.get(config).trialSet.getLast()[trial] = 1; //only count a race being found once per trail
        }
    }
    
    public static void generateConfidence() {
        findConfidence();
        printConfidence();
        compareInverals();
        printComparison();
    }
    
    //Step 1
    public static void findConfidence() {
        Set<Entry<String,JammerParser>> a = configSet.entrySet(); //for each configuration
        for(Iterator<Entry<String,JammerParser>> b = a.iterator(); b.hasNext(); ) {
            Entry<String, JammerParser> c = b.next();
            System.out.println("raceSet size: " + configSet.get(c.getKey()).raceSet.size());
            for (int i = 0; i < configSet.get(c.getKey()).raceSet.size(); i++) { //for each race of each configuration
                int[] values = configSet.get(c.getKey()).trialSet.get(i);
                String race = configSet.get(c.getKey()).raceSet.get(i);
                float xPrime = 0f;
                for (int k = 0; k < values.length; k++) {
                    xPrime = xPrime + values[k];
                }
                if (total == 0) {
                    System.out.println("no trials were executed!");
                } else {
                    xPrime = xPrime/total;
                }
                float squareSum = 0f;
                for (int k = 0; k < values.length; k++) {
                    squareSum = squareSum + ((values[k] - xPrime) * (values[k] - xPrime));
                }
                squareSum = squareSum/(total-1);
                squareSum = (float) Math.sqrt(squareSum);
                configSet.get(c.getKey()).confidenceSet.add(new LinkedList<Float>());
                configSet.get(c.getKey()).confidenceSet.get(configSet.get(c.getKey()).raceSet.indexOf(race)).add(xPrime - (t*(squareSum/(float)Math.sqrt(total))));
                configSet.get(c.getKey()).confidenceSet.get(configSet.get(c.getKey()).raceSet.indexOf(race)).add(xPrime + (t*(squareSum/(float)Math.sqrt(total))));
            }
        }
    }
    
    //Step 2:
    public static void compareInverals() {
        Set<Entry<String, LinkedList<Boolean>>> x = universalRaceSet.entrySet();
        for(Iterator<Entry<String, LinkedList<Boolean>>> e = x.iterator(); e.hasNext(); ) {
            Entry<String, LinkedList<Boolean>> entry = e.next();
            String race = entry.getKey();
            Set<Entry<String,JammerParser>> y = configSet.entrySet();
            for(Iterator<Entry<String,JammerParser>> z = y.iterator(); z.hasNext(); ) {
                Entry<String, JammerParser> t = z.next();
                JammerParser config1 = t.getValue();
                Iterator<Entry<String, JammerParser>> a = y.iterator();
                Entry<String, JammerParser> b = a.hasNext() ? a.next() : null;
                while (b != t && a.hasNext()) {b = a.next();} //config0 with config1, config2. Then config1 with config2
                while (a.hasNext()) {                    
                    b = a.next();
                    JammerParser config2 = b.getValue();
                    if (config1.raceSet.contains(race)) {
                        if (config2.raceSet.contains(race)) {
                            //both have interval
                        	System.out.println("same on race: " + race);
                        	System.out.println("config1: " + t.getKey() + " config2: " + b.getKey());
                        	System.out.println("confidence1: " + config1.confidenceSet.get(config1.raceSet.indexOf(race)));
                        	System.out.println("confidence2: " + config2.confidenceSet.get(config2.raceSet.indexOf(race)));
                            checkConfidenceOverlap(t,config1.confidenceSet.get(config1.raceSet.indexOf(race)),b,config2.confidenceSet.get(config2.raceSet.indexOf(race)),race);
                        } else {
                        	System.out.println("config2 empty on race: " + race);
                        	System.out.println("config1: " + t.getKey() + " config2: " + b.getKey());
                        	System.out.println("confidence1: " + config1.confidenceSet.get(config1.raceSet.indexOf(race)));
                        	System.out.println("confidence2: (0,0)");
                            //config2: no interval exists so it is just (0,0)
                            LinkedList<Float> dummy = new LinkedList<Float>();
                            dummy.add(0f); dummy.add(0f);
                            checkConfidenceOverlap(t,config1.confidenceSet.get(config1.raceSet.indexOf(race)),b,dummy,race);
                        }
                    } else {
                        //config1: no interval exists so it is just (0,0)
                        if (config2.raceSet.contains(race)) {
                        	System.out.println("config1 empty on race: " + race);
                        	System.out.println("config1: " + t.getKey() + " config2: " + b.getKey());
                        	System.out.println("confidence1: (0,0)");
                        	System.out.println("confidence2: " + config2.confidenceSet.get(config2.raceSet.indexOf(race)));
                            //config2 has interval
                            LinkedList<Float> dummy = new LinkedList<Float>();
                            dummy.add(0f); dummy.add(0f);
                            checkConfidenceOverlap(t,dummy,b,config2.confidenceSet.get(config2.raceSet.indexOf(race)),race);
                        } else {
                        	System.out.println("both empty on race: " + race);
                        	System.out.println("config1: " + t.getKey() + " config2: " + b.getKey());
                        	System.out.println("confidence1: (0,0)");
                        	System.out.println("confidence2: (0,0)");
                            //both: no interval exists so it is just (0,0)
                            LinkedList<Float> dummy = new LinkedList<Float>();
                            dummy.add(0f); dummy.add(0f);
                            checkConfidenceOverlap(t,dummy,b,dummy,race);
                        }
                    }                    
                }
            }
        }
    }
    
    public static void checkConfidenceOverlap(Entry<String, JammerParser> config1, LinkedList<Float> interval1, Entry<String, JammerParser> config2, LinkedList<Float> interval2, String race) {
        float x1 = interval1.get(0);
        float x2 = interval1.get(1); //(x1 x2) interval
        float y1 = interval2.get(0);
        float y2 = interval2.get(1); //(y1 y2) interval
        //(x1 ----- x2)
        //             (y1 ------ y2)
        // or
        //(y1 ----- y2)
        //             (x1 ------ x2)
        System.out.println("x1: " + x1 + " x2: " + x2);
        System.out.println("y1: " + y1 + " y2: " + y2);
        if (x2 < y1 || y2 < x1) { //for (x1 x2), x1 <= x2
        	//intervals do not overlap
            universalRaceSet.get(race).add(false);
            float xPrime = 0f;
            if (config1.getValue().raceSet.contains(race)) {
            	int[] values = config1.getValue().trialSet.get(config1.getValue().raceSet.indexOf(race));
                for (int k = 0; k < values.length; k++) {
                    xPrime = xPrime + values[k];
                }
            }
            float xPrime2 = 0f;
            if (config2.getValue().raceSet.contains(race)) {
            	int[] values2 = config2.getValue().trialSet.get(config2.getValue().raceSet.indexOf(race));                
                for (int k = 0; k < values2.length; k++) {
                    xPrime2 = xPrime2 + values2[k];
                }            	
            }
            if (xPrime > xPrime2) {
            	interestingSet.add(config1.getKey());
            } else if (xPrime < xPrime2) {
            	interestingSet.add(config2.getKey());
            } else {
            	System.out.println("hmm. Races found same number of times but intervals don't overlap.");
            }
        } else {
        	//intervals do overlap
            universalRaceSet.get(race).add(true);
            System.out.println("True");
        }
    }
    
    public static void printComparison() {
        try {
            FileWriter out = new FileWriter("/home/jake/Desktop/confidence comparison.txt");
            Set<Entry<String, LinkedList<Boolean>>> x = universalRaceSet.entrySet();
            for(Iterator<Entry<String, LinkedList<Boolean>>> e = x.iterator(); e.hasNext(); ) {
                Entry<String, LinkedList<Boolean>> entry = e.next();
                String race = entry.getKey();
                LinkedList<Boolean> overlap = entry.getValue();
                Set<Entry<String,JammerParser>> y = configSet.entrySet();
                int j = 0;
                for(Iterator<Entry<String,JammerParser>> z = y.iterator(); z.hasNext(); ) {
                    Entry<String, JammerParser> t = z.next();
                    String config1 = t.getKey();
                    Iterator<Entry<String, JammerParser>> a = y.iterator();
                    Entry<String, JammerParser> b = a.hasNext() ? a.next() : null;
                    while (b != t && a.hasNext()) {b = a.next();} //config0 with config1, config2. Then config1 with config2
                    while (a.hasNext()) {                    
                        b = a.next();
                        String config2 = b.getKey();
                        out.write(config1.substring(config1.length()-1) + " & " + config2.substring(config1.length()-1) + ": ");
                        out.write(""+overlap.get(j));
                        if (!overlap.get(j)) {
                        	out.write(" " + interestingSet.remove());
                        }
                        out.write("\n");
                        j++;
                    }
                }
                out.write(race + "\n");
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Could not print comparison of confidence intervals");
        }
    }
    
    public static void printConfidence() {
        try {
            FileWriter out = new FileWriter("/home/jake/Desktop/confidence intervals.txt");
            Set<Entry<String,JammerParser>> a = configSet.entrySet();
            for(Iterator<Entry<String,JammerParser>> b = a.iterator(); b.hasNext(); ) {
                Entry<String, JammerParser> c = b.next();
                out.write("configuration " + c.getKey() + ":\n");
                System.out.println("confidenceSet size: " + configSet.get(c.getKey()).confidenceSet.size());
                for (int i = 0; i < configSet.get(c.getKey()).confidenceSet.size(); i++) {
                    String race = configSet.get(c.getKey()).raceSet.get(i);
                    LinkedList<Float> conf = configSet.get(c.getKey()).confidenceSet.get(i);
                    out.write("\t" + race + ":\n\t\t");
                    for(int q = 0; q < conf.size(); q+=2) {
                        out.write("(" + conf.get(q) + " " + conf.get(q+1) + ") ");
                    }
                    out.write("\n");
                }
                out.write("\n");
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Could not print confidence");
        }
    }
}