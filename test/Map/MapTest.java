package Map;

import AgendClasses.AgentBeforeIllness;
import AgendClasses.SickAgent;
import AgendClasses.Agent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
    void testForSetSickAgentCorrectly(){
        assertEquals(1, map.getSickAgents());
    }
    @Test
    void testForSetSickNotCorrectly(){
        map.setSickAgents(-5);
        assertEquals(-2, map.getSickAgents());
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
    void agentInitializationOnMap(){
        int countSick = 0, countHealthy = 0, countEmpty = 0;
//        map.agentInitializationOnMap();
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

//    @Test
//    void correctlySetListOfAgent(){
//        boolean isEverythingOne = true;
////        ArrayList<Agent> arrayListOfAgent = map.createAndFillArrayRepresentingAgents();
//        for(int i = 0; i <  map.getSickAgents() + map.getHealthyAgents(); i++)
//
////        assertTrue(isEverythingOne);
//    }

    @Test
    void printingMap(){
        map.printMap();
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
    }   @Test
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
    void testForMapInitialization(){
        Map newMap = new Map(50, 15, 15);
        newMap.printMap();
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
}