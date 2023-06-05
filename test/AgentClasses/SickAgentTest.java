package AgentClasses;

import Core.ObjectOfMap;
import org.junit.jupiter.api.Test;
import Map.Map;
import Map.EmptyField;

import static org.junit.jupiter.api.Assertions.*;

class SickAgentTest {
        Map map = new Map(5,1 ,1);
        SickAgent sickAgent = new SickAgent(2, 2, map);
        AgentBeforeIllness agentBeforeIllness = new AgentBeforeIllness(1, 2, map);
        @Test
        void testForChanceOfDeath(){
            sickAgent.setChanceOfDeath(0.4);
            assertEquals(0.4, sickAgent.getChanceOfDeath());
        }
        @Test
        void testForDaysTillEndOfIllness(){
            sickAgent.setDayTillEndOfIllness(20);
            assertEquals(20, sickAgent.getDayTillEndOfIllness());
        }
        @Test
        void chengingStatusOfAgentToAgentAfterIllness() {
            sickAgent.setDayTillEndOfIllness(0);
            ObjectOfMap[][] mapAsArray = map.getArrayOfObjects();
            mapAsArray[3][3] = sickAgent;
            sickAgent.chengingStatusOfAgent();
            assertTrue(map.getOneObjectOfMap(3,3) instanceof AgentAfterIllness);

        }
        @Test
        void chengingStatusOfAgentToEmptyField(){
            ObjectOfMap[][] mapAsArray = map.getArrayOfObjects();
            mapAsArray[3][3] = sickAgent;
            sickAgent.chengingStatusOfAgent();
            assertTrue(map.getOneObjectOfMap(3,3) instanceof EmptyField);
        }
        @Test
        void searchingAndFoundingObject(){
            map.setOneObjectOfMap(2,2, sickAgent);
            map.setOneObjectOfMap(1,2,agentBeforeIllness);
            assertTrue(map.getOneObjectOfMap(2,2).checkIfNeighbor(map, AgentBeforeIllness.class) instanceof AgentBeforeIllness);

        }
}