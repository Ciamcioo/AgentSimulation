package Core;
import AgentClasses.Agent;
import AgentClasses.AgentBeforeIllness;
import AgentClasses.SickAgent;
import Map.Map;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

public class Simulation {
    public static void main(String[] args) throws InterruptedException {
        int size = 20, numberOfSickAgents = 2, numberOfHealthyAgents = 20;
        Map mapOfSimulation = new Map(size, numberOfHealthyAgents, numberOfSickAgents);
        mapOfSimulation.printMap();
        System.out.println();
        ArrayList<pairOfInt> vaccine = new ArrayList<>();

        while(true) {
            for (int i = 0; i < mapOfSimulation.getSize(); i++) {
                for (int j = 0; j < mapOfSimulation.getSize(); j++) {
                    if (mapOfSimulation.getOneObjectOfMap(j, i) instanceof Agent && !(((Agent) mapOfSimulation.getOneObjectOfMap(j, i)).getIterationMove()))
                        ((Agent) mapOfSimulation.getOneObjectOfMap(j, i)).move();
                }
            }

            for (int i = 0; i < mapOfSimulation.getSize(); i++) {
                for (int j = 0; j < mapOfSimulation.getSize(); j++) {
                    if (mapOfSimulation.getOneObjectOfMap(j, i) instanceof Agent )
                        ((Agent) mapOfSimulation.getOneObjectOfMap(j, i)).setIterationMove(false);
                }
            }//W tej pętli nakurwiamy kółeczka i zmieniamy stan kolejnych agentów na mapie, że się nie ruszyli

            for (int i = 0; i < mapOfSimulation.getSize(); i++) {
                for (int j = 0; j < mapOfSimulation.getSize(); j++) {
                    if (mapOfSimulation.getOneObjectOfMap(j, i) instanceof AgentBeforeIllness && !((AgentBeforeIllness) mapOfSimulation.getOneObjectOfMap(j, i)).getVaccinated() && mapOfSimulation.getOneObjectOfMap(j, i).checkIfNeighbor(mapOfSimulation, SickAgent.class) instanceof SickAgent) {
                        ((AgentBeforeIllness) mapOfSimulation.getOneObjectOfMap(j, i)).changingStatusOfAgent();
                    }

                }
            } // dobra. kolejna pętelka, która robi tak, że jeśli zdrowy stanie obok chorego to go zaraża. Można jakiś warunek, że z jakimś prawdopodobieństwem go zaraża

            vaccine.add(new pairOfInt(abs(new Random().nextInt()%(size -1)), abs(new Random().nextInt()%(size-1))));

            for (pairOfInt i : vaccine) {
                        if(mapOfSimulation.getOneObjectOfMap(i.getX(), i.getY()) instanceof AgentBeforeIllness){
                            ((AgentBeforeIllness) mapOfSimulation.getOneObjectOfMap(i.getX(), i.getY())).setVaccinated(true);

                    }

                }//tutaj jest arraylista par integerów, która losuje najpierw miejsce, gdzie ma być szczepionka a następnie jeśli ktoś stanie w tym miejscu zostaje zaszczepiony.
            //TODO gdy ktoś stanie na szczepionce, to szczepionka znika.
            //TODO wyświetlanie szczepionki



            mapOfSimulation.printMap();

            Thread.sleep(1000); //żeby leciało w pętli i można było oglądać skoki
            //TODO warunek kończący wyświetlanie mapy?
        }
    }
}
