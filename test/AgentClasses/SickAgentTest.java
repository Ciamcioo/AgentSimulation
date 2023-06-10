package AgentClasses;

import Core.DataOfSimulation;
import org.junit.jupiter.api.Test;
import Map.Map;
import Map.EmptyField;
import static org.junit.jupiter.api.Assertions.*;
// Klasa przeszła testy
class SickAgentTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 20, 50, 0.05, 1, 2, 0.1, 1, 0.1);


        Map map = new Map(dataOfSimulation);
        SickAgent sickAgent = new SickAgent(2, 2, map, map.getDataOfSimulation().getMinDayTillEndOfIllness(), map.getDataOfSimulation().getMaxDayTillEndOfIllness());
        AgentBeforeIllness agentBeforeIllness = new AgentBeforeIllness(1, 2, map);
        @Test
        void testForDaysTillEndOfIllness(){
            sickAgent.setDayTillEndOfIllness(20);
            assertEquals(20, sickAgent.getDayTillEndOfIllness());
        }
        @Test
        void testForChanceOfDeath(){
            sickAgent.getMapPartOf().getDataOfSimulation().setChanceOfSickAgentDeath(0.4);
            assertEquals(0.4, sickAgent.getMapPartOf().getDataOfSimulation().getChanceOfSickAgentDeath());
        }
        @Test
        void chengingStatusOfAgentToAgentAfterIllness() {
            sickAgent.setDayTillEndOfIllness(0);
            sickAgent.changingStatusOfAgent();
            assertTrue(map.getOneObjectOfMap(2,2) instanceof AgentAfterIllness);

        }
        @Test
        void chengingStatusOfAgentToEmptyField(){
            sickAgent.changingStatusOfAgent();
            assertTrue(map.getOneObjectOfMap(2,2) instanceof EmptyField);
        }
        @Test
        void searchingAndFoundingObject(){
            map.setOneObjectOfMap(2,2, sickAgent);
            map.setOneObjectOfMap(1,2,agentBeforeIllness);
            assertTrue(map.getOneObjectOfMap(2,2).checkIfNeighbor(map, AgentBeforeIllness.class) instanceof AgentBeforeIllness);

        }
        @Test
        void testOfResponseForCalling(){
            sickAgent.responseForCallingOfActionOfObject();
            assertTrue(sickAgent.getCoordinateX() != 2 || sickAgent.getCoordinateY() != 2);
        }
        @Test
        void testToString(){
            assertEquals("S", map.getOneObjectOfMap(2,2).toString());
        }
}