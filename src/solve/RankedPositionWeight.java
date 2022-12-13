package solve;

import processingsteps.ProcessingRelation;

public class RankedPositionWeight extends Method {

	// constructor
	public RankedPositionWeight() {
		super();
	}
	
	// call of class to do work
	@Override
	public int doMethod(ProcessingRelation[] processingRelations, String currentProcess) {
		 //System.out.println(currentProcess + " RPW = " + calcRPW(processingRelations, currentProcess));
		 return calcRPW(processingRelations, currentProcess);
	}
	
	// calculate RPW of positions
	public int calcRPW(ProcessingRelation[] processingRelations, String currentProcessName) {
		
		// initialize variables
		ProcessingRelation currentStep = lookUp(processingRelations, currentProcessName);
		int sumT = currentStep.getRefProcessingStep().getTime();
		
		// search for all successors
		if(currentStep.getSuccessors() != null) {
			for(int i = 0; i < currentStep.getSuccessors().length; i++) {
				sumT += currentStep.getSuccessors()[i].getTime();
				sumT += calcRPW(processingRelations, currentStep.getSuccessors()[i].getName()) - currentStep.getSuccessors()[i].getTime();	
			}
		}
		return sumT;
	}
	
	// this method looks up the processing relation array to find the right one
	public ProcessingRelation lookUp(ProcessingRelation[] processingRelations, String lookUpName) {
		for(ProcessingRelation process : processingRelations) {
			if(process.getRefProcessingStep().getName() == lookUpName) {
				return process;
			}
		}
		return null;
	}
}
