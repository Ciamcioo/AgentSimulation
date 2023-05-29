package Core;
import AgendClasses.*;
import Map.Map;

public class Simulation {

    public void runSimulation() {
        // TODO
    }
    
    public static void doObjectInteractions(Map map) {
        ObjectOfMap[][] mapArray = map.getMapArray();
        int size = map.getSize();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (mapArray[x][y] != null && mapArray[x][y] instanceof AgentBeforeIllness) {
                    if(((Agent) mapArray[x][y]).checkIfNeighbor(map, mapArray[x][y], SickAgent.class)) {
                        mapArray[x][y] = new SickAgent(x, y, map, 7, 0.4);
                        // TODO użyć chengingStatusOfAgent
                    }

                    // TODO inne interakcje
                }
            }
        }
    }

    public static void main(String[] args) {
        int size = 20, numberOfSickAgents = 2, numberOfHealthyAgents =  20;
        Map mapOfSimulation = new Map(size, numberOfHealthyAgents, numberOfSickAgents);
        mapOfSimulation.printMap();
        doObjectInteractions(mapOfSimulation);
        mapOfSimulation.printMap();
    }
}
