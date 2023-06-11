package Core;
import Map.Map;
public class Simulation  {

    public static void main(String[] args) {
//        DataOfSimulation dataOfSimulation = new DataOfSimulation();
        DataOfSimulation dataOfSimulation = new DataOfSimulation(20, 40, 40, 10, 20, 40, 0.1, 5, 2, 0.1, 2 ,0.1);
        Map mapOfSimulation = new Map(dataOfSimulation);

        while (dataOfSimulation.getNumberOfIterations() > 0) {
            mapOfSimulation.packageInitialization();
            mapOfSimulation.agentControlMethod();
            mapOfSimulation.printMap();
            mapOfSimulation.packageDestruction();
            mapOfSimulation.settingValueOfMoveIterationToFalse();
            dataOfSimulation.setNumberOfIterations(dataOfSimulation.getNumberOfIterations() - 1);
            dataOfSimulation.updateData(mapOfSimulation);
            dataOfSimulation.displayData(mapOfSimulation);

        }
    }
}
