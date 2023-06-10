package Core;

import AgentClasses.AgentBeforeIllness;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
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
        AgentBeforeIllness agentBeforeIllness = new AgentBeforeIllness(0,0, map);
        map.setOneObjectOfMap(0,0, agentBeforeIllness);
        dataOfSimulation.updateData(map);
        agentBeforeIllness.setVaccinated(true);
        agentBeforeIllness.changingStatusOfAgent();
        dataOfSimulation.updateData(map);

    }



}