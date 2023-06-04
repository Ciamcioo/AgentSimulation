package Core;
import AgendClasses.Agent;
import AgendClasses.AgentBeforeIllness;
import AgendClasses.SickAgent;
import Map.Map;
import Map.EmptyField;

public class Simulation {
    public static void main(String[] args) {
        int size = 20, numberOfSickAgents = 2, numberOfHealthyAgents = 20;
        Map mapOfSimulation = new Map(size, numberOfHealthyAgents, numberOfSickAgents);
        mapOfSimulation.printMap();
        System.out.println();

        for(int i = 0; i < mapOfSimulation.getSize(); i++) {
            for(int j = 0; j < mapOfSimulation.getSize(); j++) {
                if(mapOfSimulation.getOneObjectOfMap(j,i) instanceof Agent && !(((Agent) mapOfSimulation.getOneObjectOfMap(j,i)).getIterationMove()))
                    ((Agent) mapOfSimulation.getOneObjectOfMap(j,i)).move();
            }
        }

        mapOfSimulation.printMap();

    }
}
