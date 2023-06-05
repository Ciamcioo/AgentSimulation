package Core;
import AgentClasses.Agent;
import Map.Map;

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
        // TODO dopisać jakaś funckje która ustawa po przejściu całego koła przez procesu zmiany pozycji przez kolejnych agentów na false czy coś takiego

        mapOfSimulation.printMap();

    }
}
