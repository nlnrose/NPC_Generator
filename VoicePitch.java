package NPC_Generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum VoicePitch {
    High("High"), Normal("Normal"), Low("Low");
	  private static final List<VoicePitch> VALUES 
      = Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final Random RANDOM = new Random();
  private String printout;

  VoicePitch(String s){
  	printout = s;
  }
  @Override
  public String toString() {
  	return printout;
  }
  
		  public static VoicePitch randomVoicePitch()  {
		    return VALUES.get(RANDOM.nextInt(SIZE));
		  }
}
