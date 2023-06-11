package Package;

import AgentClasses.AgentBeforeIllness;
import AgentClasses.VaccinatedAgent;
import Core.DataOfSimulation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Map.Map;
// Klasa przeszła testy

class VaccineKitTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 20, 50, 0.05, 2, 1, 0.1, 1, 0.1);
    Map map = new Map(dataOfSimulation);
    VaccineKit kit = new VaccineKit(3,3, map);
    @Test
    void testForPrintInConsoleOfVaccineKit(){
        assertEquals("K", kit.toString());
    }
    @Test
    void testForResponseForCallingOfActionObject(){
        AgentBeforeIllness agentBeforeIllness = new AgentBeforeIllness(2,3, map);
        agentBeforeIllness.searching();
        assertTrue(agentBeforeIllness.getVaccinated());
        assertTrue(map.getOneObjectOfMap(2,3) instanceof VaccinatedAgent);
        assertTrue(kit.isEmpty());
        assertEquals(1, map.getChangedObjects());

    }
}