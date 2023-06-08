package Core;
import Map.Map;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Simulation implements SimulationMethods {
    protected static Integer size = 0, numberOfIterations = 0, numberOfHealthyAgents = 0,numberOfSickAgents = 0, numberOfVaccineKits = 0, numberOfIsolation = 0;

    public static void main(String[] args) throws InterruptedException  {
        SimulationMethods.enteringDateForSimulation();

        Map mapOfSimulation = new Map(size, numberOfHealthyAgents, numberOfSickAgents);
        mapOfSimulation.printMap();
        System.out.println();
//        ArrayList<pairOfInt> vaccine = new ArrayList<>();
        while(numberOfIterations > 0){
            mapOfSimulation.packageSpawn();
            SimulationMethods.agentControlMethod(mapOfSimulation);
            mapOfSimulation.printMap();
            mapOfSimulation.packageDestruction();
            mapOfSimulation.settingValueOfMoveIterationToFalse();
            numberOfIterations--;
        }

//        while (true) {
//            for (int i = 0; i < mapOfSimulation.getSize(); i++) {
//                for (int j = 0; j < mapOfSimulation.getSize(); j++) {
//                    if (mapOfSimulation.getOneObjectOfMap(j, i) instanceof Agent && !(((Agent) mapOfSimulation.getOneObjectOfMap(j, i)).getIterationMove()))
//                        ((Agent) mapOfSimulation.getOneObjectOfMap(j, i)).move();
//                }
//            }
//
//            for (int i = 0; i < mapOfSimulation.getSize(); i++) {
//                for (int j = 0; j < mapOfSimulation.getSize(); j++) {
//                    if (mapOfSimulation.getOneObjectOfMap(j, i) instanceof Agent)
//                        ((Agent) mapOfSimulation.getOneObjectOfMap(j, i)).setIterationMove(false);
//                }
//
//                for (int i = 0; i < mapOfSimulation.getSize(); i++) {
//                    for (int j = 0; j < mapOfSimulation.getSize(); j++) {
//                        if (mapOfSimulation.getOneObjectOfMap(j, i) instanceof AgentBeforeIllness && !((AgentBeforeIllness) mapOfSimulation.getOneObjectOfMap(j, i)).getVaccinated() && mapOfSimulation.getOneObjectOfMap(j, i).checkIfNeighbor(mapOfSimulation, SickAgent.class) instanceof SickAgent) {
//                            ((AgentBeforeIllness) mapOfSimulation.getOneObjectOfMap(j, i)).changingStatusOfAgent();
//                        }
//
//                    }
//
//                    vaccine.add(new pairOfInt(abs(new Random().nextInt() % (size - 1)), abs(new Random().nextInt() % (size - 1))));
//
//                    for (pairOfInt i : vaccine) {
//                        if (mapOfSimulation.getOneObjectOfMap(i.getX(), i.getY()) instanceof AgentBeforeIllness) {
//                            ((AgentBeforeIllness) mapOfSimulation.getOneObjectOfMap(i.getX(), i.getY())).setVaccinated(true);
//
//                        }
//
//                        //TODO gdy ktoś stanie na szczepionce, to szczepionka znika.
//                        //TODO wyświetlanie szczepionki
//
//
//                        mapOfSimulation.printMap();
//
//                        Thread.sleep(1000); //żeby leciało w pętli i można było oglądać skoki
//                        //TODO warunek kończący wyświetlanie mapy?
//                    }
//                }
//            }
//        }
    }

}
