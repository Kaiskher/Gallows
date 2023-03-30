
public class Gibbet {

	int faults = 0;
	char trueParts[] = {'o','O','-','-','/','\\'}; 
	char parts[] = {0,0,0,0,0,0};

	public Gibbet() {
		print();
	}
	
	public void addPart(int faults) {
		if ((faults < 0) || (faults > 5)) return;
		parts[faults] = trueParts[faults];
		print();
	}
	
	public void print() {
		System.out.println("   _____");
		System.out.println("   |" + "   |");		
		System.out.println("   " + parts[0] + "   |");
		System.out.println("  " + parts[2] + parts[1] + parts[3] + "  |");		
		System.out.println("  " + parts[4] + " " + parts[5] + "  |");
		System.out.println("  _____|__");			
	}
}
