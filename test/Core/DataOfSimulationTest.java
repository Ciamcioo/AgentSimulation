package Core;

import AgentClasses.AgentBeforeIllness;
import AgentClasses.VaccinatedAgent;
import org.junit.jupiter.api.Test;
import Package.VaccineKit;
import Package.Isolation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Map.Map;
// Klasa przeszła testy
class DataOfSimulationTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 20, 50, 0.05, 1, 2, 0.1, 1, 0.1);

    Map map = new Map(dataOfSimulation);
    @Test
    void testSetSize() {
        dataOfSimulation.setSize(20);
        assertEquals(20, dataOfSimulation.getSize());
        dataOfSimulation.setSize(-5);
        assertEquals(0, dataOfSimulation.getSize());
    }
    @Test
    void setNumberOfIterations() {
        dataOfSimulation.setNumberOfIterations(5);
        assertEquals(5, dataOfSimulation.getNumberOfIterations());
        dataOfSimulation.setNumberOfIterations(-3);
        assertEquals(0, dataOfSimulation.getNumberOfIterations());
    }
    @Test
    void setNumberOfVaccinated(){
        dataOfSimulation.setNumberOfVaccinated(4);
        assertEquals(4, dataOfSimulation.getNumberOfVaccinated());
        dataOfSimulation.setNumberOfVaccinated(-1);
        assertEquals(0, dataOfSimulation.getNumberOfVaccinated());
    }
    @Test
    void setNumberOfAfterIllness(){
        dataOfSimulation.setNumberOfAfterIllness(5);
        assertEquals(5, dataOfSimulation.getNumberOfAfterIllness());
        dataOfSimulation.setNumberOfAfterIllness(-9);
        assertEquals(0, dataOfSimulation.getNumberOfAfterIllness());
    }
    @Test
    void setNumberOfHealthyAgents() {
        dataOfSimulation.setNumberOfHealthyAgents(30);
        assertEquals(30, dataOfSimulation.getNumberOfHealthyAgents());
        dataOfSimulation.setNumberOfHealthyAgents(-5);
        assertEquals(0, dataOfSimulation.getNumberOfHealthyAgents());
    }
    @Test
    void setNumberOfSickAgents() {
        dataOfSimulation.setNumberOfSickAgents(40);
        assertEquals(40, dataOfSimulation.getNumberOfSickAgents());
        dataOfSimulation.setNumberOfSickAgents(-6);
        assertEquals(0, dataOfSimulation.getNumberOfSickAgents());
    }
    @Test
    void testSetMinDayTillEndOfIllness(){
        dataOfSimulation.setMinDayTillEndOfIllness(-5);
        assertEquals(1, dataOfSimulation.getMinDayTillEndOfIllness());
        dataOfSimulation.setMinDayTillEndOfIllness(40);
        assertEquals(40, dataOfSimulation.getMinDayTillEndOfIllness());
    }
    @Test
    void testSetMaxDayTillEndOfIllness(){
        dataOfSimulation.setMaxDayTillEndOfIllness(-2);
        assertEquals(1, dataOfSimulation.getMaxDayTillEndOfIllness());
        dataOfSimulation.setMaxDayTillEndOfIllness(50);
        assertEquals(50, dataOfSimulation.getMaxDayTillEndOfIllness());
    }
    @Test
    void testSetChanceOfSickAgentDeath(){
        dataOfSimulation.setChanceOfSickAgentDeath(0.2);
        assertEquals(0.2, dataOfSimulation.getChanceOfSickAgentDeath());
        dataOfSimulation.setChanceOfSickAgentDeath(-0.1);
        assertEquals(0.0, dataOfSimulation.getChanceOfSickAgentDeath());
        dataOfSimulation.setChanceOfSickAgentDeath(0.7);
        assertEquals(0.7, dataOfSimulation.getChanceOfSickAgentDeath());
        dataOfSimulation.setChanceOfSickAgentDeath(1.5);
        assertEquals(0.0, dataOfSimulation.getChanceOfSickAgentDeath());

    }
    @Test
    void setNumberOfVaccineKit() {
        dataOfSimulation.setNumberOfHealthyAgents(40);
        dataOfSimulation.setNumberOfSickAgents(10);
        dataOfSimulation.setNumberOfVaccineKit(9);
        assertEquals(9, dataOfSimulation.getNumberOfVaccineKit());
        dataOfSimulation.setNumberOfVaccineKit(-5);
        assertEquals(0, dataOfSimulation.getNumberOfVaccineKit());
        dataOfSimulation.setNumberOfVaccineKit(6);
        assertEquals(6, dataOfSimulation.getNumberOfVaccineKit());
        dataOfSimulation.setNumberOfVaccineKit(15);
        assertEquals(0, dataOfSimulation.getNumberOfVaccineKit());
    }
    @Test
    void setChanceOfVaccine(){
        dataOfSimulation.setChanceOfSpawnVaccine(0.3);
        assertEquals(0.3, dataOfSimulation.getChanceOfSpawnVaccine());
        dataOfSimulation.setChanceOfSpawnVaccine(-0.1);
        assertEquals(0, dataOfSimulation.getChanceOfSpawnVaccine());
        dataOfSimulation.setChanceOfSpawnVaccine(0.9);
        assertEquals(0.9, dataOfSimulation.getChanceOfSpawnVaccine());
        dataOfSimulation.setChanceOfSpawnVaccine(1.5);
        assertEquals(0, dataOfSimulation.getChanceOfSpawnVaccine());
    }
    @Test
    void setNumberOfVaccineInOneKit(){
        dataOfSimulation.setNumberOfVaccineInKit(3);
        assertEquals(3, dataOfSimulation.getNumberOfVaccineInKit());
        dataOfSimulation.setNumberOfVaccineInKit(-4);
        assertEquals(0, dataOfSimulation.getNumberOfVaccineInKit());
        dataOfSimulation.setNumberOfVaccineInKit(2);
        assertEquals(2, dataOfSimulation.getNumberOfVaccineInKit());
        dataOfSimulation.setNumberOfVaccineInKit(6);
        assertEquals(0, dataOfSimulation.getNumberOfVaccineInKit());
    }


    @Test
    void setNumberOfIsolation() {
        dataOfSimulation.setNumberOfHealthyAgents(50);
        dataOfSimulation.setNumberOfSickAgents(15);
        dataOfSimulation.setNumberOfIsolation(3);
        assertEquals(3, dataOfSimulation.getNumberOfIsolation());
        dataOfSimulation.setNumberOfIsolation(-9);
        assertEquals(0, dataOfSimulation.getNumberOfIsolation());
        dataOfSimulation.setNumberOfIsolation(3);
        assertEquals(3, dataOfSimulation.getNumberOfIsolation());
        dataOfSimulation.setNumberOfIsolation(15);
        assertEquals(0, dataOfSimulation.getNumberOfIsolation());
    }
    @Test
    void setChanceOfSpawnIsolation(){
        dataOfSimulation.setChanceOfSpawnIsolation(0.4);
        assertEquals(0.4, dataOfSimulation.getChanceOfSpawnIsolation());
        dataOfSimulation.setChanceOfSpawnIsolation(-4.2);
        assertEquals(0, dataOfSimulation.getChanceOfSpawnIsolation());
        dataOfSimulation.setChanceOfSpawnIsolation(0.4);
        assertEquals(0.4, dataOfSimulation.getChanceOfSpawnIsolation());
        dataOfSimulation.setChanceOfSpawnIsolation(1.2);
        assertEquals(0, dataOfSimulation.getChanceOfSpawnIsolation());
    }
    @Test
    void testForUpdateData(){
        dataOfSimulation.updateData(map);
        assertEquals(5, map.getDataOfSimulation().getNumberOfHealthyAgents());
        for (int i = 0; i < dataOfSimulation.getSize(); i++){
            for (int j = 0; j < dataOfSimulation.getSize(); j++) {
                if (map.getOneObjectOfMap(j, i) instanceof AgentBeforeIllness) {
                    ((AgentBeforeIllness) map.getOneObjectOfMap(j, i)).setVaccinated(true);
                    ((AgentBeforeIllness) map.getOneObjectOfMap(j, i)).changingStatusOfAgent();
                    assertTrue(map.getOneObjectOfMap(j, i) instanceof VaccinatedAgent);

                }
            }

        }
        dataOfSimulation.updateData(map);
        assertEquals(0, dataOfSimulation.getNumberOfHealthyAgents());
        assertEquals(5, dataOfSimulation.getNumberOfVaccinated());
    }
    @Test
    void testForDisplayData(){
            dataOfSimulation.displayData(map);
    }



}