package AgendClasses;

import Core.ObjectOfMap;
import org.junit.jupiter.api.Test;
import Map.Map;
import Map.EmptyField;

import static org.junit.jupiter.api.Assertions.*;

class SickAgentTest {
        Map map = new Map(5,1 ,1);
        SickAgent agent = new SickAgent(3, 3, map, 40, 0.4);
        AgentBeforeIllness agentBeforeIllness = new AgentBeforeIllness(2, 3, map);
    @Test
    void chengingStatusOfAgentToAgentAfterIllness() {
        agent.setDayTillEndOfIllness(0);
        ObjectOfMap[][] mapAsArray = map.getArrayOfObjects();
        mapAsArray[3][3] = agent;
        agent.chengingStatusOfAgent();
        assertTrue(map.getOneObjectOfMap(3,3) instanceof AgentAfterIllness);

    }
    @Test
    void chengingStatusOfAgentToEmptyField(){
        ObjectOfMap[][] mapAsArray = map.getArrayOfObjects();
        mapAsArray[3][3] = agent;
        agent.chengingStatusOfAgent();
        assertTrue(map.getOneObjectOfMap(3,3) instanceof EmptyField);
    }
    @Test
    void searchingAndFoundingObject(){
        ObjectOfMap object = agent.checkIfNeighbor(agent.getMapPartOf(), AgentBeforeIllness.class);
        assertEquals(object.toString(), map.getOneObjectOfMap(2,3).toString());
    }
}