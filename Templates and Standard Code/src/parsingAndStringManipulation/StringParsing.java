package parsingAndStringManipulation;

public class StringParsing {
	public static void main(String [] args) {
		String s = "hello world";
		//specialCharSplit(s);
		String [] ss = {"LjavalangClass;.getDefaultConstructor()LorgjikesrvmclassloaderRVMMethod;:705(69)LjavalangClass;.getDefaultConstructor()LorgjikesrvmclassloaderRVMMethod;:703(65)",
				"LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:361(69)LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:361(69)",
				"LgnujavautilregexREToken;.<init>(I)V:44(11)LgnujavautilregexREToken;.getNext()LgnujavautilregexREToken;:123(15)",
				"LjavautilTreeMap;.rotateRight(LjavautilTreeMap$Node;)V:1379(94)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1399(36)",
				"LjavautilTreeMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:548(143)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1394(24)",
				"LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:82(49)LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:74(2)",
				"LjavautilTreeMap;.rotateLeft(LjavautilTreeMap$Node;)V:1337(65)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1394(24)",
				"LjavautilHashMap;.hash(LjavalangObject;)I:688(13)LjavautilHashMap;.rehash()V:741(32)",
				"LjavautilTreeMap$Node;.<init>(LjavalangObject;LjavalangObject;I)V:189(24)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1404(46)",
				"LjavautilHashMap;.addEntry(LjavalangObject;LjavalangObject;IZ)V:649(19)LjavautilHashMap;.containsKey(LjavalangObject;)Z:324(30)",
				"LjavalangClass;.getDefaultConstructor()LorgjikesrvmclassloaderRVMMethod;:703(65)LjavalangClass;.getDefaultConstructor()LorgjikesrvmclassloaderRVMMethod;:703(65)",
				"LjavautilHashMap;.get(LjavalangObject;)LjavalangObject;:298(11)LjavautilHashMap;.addEntry(LjavalangObject;LjavalangObject;IZ)V:650(29)",
				"LorgjaxenQualifiedName;.<init>(LjavalangString;LjavalangString;)V:75(13)LorgjaxenQualifiedName;.equals(LjavalangObject;)Z:91(10)",
				"LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:353(44)LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:352(36)",
				"LnetsourceforgepmdjaxenAttributeAxisIterator$MethodWrapper;.<init>(LjavalangreflectMethod;)V:23(18)LnetsourceforgepmdjaxenAttributeAxisIterator;.getNextAttribute()LnetsourceforgepmdjaxenAttribute;:84(40)",
				"LjavautilAbstractMap$SimpleEntry;.<init>(LjavalangObject;LjavalangObject;)V:700(11)LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:353(44)",
				"LjavautilTreeMap;.rotateLeft(LjavautilTreeMap$Node;)V:1328(10)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1401(52)",
				"LjavautilTreeMap;.rotateLeft(LjavautilTreeMap$Node;)V:1330(28)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1404(46)",
				"LjavautilTreeMap$Node;.<init>(LjavalangObject;LjavalangObject;I)V:189(24)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1399(36)",
				"LjavautilTreeMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:542(119)LjavautilTreeMap;.firstNode()LjavautilTreeMap$Node;:957(1)",
				"LnetsourceforgepmdRuleViolation;.<init>(LnetsourceforgepmdRule;LnetsourceforgepmdRuleContext;LnetsourceforgepmdastSimpleNode;LjavalangString;)V:72(14)LnetsourceforgepmdRuleViolation;.getFilename()LjavalangString;:183(1)",
				"LjavautilHashMap;.rehash()V:752(97)LjavautilHashMap;.containsKey(LjavalangObject;)Z:319(11)",
				"LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:82(54)LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:82(49)",
				"LjavautilTreeMap;.rotateLeft(LjavautilTreeMap$Node;)V:1345(89)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1394(24)",
				"LnetsourceforgepmdReport;.<init>()V:123(81)LnetsourceforgepmdReport;.getSuppressedRuleViolations()LjavautilList;:173(1)",
				"LjavautilAbstractMap$SimpleEntry;.<init>(LjavalangObject;LjavalangObject;)V:700(11)LjavautilHashMap;.get(LjavalangObject;)LjavalangObject;:302(28)",
				"LjavautilTreeMap;.rotateRight(LjavautilTreeMap$Node;)V:1379(94)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1404(46)",
				"LorgjaxenQualifiedName;.<init>(LjavalangString;LjavalangString;)V:76(18)LorgjaxenQualifiedName;.equals(LjavalangObject;)Z:91(20)",
				"LjavautilTreeMap;.rotateLeft(LjavautilTreeMap$Node;)V:1346(94)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1399(36)",
				"LjavautilHashMap;.addEntry(LjavalangObject;LjavalangObject;IZ)V:650(29)LjavautilHashMap;.addEntry(LjavalangObject;LjavalangObject;IZ)V:650(29)",
				"LgnujavautilregexRETokenChar;.matchThis(LgnujavautilregexCharIndexed;LgnujavautilregexREMatch;)LgnujavautilregexREMatch;:67(33)LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:82(54)",
				"LgnujavautilregexREToken;.setUncle(LgnujavautilregexREToken;)V:70(2)LgnujavautilregexREToken;.getNext()LgnujavautilregexREToken;:123(15)",
				"LjavautilTreeMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:546(133)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1401(52)",
				"LjavautilHashMap;.containsKey(LjavalangObject;)Z:319(11)LjavautilHashMap;.addEntry(LjavalangObject;LjavalangObject;IZ)V:650(29)",
				"LjavautilTreeMap;.rotateLeft(LjavautilTreeMap$Node;)V:1345(89)LjavautilTreeMap;.firstNode()LjavautilTreeMap$Node;:958(14)",
				"LjavautilTreeSet;.<init>(LjavautilComparator;)V:120(13)LjavautilTreeSet;.iterator()LjavautilIterator;:327(1)",
				"LgnujavautilregexRETokenChar;.matchThis(LgnujavautilregexCharIndexed;LgnujavautilregexREMatch;)LgnujavautilregexREMatch;:62(18)LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:74(2)",
				"LorgjaxensaxpathhelpersXPathReaderFactory;.createReader(LjavalangString;)LorgjaxensaxpathXPathReader;:144(46)LorgjaxensaxpathhelpersXPathReaderFactory;.createReader(LjavalangString;)LorgjaxensaxpathXPathReader;:144(46)",
				"LjavautilTreeMap;.rotateLeft(LjavautilTreeMap$Node;)V:1333(36)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1404(46)",
				"LnetsourceforgepmdjaxenAttributeAxisIterator$MethodWrapper;.<init>(LjavalangreflectMethod;)V:22(6)LnetsourceforgepmdjaxenAttributeAxisIterator;.getNextAttribute()LnetsourceforgepmdjaxenAttribute;:84(44)",
				"LjavautilHashMap;.addEntry(LjavalangObject;LjavalangObject;IZ)V:650(29)LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:345(11)",
				"LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:74(2)LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:74(2)",
				"LgnujavautilregexREToken;.<init>(I)V:43(6)LgnujavautilregexREToken;.getNext()LgnujavautilregexREToken;:123(1)",
				"LjavautilTreeMap$Node;.<init>(LjavalangObject;LjavalangObject;I)V:187(17)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1391(1)",
				"LjavalangClass;.getDefaultConstructor()LorgjikesrvmclassloaderRVMMethod;:694(1)LjavalangClass;.getDefaultConstructor()LorgjikesrvmclassloaderRVMMethod;:703(65)",
				"LjavautilTreeMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:537(95)LjavautilTreeMap$TreeIterator;.<init>(LjavautilTreeMap;ILjavautilTreeMap$Node;LjavautilTreeMap$Node;)V:1445(11)",
				"LjavautilTreeMap;.rotateRight(LjavautilTreeMap$Node;)V:1378(89)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1401(52)",
				"LjavautilTreeMap$Node;.<init>(LjavalangObject;LjavalangObject;I)V:187(17)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1401(52)",
				"LjavautilTreeMap;.fabricateTree(I)V:876(8)LjavautilTreeMap;.firstNode()LjavautilTreeMap$Node;:957(1)",
				"LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:82(54)LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:82(54)",
				"LjavautilTreeMap;.rotateRight(LjavautilTreeMap$Node;)V:1372(76)LjavautilTreeMap;.firstNode()LjavautilTreeMap$Node;:958(14)",
				"LjavautilTreeMap$Node;.<init>(LjavalangObject;LjavalangObject;I)V:185(10)LjavautilTreeMap;.firstNode()LjavautilTreeMap$Node;:958(14)",
				"LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:74(2)LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:82(54)",
				"LgnujavautilregexRETokenChar;.matchThis(LgnujavautilregexCharIndexed;LgnujavautilregexREMatch;)LgnujavautilregexREMatch;:67(33)LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:74(2)",
				"LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:362(80)LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:362(80)",
				"LjavautilTreeMap;.rotateRight(LjavautilTreeMap$Node;)V:1363(28)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1399(36)",
				"LgnujavautilregexRETokenChar;.matchThis(LgnujavautilregexCharIndexed;LgnujavautilregexREMatch;)LgnujavautilregexREMatch;:62(18)LgnujavautilregexRETokenChar;.matchOneString(LgnujavautilregexCharIndexed;I)Z:82(54)",
				"LgnujavautilregexREToken;.setUncle(LgnujavautilregexREToken;)V:70(2)LgnujavautilregexREToken;.setUncle(LgnujavautilregexREToken;)V:70(2)",
				"LjavautilTreeMap;.rotateLeft(LjavautilTreeMap$Node;)V:1346(94)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1404(46)",
				"LjavautilAbstractMap$SimpleEntry;.<init>(LjavalangObject;LjavalangObject;)V:699(6)LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:349(20)",
				"LorgjaxensaxpathhelpersXPathReaderFactory;.createReader(LjavalangString;)LorgjaxensaxpathXPathReader;:137(18)LorgjaxensaxpathhelpersXPathReaderFactory;.createReader(LjavalangString;)LorgjaxensaxpathXPathReader;:137(18)",
				"LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:361(69)LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:361(64)",
				"LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:362(80)LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:362(74)",
				"LjavautilAbstractMap$SimpleEntry;.<init>(LjavalangObject;LjavalangObject;)V:700(11)LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:352(36)",
				"LjavautilHashMap;.get(LjavalangObject;)LjavalangObject;:302(28)LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:353(44)",
				"LnetsourceforgepmdRuleViolation;.<init>(LnetsourceforgepmdRule;LnetsourceforgepmdRuleContext;LnetsourceforgepmdastSimpleNode;LjavalangString;)V:104(310)LnetsourceforgepmdRuleViolation;.getBeginLine()I:199(1)",
				"LjavautilAbstractMap$SimpleEntry;.<init>(LjavalangObject;LjavalangObject;)V:699(6)LjavautilTreeMap$TreeIterator;.next()LjavalangObject;:1507(91)",
				"LjavautilTreeMap;.rotateRight(LjavautilTreeMap$Node;)V:1370(65)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1401(52)",
				"LjavautilTreeMap$Node;.<init>(LjavalangObject;LjavalangObject;I)V:185(10)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1394(24)",
				"LgnujavautilregexRETokenEnd;.<init>(ILjavalangString;)V:52(7)LgnujavautilregexRETokenEnd;.match(LgnujavautilregexCharIndexed;LgnujavautilregexREMatch;)Z:75(1)",
				"LjavautilTreeMap;.rotateLeft(LjavautilTreeMap$Node;)V:1339(76)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1401(52)",
				"LjavalangreflectMethod;.<init>(LjavalangreflectVMMethod;)V:98(6)LjavalangreflectMethod;.invoke(LjavalangObject;[LjavalangObject;)LjavalangObject;:330(1)",
				"LjavautilTreeMap;.rotateLeft(LjavautilTreeMap$Node;)V:1342(84)LjavautilTreeMap;.firstNode()LjavautilTreeMap$Node;:957(1)",
				"LjavautilTreeMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:546(133)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1391(1)",
				"LjavautilTreeMap;.rotateLeft(LjavautilTreeMap$Node;)V:1330(28)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1399(36)",
				"LnetsourceforgepmdRuleViolation;.<init>(LnetsourceforgepmdRule;LnetsourceforgepmdRuleContext;LnetsourceforgepmdastSimpleNode;LjavalangString;)V:73(20)LnetsourceforgepmdRuleViolation;.getDescription()LjavalangString;:179(1)",
				"LjavautilAbstractMap$SimpleEntry;.<init>(LjavalangObject;LjavalangObject;)V:699(6)LjavautilHashMap;.containsKey(LjavalangObject;)Z:322(18)",
				"LorgjaxensaxpathhelpersXPathReaderFactory;.createReader(LjavalangString;)LorgjaxensaxpathXPathReader;:144(34)LorgjaxensaxpathhelpersXPathReaderFactory;.createReader(LjavalangString;)LorgjaxensaxpathXPathReader;:144(46)",
				"LorgjaxensaxpathhelpersXPathReaderFactory;.createReader(LjavalangString;)LorgjaxensaxpathXPathReader;:137(6)LorgjaxensaxpathhelpersXPathReaderFactory;.createReader(LjavalangString;)LorgjaxensaxpathXPathReader;:137(18)",
				"LjavautilTreeMap;.rotateRight(LjavautilTreeMap$Node;)V:1372(76)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1394(24)",
				"LjavautilHashMap;.addEntry(LjavalangObject;LjavalangObject;IZ)V:650(29)LjavautilHashMap;.addEntry(LjavalangObject;LjavalangObject;IZ)V:649(18)",
				"LjavautilTreeMap;.rotateLeft(LjavautilTreeMap$Node;)V:1328(10)LjavautilTreeMap;.successor(LjavautilTreeMap$Node;)LjavautilTreeMap$Node;:1391(1)",
				"LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:353(44)LjavautilHashMap;.put(LjavalangObject;LjavalangObject;)LjavalangObject;:353(44)",
				"LjavautilHashMap;.rehash()V:751(86)LjavautilHashMap;.containsKey(LjavalangObject;)Z:324(30)"};
		for (int i = 0; i < ss.length; i++) {
			splitting(ss[i]);
		}
		s = "LjavautilHashMap;.rehash()V:751(86)LjavautilHashMap;.containsKey(LjavalangObject;)Z:324(30)";
		splitting(s);
	}
	
