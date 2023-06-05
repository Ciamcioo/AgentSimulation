package Map;

import AgentClasses.Agent;
import AgentClasses.AgentBeforeIllness;
import AgentClasses.SickAgent;
import Core.ObjectOfMap;
import Package.Package;
import Package.VaccineKit;
import Package.Isolation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapTest {
    Map map = new Map(6,2,3);
    @Test
    void testForSetSizeCorrectly(){
        map.setSize(7);
        assertEquals(7, map.getSize());
    }
    @Test
    void testForNotCorrectlySetSize(){
        map.setSize(0);
        assertEquals(-1, map.getSize());
    }
    @Test
    void testForSetHealthyAgentCorrectly(){
        assertEquals(1, map.getHealthyAgents());
    }
    @Test
    void testForSetHealthyAgentNotCorrectly(){
        map.setHealthyAgents(-4);
        assertEquals(-3,map.getHealthyAgents());
    }
    @Test
    void testForSetSickAgentCorrectly(){
        assertEquals(1, map.getSickAgents());
    }
    @Test
    void testForSetSickNotCorrectly(){
        map.setSickAgents(-5);
        assertEquals(-2, map.getSickAgents());
    }
    @Test
    void testForArrayMap(){
        ObjectOfMap[][] newArray = new ObjectOfMap[7][7];
        map.setArrayOfObjects(newArray);
        assertEquals(newArray, map.getArrayOfObjects());
    }
    @Test
    void testForOneObjectOfMap(){
        AgentBeforeIllness agent = new AgentBeforeIllness(3,4,map);
        map.setOneObjectOfMap(3,4, agent);
        assertEquals(agent, map.getOneObjectOfMap(3,4));
    }
    @Test
    void checkAfterEmptyMapInitialization(){
        boolean isEverythingEmpty = true;
        for(int i = 0; i < map.getSize(); i++){
            for (int j =0; j < map.getSize(); j++){
                if(!(map.getOneObjectOfMap(j,i) instanceof EmptyField))
                    isEverythingEmpty = false;
            }
        }
        assertTrue(isEverythingEmpty);
    }

    @Test
    void testForMapInitialization(){
        Map newMap = new Map(50, 15, 15);
        newMap.printMap();
    }
    @Test
    void agentInitializationOnMap(){
        int countSick = 0, countHealthy = 0, countEmpty = 0;
        for (int i = 0; i < map.getSize(); i++){
            for (int j = 0; j < map.getSize(); j++){
                if(map.getOneObjectOfMap(i,j) instanceof AgentBeforeIllness)
                    countHealthy++;
                else if (map.getOneObjectOfMap(i,j) instanceof SickAgent)
                    countSick++;
                else
                    countEmpty++;
            }
        }
        assertEquals(map.getSickAgents(), countSick);
        assertEquals(map.getHealthyAgents(), countHealthy);
        assertEquals(map.getSize()* map.getSize() - map.getSickAgents() - map.getHealthyAgents(), countEmpty);
    }
    @Test
    void testForHealthyAgentInitialization(){
        int counter = 0;
        map.initializationOfHealthyAgents();
        for(int i = 0; i < map.getSize(); i++){
            for(int j = 0; j < map.getSize(); j++){
                if(map.getOneObjectOfMap(i,j) instanceof AgentBeforeIllness)
                    counter++;
            }
        }
        assertEquals(map.getHealthyAgents(), counter);
    }

    @Test
    void testForSickAgentInitialization(){
        int counter = 0;
        map.initializationOfSickAgents();
        for(int i = 0; i < map.getSize(); i++){
            for(int j = 0; j < map.getSize(); j++){
                if(map.getOneObjectOfMap(i,j) instanceof SickAgent)
                    counter++;
            }
        }
        assertEquals(map.getSickAgents(), counter);
    }
    @Test
    void testForChangingPosition(){
        AgentBeforeIllness agentBeforeIllness = new AgentBeforeIllness(0,0, map);
        map.setOneObjectOfMap(0,0,agentBeforeIllness);
        map.changePositionOfAgent(agentBeforeIllness,4,4);
        assertEquals(agentBeforeIllness, map.getOneObjectOfMap(4,4));
    }
    @Test
    void testForPackageInitialization(){
        boolean isThereIsolation = false, isThereKit = false;
        Package kit = new VaccineKit( map,0.5,2);
        Package isolation = new Isolation(map,0.5);
        map.packageInitialization(kit);
        map.packageInitialization(isolation);
        for (int i = 0; i < map.getSize(); i++){
            for (int j =0; j < map.getSize(); j++){
                if (map.getOneObjectOfMap(j,i) instanceof VaccineKit)
                    isThereKit = true;
                else if (map.getOneObjectOfMap(j,i) instanceof Isolation)
                    isThereIsolation = true;
            }
        }
        assertTrue(isThereIsolation);
        assertTrue(isThereKit);
    }
    @Test
    void testForMovingAgent(){
        map.setOneObjectOfMap(3,3, new AgentBeforeIllness(3,3, map));
        Agent agent = (Agent) map.getOneObjectOfMap(3,3);
        map.printMap();
        map.changePositionOfAgent(agent, 2, 4);
        map.printMap();
        assertEquals(2, agent.getCoordinateX());
        assertEquals(4,agent.getCoordinateY());
        assertTrue(agent.getIterationMove());
    }
    @Test
    void printingMap(){
        map.printMap();
    }
}