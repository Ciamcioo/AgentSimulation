package Core;
import Map.Map;

public class Simulation {
    public static void main(String[] args) {
        int size = 20, numberOfSickAgents = 2, numberOfHealthyAgents =  20;
        Map mapOfSimulation = new Map(size, numberOfHealthyAgents, numberOfSickAgents);
        mapOfSimulation.printMap();
        for (int i = 1; i <= mapOfSimulation.getSize(); i++) {
            for (int j = 1; j <= mapOfSimulation.getSize(); j++) {
                if(!(mapOfSimulation.checkPosition(i,j))) {
                    ObjectOfMap object = mapOfSimulation.getAgent(i, j);
                }
            }
        }
    }
}
