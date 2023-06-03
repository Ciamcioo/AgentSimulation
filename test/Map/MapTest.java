package Map;

import AgendClasses.AgentBeforeIllness;
import AgendClasses.SickAgent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    Map map = new Map(5,1,1);
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
        map.agentInitializationOnMap();
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
        assertEquals(1, countSick);
        assertEquals(1, countHealthy);
        assertEquals(23, countEmpty);
    }

    @Test
    void correctlySetListOfAgent(){
        boolean isEverythingOne = true;
        ArrayList<Integer> arrayListOfAgent = map.createAndFillArrayRepresentingAgents();
        for(int i = 0; i <  map.getSickAgents() + map.getHealthyAgents(); i++)
            isEverythingOne = arrayListOfAgent.get(i) == 1;
        assertTrue(isEverythingOne);
    }

    @Test
    void printingMap(){
        map.printMap();
    }
}