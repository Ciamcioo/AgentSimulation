package Core;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class SimulationMethodsTest implements SimulationMethods {
    @Test
    void testSetSize() {
        SimulationMethods.setSize(20);
        assertEquals(20, SimulationMethods.getSize());
        SimulationMethods.setSize(-5);
        assertEquals(0, SimulationMethods.getSize());
    }
    @Test
    void setNumberOfIterations() {
        SimulationMethods.setNumberOfIterations(5);
        assertEquals(5, SimulationMethods.getNumberOfIterations());
        SimulationMethods.setNumberOfIterations(-3);
        assertEquals(0, SimulationMethods.getNumberOfIterations());
    }
    @Test
    void setNumberOfHealthyAgents() {
        SimulationMethods.setNumberOfHealthyAgents(30);
        assertEquals(30, SimulationMethods.getNumberOfHealthyAgents());
        SimulationMethods.setNumberOfHealthyAgents(-5);
        assertEquals(0, SimulationMethods.getNumberOfHealthyAgents());
    }
    @Test
    void setNumberOfSickAgents() {
        SimulationMethods.setNumberOfSickAgents(40);
        assertEquals(40, SimulationMethods.getNumberOfSickAgents());
        SimulationMethods.setNumberOfSickAgents(-6);
        assertEquals(0, SimulationMethods.getNumberOfSickAgents());
    }
    @Test
    void setNumberOfVaccineKit() {
        SimulationMethods.setNumberOfHealthyAgents(40);
        SimulationMethods.setNumberOfSickAgents(10);
        SimulationMethods.setNumberOfVaccineKit(9);
        assertEquals(9, SimulationMethods.getNumberOfVaccineKit());
        SimulationMethods.setNumberOfVaccineKit(-5);
        assertEquals(0, SimulationMethods.getNumberOfVaccineKit());
        SimulationMethods.setNumberOfVaccineKit(6);
        assertEquals(6, SimulationMethods.getNumberOfVaccineKit());
        SimulationMethods.setNumberOfVaccineKit(15);
        assertEquals(0, SimulationMethods.getNumberOfVaccineKit());
    }
    @Test
    void setNumberOfIsolation() {
        SimulationMethods.setNumberOfHealthyAgents(50);
        SimulationMethods.setNumberOfSickAgents(15);
        SimulationMethods.setNumberOfIsolation(3);
        assertEquals(3, SimulationMethods.getNumberOfIsolation());
        SimulationMethods.setNumberOfIsolation(-9);
        assertEquals(0, SimulationMethods.getNumberOfIsolation());
        SimulationMethods.setNumberOfIsolation(4);
        assertEquals(4, SimulationMethods.getNumberOfIsolation());
        SimulationMethods.setNumberOfIsolation(15);
        assertEquals(0, SimulationMethods.getNumberOfIsolation());
    }

    @Test
    void enteringDateForSimulation() {
    }

    @Test
    void agentControlMethod() {
    }
}