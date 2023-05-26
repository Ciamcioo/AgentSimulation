package Core;
import Map.Map;

public class Simulation {
    public static void main(String[] args) {
        int size = 20, numberOfSickAgents = 2, numberOfHealthyAgents =  20;
        Map mapOfSimulation = new Map(size, numberOfHealthyAgents, numberOfSickAgents);
        mapOfSimulation.printMap();

    }
}
