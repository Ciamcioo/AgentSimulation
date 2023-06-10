package Core;
import Map.Map;

import static java.lang.Math.abs;

public class Simulation  {

    public static void main(String[] args) throws InterruptedException {
        DataOfSimulation dataOfSimulation = new DataOfSimulation();
        Map mapOfSimulation = new Map(dataOfSimulation);

        while (dataOfSimulation.getNumberOfIterations() > 0) {
            mapOfSimulation.packageInitialization();
            // TODO packageSpawn jeszcze nie jest napisana trzeba dogadać czy będziemy zachowywali pakiety z poprzednich iteracji czy nie
            mapOfSimulation.agentControlMethod();
            mapOfSimulation.printMap();
            mapOfSimulation.packageDestruction();
            mapOfSimulation.settingValueOfMoveIterationToFalse();
            dataOfSimulation.setNumberOfIterations(dataOfSimulation.getNumberOfIterations() - 1);
            dataOfSimulation.updateData(mapOfSimulation);
            dataOfSimulation.displayData(mapOfSimulation);
            Thread.sleep(1000);
        }

        // TODO dopisać testy jednostkowe do klas, które ich nie mają. Przejżyjcie te testy i klasy, jeżli jakiaś nie ma testu to daje TODO że dopisać test do klasy i ja powoli
        //  je będe dopisywał

        // TODO dopisać w konstruktorach odrazu przypisywanie do mapy
        // TODO dopisać lepsze niszczenie obiektu wtedy gdy obiekty jest pusty


    }
}
