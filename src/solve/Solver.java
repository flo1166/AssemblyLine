package solve;

import processingsteps.ProcessingRelation;
import processingsteps.ProcessingStep;
import stations.StationArray;

public class Solver {

	public static void main(String[] args) {

		// input data
		// processing steps
		ProcessingStep[] processingSteps = new ProcessingStep[6];
		processingSteps[0] = new ProcessingStep("A", 6);
		processingSteps[1] = new ProcessingStep("B", 2);
		processingSteps[2] = new ProcessingStep("C", 4);
		processingSteps[3] = new ProcessingStep("D", 6);
		processingSteps[4] = new ProcessingStep("E", 7);
		processingSteps[5] = new ProcessingStep("F", 3);

		// arrays with precessors
		ProcessingStep[] preB = new ProcessingStep[1];
		preB[0] = processingSteps[0];
		ProcessingStep[] preC = new ProcessingStep[1];
		preC[0] = processingSteps[0];
		ProcessingStep[] preD = new ProcessingStep[1];
		preD[0] = processingSteps[1];
		ProcessingStep[] preE = new ProcessingStep[2];
		preE[0] = processingSteps[1];
		preE[1] = processingSteps[2];
		ProcessingStep[] preF = new ProcessingStep[2];
		preF[0] = processingSteps[3];
		preF[1] = processingSteps[4];

		// arrays with successors
		ProcessingStep[] sucA = new ProcessingStep[2];
		sucA[0] = processingSteps[1];
		sucA[1] = processingSteps[2];
		ProcessingStep[] sucB = new ProcessingStep[2];
		sucB[0] = processingSteps[3];
		sucB[1] = processingSteps[4];
		ProcessingStep[] sucC = new ProcessingStep[1];
		sucC[0] = processingSteps[4];
		ProcessingStep[] sucD = new ProcessingStep[1];
		sucD[0] = processingSteps[5];
		ProcessingStep[] sucE = new ProcessingStep[1];
		sucE[0] = processingSteps[5];

		// relations
		ProcessingRelation[] processingRelations = new ProcessingRelation[6];
		processingRelations[0] = new ProcessingRelation(null, sucA, processingSteps[0]);
		processingRelations[1] = new ProcessingRelation(preB, sucB, processingSteps[1]);
		processingRelations[2] = new ProcessingRelation(preC, sucC, processingSteps[2]);
		processingRelations[3] = new ProcessingRelation(preD, sucD, processingSteps[3]);
		processingRelations[4] = new ProcessingRelation(preE, sucE, processingSteps[4]);
		processingRelations[5] = new ProcessingRelation(preF, null, processingSteps[5]);

		// sorting
		selectionSort(processingRelations, false);

		// next fit
		nextFit(processingRelations).print();

//		for (ProcessingStep process : processingSteps) {
//			System.out.println(process.getName());
//		}
//		for (ProcessingRelation process : processingRelations) {
//			System.out.println(process.getRefProcessingStep().getName());
//		}
	}

	// the first fit heuristic
	public static StationArray nextFit(ProcessingRelation[] processingRelations) {
		// create bin array with the worst case array lengths
		StationArray bins = new StationArray(processingRelations.length, processingRelations.length);

		// which bin is currently
		int i = 0;

		// pack the items in given order
		for (ProcessingRelation item : processingRelations) {
			if (!bins.getBin(i).pack(item)) {
				i++;
				bins.getBin(i).pack(item);
			}
		}

		// all items are packed
		return bins;
	}

	// this sorts via selection sort
	public static void selectionSort(ProcessingRelation[] processingRelations, boolean ascending) {

		for (int i = 0; i < processingRelations.length; i++) {

			// find min / max
			int minMax = i;

			for (int j = i + 1; j < processingRelations.length; j++) {
				int calcRPW = new RankedPositionWeight().doMethod(processingRelations,
						processingRelations[j].getRefProcessingStep().getName());
				int minMaxRPW = new RankedPositionWeight().doMethod(processingRelations,
						processingRelations[minMax].getRefProcessingStep().getName());

				if (ascending && calcRPW < minMaxRPW) {
					minMax = j;
				} else if (!ascending && calcRPW > minMaxRPW) {
					minMax = j;
				}
			}

			// swap min/max element into place
			swap(processingRelations, minMax, i);
		}
	}

	private static void swap(ProcessingRelation[] arr, int n, int m) {
		ProcessingRelation swap = arr[n];
		arr[n] = arr[m];
		arr[m] = swap;
	}
}
