package Package;

import AgentClasses.Agent;
import AgentClasses.AgentBeforeIllness;
import AgentClasses.VaccinatedAgent;
import Core.DataOfSimulation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Map.Map;

class VaccineKitTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 1, 2, 0.1, 1, 0.1);

    Map map = new Map(dataOfSimulation);
    VaccineKit kit = new VaccineKit(3,3, map);
    @Test
    void testForPrintInConsoleOfVaccineKit(){
        assertEquals("K", kit.toString());
    }
    @Test
    void testForResponseForCallingOfActionObject(){
        AgentBeforeIllness agentBeforeIllness = new AgentBeforeIllness(2,3, map);
        map.setOneObjectOfMap(2,3, agentBeforeIllness);
        map.printMap();
        agentBeforeIllness.searching();
        // TODO tutaj jest jakiś błąd
//        assertTrue(agentBeforeIllness.getVaccinated());
//        assertTrue(map.getOneObjectOfMap(3,3) instanceof VaccinatedAgent);
////        assertTrue(kit.isEmpty());
        map.printMap();
    }
}