package AgendClasses;

import Core.ObjectOfMap;
import org.junit.jupiter.api.Test;
import Map.Map;

import static org.junit.jupiter.api.Assertions.*;

class SickAgentTest {
        Map map = new Map(5,1 ,1);
        SickAgent agent = new SickAgent(3, 3, map, 40, 0.4);
    @Test
    void chengingStatusOfAgentToAgentAfterIllness() {
        agent.setDayTillEndOfIllness(0);
        ObjectOfMap[][] mapAsArray = map.getArrayOfObjects();
        mapAsArray[3][3] = agent;
        agent.chengingStatusOfAgent();
        assertEquals("A", map.getOneObjectOfMap(3,3).toString());
    }
    @Test
    void chengingStatusOfAgentToEmptyField(){
        ObjectOfMap[][] mapAsArray = map.getArrayOfObjects();
        mapAsArray[3][3] = agent;
        agent.chengingStatusOfAgent();
        assertEquals(" ", map.getOneObjectOfMap(3,3).toString());
    }
}