package AgentClasses;

import Core.DataOfSimulation;
import org.junit.jupiter.api.Test;
import Map.Map;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Klasa przeszła testy
class AgentTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 20, 50, 0.05, 1, 2, 0.1, 1, 0.1);

    Map map = new Map(dataOfSimulation);
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
        for(int i = 0; i < map.getDataOfSimulation().getSize(); i++){
            for(int j =0; j < map.getDataOfSimulation().getSize(); j++){
                if(map.getOneObjectOfMap(j,i) instanceof Agent && !(((Agent) map.getOneObjectOfMap(j,i)).getIterationMove()))
                    ((Agent) map.getOneObjectOfMap(j, i)).move();
            }
        }
        map.printMap();
    }
    @Test
    void testOfResponseOfCalling(){
        VaccinatedAgent vaccinatedAgent = new VaccinatedAgent(3,3, map);
        AgentAfterIllness agentAfterIllness = new AgentAfterIllness(2,2,map);
        vaccinatedAgent.responseForCallingOfActionOfObject();
        agentAfterIllness.responseForCallingOfActionOfObject();
        assertTrue(vaccinatedAgent.getCoordinateX() != 3 || vaccinatedAgent.getCoordinateY() != 3);
        assertTrue(agentAfterIllness.getCoordinateX() != 2 || agentAfterIllness.getCoordinateY() != 2);

    }
}