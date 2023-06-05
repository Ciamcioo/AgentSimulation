package AgentClasses;

import Core.ObjectOfMap;
import Map.Map;
import org.junit.jupiter.api.Test;
import Package.VaccineKit;

import static org.junit.jupiter.api.Assertions.*;

public class AgentBeforeIllnessTest {
    Map map = new Map(5,1 ,1);
    AgentBeforeIllness agent = new AgentBeforeIllness(3, 3, map);
    @Test
    public void testForVaccination(){
        agent.setVaccinated(true);
        assertTrue(agent.getVaccinated());
        agent.setVaccinated(false);
        assertFalse(agent.getVaccinated());
    }
    @Test
    public void changingStatusOfAgentToVaccinated(){
        agent.setVaccinated(true);
        ObjectOfMap[][] mapAsArray = map.getArrayOfObjects();
        mapAsArray[3][3] = agent;
        agent.changingStatusOfAgent();
        assertTrue(map.getOneObjectOfMap(3,3) instanceof VaccinatedAgent);
        map.printMap();
    }
    @Test
    public void changingStatusOfAgentToSick(){
        ObjectOfMap[][] mapAsArray = map.getArrayOfObjects();
        mapAsArray[3][3] = agent;
        agent.changingStatusOfAgent();
        assertTrue(map.getOneObjectOfMap(3,3) instanceof SickAgent);
    }
    @Test
    public void searchingForVaccination(){
        VaccineKit kit = new VaccineKit(2,3,map,0.5,2);
        map.setOneObjectOfMap(2,3,kit);
        map.setOneObjectOfMap(3,3, agent);
        agent.searching();
        assertTrue(map.getOneObjectOfMap(3,3).checkIfNeighbor(map, VaccineKit.class) instanceof VaccineKit);

    }
}