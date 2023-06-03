package AgendClasses;

import Core.ObjectOfMap;
import Map.Map;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import AgendClasses.VaccinatedAgent;

public class AgentBeforeIllnessTest {
    Map map = new Map(5,1 ,1);
    AgentBeforeIllness agent = new AgentBeforeIllness(3, 3, map);
    @Test
    public void changingStatusOfAgentToVaccinated(){
        agent.setVaccinated(true);
        ObjectOfMap[][] mapAsArray = map.getArrayOfObjects();
        mapAsArray[3][3] = agent;
        agent.chengingStatusOfAgent();
        assertTrue(map.getOneObjectOfMap(3,3) instanceof VaccinatedAgent);
        map.printMap();
    }
    @Test
    public void changingStatusOfAgentToSick(){
        ObjectOfMap[][] mapAsArray = map.getArrayOfObjects();
        mapAsArray[3][3] = agent;
        agent.chengingStatusOfAgent();
        assertTrue(map.getOneObjectOfMap(3,3) instanceof SickAgent);
    }
}