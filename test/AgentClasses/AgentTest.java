package AgentClasses;

import org.junit.jupiter.api.Test;

import Map.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AgentTest {
    Map map = new Map(10, 5, 5);
    @Test
    void testForIterationMove(){
        Agent agent = new AgentBeforeIllness(3,3, map);
        agent.setIterationMove(true);
        assertTrue(agent.getIterationMove());
        agent.setIterationMove(false);
        assertFalse(agent.getIterationMove());

    }
    @Test
    void moveObjects() {
        map.printMap();
        for(int i = 0; i < map.getSize(); i++){
            for(int j =0; j < map.getSize(); j++){
                if(map.getOneObjectOfMap(j,i) instanceof Agent && !(((Agent) map.getOneObjectOfMap(j,i)).getIterationMove()))
                    ((Agent) map.getOneObjectOfMap(j, i)).move();
            }
        }
        map.printMap();
    }
}