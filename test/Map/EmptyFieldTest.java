package Map;

import Core.DataOfSimulation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyFieldTest {
    DataOfSimulation dataOfSimulation = new DataOfSimulation(10 ,20, 5, 5, 1, 2, 0.1, 1, 0.1);

    Map map = new Map(dataOfSimulation);
    @Test
    void testToString() {
        EmptyField field = new EmptyField(0,0,map);
        assertEquals(" ", field.toString());
    }
}