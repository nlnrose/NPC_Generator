package NPC_Generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Accent {
	MOLE("Mole"), RAF("RAF British"), SCOTTISH("Scottish"), 
	IRISH("Irish: No upper lip"), SOUTHERN("Southern: No upper lip"), 
	TEXAN("Texan"),	PULP("Pulp radio announcer"), RASPY("Raspy"), 
	ACTION("Action Hero eg Bruce Willis"), ARNOLD("Arnold Schwartzenager"),
	MCREE("Mcree"), INIGO("Inigo Montoya"), RUSSIAN("Russian"), 
	ITALIAN("Italian"), HANZO("Hanzo"), MEI("Mei"), TRACER("Tracer"),
	TONY_TIGER("Tony the Tiger"), Zarya("Zarya"), ZENYATTA("Zenyatta"), 
	WIL_WHEATON("Soft Wil Wheaton"), BREATHE_IN("Breathe in"),
	AUSTRALIAN("Australian"), ORIENTAL("Oriental"), SOLDIER("Soldeir 76");

private static final List<Accent> VALUES 
    = Collections.unmodifiableList(Arrays.asList(values()));
private static final int SIZE = VALUES.size();
private static final Random RANDOM = new Random();
private String printout;

Accent(String s){
	printout = s;
}
@Override
public String toString() {
	return printout;
}

    public static Accent randomAccent()  {
	    return VALUES.get(RANDOM.nextInt(SIZE));
	}
    

	
}
