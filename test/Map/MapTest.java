package Map;

import AgentClasses.Agent;
import AgentClasses.AgentBeforeIllness;
import AgentClasses.SickAgent;
import Core.DataOfSimulation;
import Package.VaccineKit;
import Package.Isolation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
// Klasa przeszła testy
class MapTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 20, 50, 0.05, 1, 2, 0.1, 1, 0.1);

    Map map = new Map(dataOfSimulation);

    @Test
    void testForArrayMap() {
        ObjectOfMap[][] newArray = new ObjectOfMap[7][7];
        map.setArrayOfObjects(newArray);
        assertEquals(newArray, map.getArrayOfObjects());
    }

    @Test
    void testForOneObjectOfMap() {
        AgentBeforeIllness agent = new AgentBeforeIllness(3, 4, map);
        map.setOneObjectOfMap(3, 4, agent);
        assertEquals(agent, map.getOneObjectOfMap(3, 4));
    }

    @Test
    void agentInitializationOnMap() {
        int countSick = 0, countHealthy = 0, countEmpty = 0;
        for (int i = 0; i < map.getDataOfSimulation().getSize(); i++) {
            for (int j = 0; j < map.getDataOfSimulation().getSize(); j++) {
                if (map.getOneObjectOfMap(i, j) instanceof AgentBeforeIllness)
                    countHealthy++;
                else if (map.getOneObjectOfMap(i, j) instanceof SickAgent)
                    countSick++;
                else
                    countEmpty++;
            }
        }
        assertEquals(map.getDataOfSimulation().getNumberOfSickAgents(), countSick);
        assertEquals(map.getDataOfSimulation().getNumberOfHealthyAgents(), countHealthy);
        assertEquals(map.getDataOfSimulation().getSize() * map.getDataOfSimulation().getSize() - map.getDataOfSimulation().getNumberOfSickAgents() - map.getDataOfSimulation().getNumberOfHealthyAgents(), countEmpty);
    }

    @Test
    void checkAfterEmptyMapInitialization() {
        DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 0, 0,0,0, 0, 0,0, 0.1, 0, 0.1);
        Map newMap = new Map(dataOfSimulation);
        boolean isEverythingEmpty = true;
        for (int i = 0; i < newMap.getDataOfSimulation().getSize(); i++) {
            for (int j = 0; j < newMap.getDataOfSimulation().getSize(); j++) {
                if (!(newMap.getOneObjectOfMap(j, i) instanceof EmptyField))
                    isEverythingEmpty = false;
            }
        }
        assertTrue(isEverythingEmpty);
    }

    @Test
    void testForHealthyAgentInitialization() {
        int counter = 0;
        for (int i = 0; i < map.getDataOfSimulation().getSize(); i++) {
            for (int j = 0; j < map.getDataOfSimulation().getSize(); j++) {
                if (map.getOneObjectOfMap(i, j) instanceof AgentBeforeIllness)
                    counter++;
            }
        }
        assertEquals(map.getDataOfSimulation().getNumberOfHealthyAgents(), counter);
    }

    @Test
    void testForSickAgentInitialization() {
        int counter = 0;
        for (int i = 0; i < map.getDataOfSimulation().getSize(); i++) {
            for (int j = 0; j < map.getDataOfSimulation().getSize(); j++) {
                if (map.getOneObjectOfMap(i, j) instanceof SickAgent)
                    counter++;
            }
        }
        assertEquals(map.getDataOfSimulation().getNumberOfSickAgents(), counter);
    }


    @Test
    void testForVaccineKitInitialization() {
        boolean initializationCompletedCorrectly = false;

    }

    @Test
    void testForChangingPositionOfAgent() {
        map.setOneObjectOfMap(3, 3, new AgentBeforeIllness(3, 3, map));
        Agent agent = (Agent) map.getOneObjectOfMap(3, 3);
        map.printMap();
        map.changePositionOfAgent(agent, 2, 4);
        map.printMap();
        assertEquals(2, agent.getCoordinateX());
        assertEquals(4, agent.getCoordinateY());
        assertTrue(agent.getIterationMove());
    }

    @Test
    void printingMap() {
        map.printMap();
    }
    @Test
    void testForPackageDestruction(){
        VaccineKit kit = new VaccineKit(0,0, map);
        Isolation isolation = new Isolation(0,1, map);
        isolation.setEmpty();
        map.packageDestruction();
        assertTrue(map.getOneObjectOfMap(0,0) instanceof VaccineKit);
        assertTrue(map.getOneObjectOfMap(0,1) instanceof  EmptyField);
    }
}