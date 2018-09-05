package NPC_Generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Random;
import java.util.Scanner;

public class NPC {

	private boolean isMale;
	private String name;
	private String voicePitch = "";
	private String accent = "";
	private String personality = "";
	private Level level;
	private static Random generator = new Random();
	public NPC() throws FileNotFoundException {
		this(generator.nextBoolean());
	}
	
	public NPC(boolean male) throws FileNotFoundException {
		isMale = male;
		name = getRandomName();
		voicePitch += VoicePitch.randomVoicePitch();
		accent += Accent.randomAccent();
		personality += Personality.randomPersonality();
		level = Level.specificLevel(generator.nextInt(5));
		}
	
	@Override 
	public String toString(){
		String npc = "Gender: ";
		if(isMale) {
			npc += "Male";
		}
		else {
			npc += "Female";
		}
		npc += "\nName: " + name+
		"\nVoice Pitch: " + voicePitch+
		"\nPersonality: " + personality+
		"\nAccent: " + accent+
		"\n" + level.toString()+
		"\nHP:" + level.getRandomHP()+
		"\nGuard: " + level.getRandomDef()+
		"\nToughness: " + level.getRandomDef()+
		"\nResolve: " + level.getRandomDef()
		;
		
		return npc;
	}
	//TODO Change below back to private when done with testing.
	public String getRandomName() throws FileNotFoundException {
		String randName = "";
		File nameFile;
		if(isMale) {
		    nameFile = new File("src/NPC_Generator/MaleNames");
		}
		else {
			nameFile = new File("src/NPC_Generator/FemaleNames");
		}
		Scanner nameReader = new Scanner(nameFile);
		int numOfLines = nameReader.nextInt();
		nameReader.nextLine();
		for(int i = generator.nextInt(numOfLines); i > 0; i--) {
			nameReader.nextLine();
		}
		randName = nameReader.nextLine();
		nameReader.close();
		try {
			removeName(randName, nameFile, numOfLines-1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return randName;
	}
	
	public void removeName(String lineContent, File file, int size) throws Exception
	{
		File temp = new File("src/NPC_Generator/_temp_");
	    PrintWriter out = new PrintWriter(new FileWriter(temp));
	    out.println(Integer.toString(size));
	    Files.lines(file.toPath())
	        .filter(line -> !line.contains(lineContent) && !line.matches("^\\d+(\\.\\d+)?"))
	        .forEach(out::println);
	    out.flush();
	    out.close();
//	    System.out.println("Delete: " + file.delete());
//	    System.out.println("Rewrite: " + Files.move(Paths.get(temp.getPath()), Paths.get(file.getPath()), StandardCopyOption.ATOMIC_MOVE));
	    
	}
}
