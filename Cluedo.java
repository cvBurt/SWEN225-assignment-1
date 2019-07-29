import java.util.*;

public class Cluedo {
	List<Player> players = new ArrayList<Player>();
	
	public Cluedo (){
		System.out.print("Hello, welcome to cluedo\n"
				+ "if at any time you need clarifiction on the\n"
				+ "rules type '/help' for a list rules\n");
	}
	
	public enum characters {
		MISSSCARLET, COLONELMUSTSARD, MRSWHITE, MRGREEN, MISSPEACOCK, PROFESSORPLUM;
	}
	
	public static void main(String[] args) {
		new Cluedo();
	}
}
