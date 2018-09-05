package NPC_Generator;

import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

public enum Personality {
	Sleepy("Sleepy"), Sneezy("Sneezy"), Happy("Happy"),
	Philosophical("Doc"), Bashful("Bashful"), Grumpy("Grumpy"),
	Dopey("Dopey");
	
	  private static final List<Personality> VALUES 
	      = Collections.unmodifiableList(Arrays.asList(values()));
	  private static final int SIZE = VALUES.size();
      private static final Random RANDOM = new Random();
      private String printout;

      Personality(String s){
      	printout = s;
      }
      @Override
      public String toString() {
      	return printout;
      }
			  public static Personality randomPersonality()  {
			    return VALUES.get(RANDOM.nextInt(SIZE));
			  }
}
