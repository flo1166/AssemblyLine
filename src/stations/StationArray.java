package stations;

public class StationArray {
	
	// the capacitated array of bins
	private Station[] stations;
	
	// the maximum of items per bin
	private int stationSize;

	// constructs a new bin array with given maximum number of bin
	// and maximum number of items within a bin
	public StationArray(int maxBins, int stationSize) {
		stations = new Station[maxBins];
		this.stationSize = stationSize;
	}
	
	// return the length of the bins array
	public int getMaxBinNumber() {
		return stations.length;
	}
	
	// get bin at position i
	public Station getBin(int i) {
		if(stations[i] == null) {
			stations[i] = new Station(stationSize);
		}
		return stations[i];
	}
	
	// prints the bins and their contents on the console
	public void print() {
		for(int i = 0; i < stations.length; i++) {
			if(stations[i] != null) {
				System.out.println("Station " + (i + 1) + ":" + stations[i].toString());
			}
		}
	}
}
