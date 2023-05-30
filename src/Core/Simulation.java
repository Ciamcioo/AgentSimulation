package Core;
import AgendClasses.Agent;
import AgendClasses.AgentBeforeIllness;
import AgendClasses.SickAgent;
import Map.Map;

public class Simulation {
    public static void main(String[] args) {
        int size = 20, numberOfSickAgents = 2, numberOfHealthyAgents =  20;
        Map mapOfSimulation = new Map(size, numberOfHealthyAgents, numberOfSickAgents);
        mapOfSimulation.printMap();
        for (int i = 0; i < mapOfSimulation.getSize(); i++) {
            for (int j = 0; j < mapOfSimulation.getSize(); j++) {
                if(mapOfSimulation.checkField(i, j, AgentBeforeIllness.class)){
                    Agent agent = (Agent) mapOfSimulation.getOneObjectOfMap(i, j);
                    agent.move();
                }
            }
        }
        mapOfSimulation.printMap();
    }
}
