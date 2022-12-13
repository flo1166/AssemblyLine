package stations;

import processingsteps.ProcessingRelation;

public class Station {
		
	// the bins maximum capacity
	public static double capacity = 12;
	
	
	// the processing steps in the station
	public ProcessingRelation[] processingRelations;
	
	// construct an empty bin
	public Station(int maxItems) {
		processingRelations = new ProcessingRelation[maxItems];
	}
	
	// calculate the remaining capacity of the bin
	public double remainingCapacity() {
		double capacity = Station.capacity;
		
		for(ProcessingRelation step : processingRelations) {
			if(step != null) {
				capacity -= step.getRefProcessingStep().getTime();
			}
		}
		
		return capacity;
	}
	
	// try to pack item into the bin
	// return true if the item was packed, false otherwise
	public boolean pack(ProcessingRelation processingRelations) {
		if(processingRelations.getRefProcessingStep().getTime() > this.remainingCapacity()) {
			// return false immediately
			return false;
		}
		
		// pack the item by searching an empty space in the array
		for(int i = 0; i < this.processingRelations.length; i++) {
			if(this.processingRelations[i] == null) {
				this.processingRelations[i] = processingRelations;
				return true;
			}
		}
		
		// could not find empty slot
		return false;
	}
	
	// string representation of packed items
	public String toString() {
		String output = "";
		for(ProcessingRelation item : processingRelations) {
			if(item != null) {
				output += " " + item.getRefProcessingStep().getName();
			}
		}
		
		return output;
	}
}
