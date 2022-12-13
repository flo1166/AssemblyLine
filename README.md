## AssemblyLine

# General
This project sorts via selection sort processing steps of a product which take a certain time and opens new stations if the capacity is exceeded from the previous station.

# Structure
+ processingsteps - this package includes the processing steps object
+ ProcessingRelation - this class inhabits the relation (pre- and successor of a processing step and the object processing step itself)
+ ProcessingStep - the object processing step with processing time and name
+ solve - the package includes all methods and solver to solve the problem
+ Method - a abstract class to have the option to implement other methods
+ RankedPositionWeight - a implemented method to solve the problem
+ Solver - the solver to solve the problem with the selection sort and next fit logic derived from code snippets from the lecturer
+ stations - the package includes the station objects
+ Station (code snippets / logic in parts from Andreas Popp [lecturer]) - to build the station objects with limitations
+ StationArray (code snippets / logic in parts from Andreas Popp [lecturer]) - to pack and open new stations
