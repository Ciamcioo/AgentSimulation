package AgendClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Map.Map;

class AgentTest {
    Map map = new Map(10, 5, 5);
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