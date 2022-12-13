package processingsteps;

public class ProcessingRelation {
	
	// initialize fields
	private ProcessingStep[] precessors;
	private ProcessingStep[] successors;
	private ProcessingStep refProcessingStep;

	// constructor
	public ProcessingRelation(ProcessingStep[] precessors, ProcessingStep[] successors, ProcessingStep refProcessingStep) {
		this.precessors = precessors;
		this.successors = successors;
		this.refProcessingStep = refProcessingStep;
	}

	// getters
	public ProcessingStep[] getPrecessors() {
		return precessors;
	}

	public ProcessingStep[] getSuccessors() {
		return successors;
	}

	public ProcessingStep getRefProcessingStep() {
		return refProcessingStep;
	}
	
	// print function
	public void printRelations() {
		if(precessors != null) {
			for(ProcessingStep pre : precessors) {
				System.out.print(pre.getName() + ", ");
			}
			System.out.print(" -> ");
		}
		System.out.print(refProcessingStep.getName());
		
		if(successors != null) {
			System.out.print(" -> ");
			for(ProcessingStep suc : successors) {
				System.out.print(suc.getName() + ", ");
			}
		}
		
		System.out.println();
	}
}