	public static void splitting(String s) {
		System.out.println(s);
		String [] fields = s.split("[;(]");
		String f1 = ""; String f2 = "";
		for(int i = 0; i < fields.length; i++) {
			if(fields[i].charAt(0) == '.' && f1.equals("")) {
				if(fields[i].equals(".<init>")) {
					f1 = ".init";
				} else {
					f1 = fields[i];
				}
			} else if(fields[i].charAt(0) == '.' && f2.equals("")) {
				if(fields[i].equals(".<init>")) {
					f2 = ".init";
				} else {
					f2 = fields[i];
				}
			}
		}
		String [] positions = s.split("[:)]");
		String race1 = f1+":"+positions[2]+")"+f2+":"+positions[positions.length-1]+")";
		String race2 = f2+":"+positions[positions.length-1]+")"+f1+":"+positions[2]+")";
		System.out.println(race1);
		System.out.println(race2+"\n");
	}
	
	//checking that split still returns the full string even if the regex is not seen
	public static void specialCharSplit(String s) {
		String [] ss = s.split("/");
		System.out.println(ss[0]);
		String s2 = "hello \nworld";
		s2 = s2.replace(" ", "");
		System.out.println(s2);
		String [] ss2 = s2.split("\\n");
		s2 = ss2[0] + ss2[1];
		System.out.println(s2);
		System.out.println(ss2[0]);
		System.out.println(ss2[1]);
		System.out.println(ss2[0] + ss2[1]);
	}
}
