package processingsteps;

public class ProcessingStep {
	
	// initialize fields
	private String name;
	private int time;
	
	// constructor
	public ProcessingStep(String name, int time) {
		super();
		this.name = name;
		this.time = time;
	}

	// getters
	public String getName() {
		return name;
	}

	public int getTime() {
		return time;
	}
}
