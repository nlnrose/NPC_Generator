package NPC_Generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Level {
Level_1(10, 22, 10, 16, 4, 3, 1),Level_2(12, 24, 10, 17, 5, 3, 2),
Level_3(14, 26, 12, 18, 5, 4, 3),Level_4(16, 28, 11, 19, 6, 4, 4),
Level_5(18, 30, 14, 20, 6, 5, 5),Level_6(20, 32, 15, 21, 7, 5, 6),
Level_7(22, 34, 16, 22, 7, 6, 7),Level_8(24, 36, 17, 23, 8, 6, 8),
Level_9(26, 38, 18, 24, 8, 7, 9),Level_10(28, 40, 19, 25, 9, 7, 10),
Level_11(30, 42, 19, 25, 9, 8, 11),Level_12(32, 44, 20, 26, 10, 8, 12),
Level_13(34, 46, 20, 26, 10, 9, 13),Level_14(36, 48, 21, 27, 10, 9, 14),
Level_15(38, 50, 21, 27, 10, 9, 15),Level_16(40, 52, 22, 28, 10, 9, 16),
Level_17(42, 54, 22, 28, 10, 9, 17),Level_18(44, 56, 23, 29, 10, 9, 18),
Level_19(46, 58, 23, 29, 10, 9, 19),Level_20(48, 60, 24, 30, 10, 9, 20);
	
	Level(int minHP, int maxHP, int minDEF, int maxDEF, int prim, int sec, int lev){
		hitPoints[0] = minHP;
		hitPoints[1] = maxHP;
		defenses[0] = minDEF;
		defenses[1] = maxDEF;
		primaryAttributes = prim;
		secondaryAttributes = sec;
		level = lev;
	}
	
	private static final List<Level> VALUES 
    = Collections.unmodifiableList(Arrays.asList(values()));
private static final int SIZE = VALUES.size();
private static final Random RANDOM = new Random();
private int[] hitPoints = {0,0};
private int[] defenses = {0,0};
private int primaryAttributes;
private int secondaryAttributes;
private int level;
private Random random = new Random();

public int[] getHP() {
	return hitPoints;
}
public int[] getDef() {
	return defenses;
}

public int getRandomHP() {
	return random.nextInt(hitPoints[1]-hitPoints[0]) + hitPoints[0];
}
public int getRandomDef() {
	return random.nextInt(defenses[1]-defenses[0]) + defenses[0];
}

public int getPrimaryAttributes() {
	return primaryAttributes;
}

public int getSecondaryAttributes() {
	return secondaryAttributes;
}

@Override
public String toString() {
	return "Level: " + level;
}
		  public static Level randomLevel()  {
		    return VALUES.get(RANDOM.nextInt(SIZE));
		  }
		  public static Level specificLevel(int i) {
			  return values()[i-1];
		  }

}
