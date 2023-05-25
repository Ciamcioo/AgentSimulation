package Map;

import java.util.Random;

public class Map {

    private String[][] map;
    private int size = 0;

    public Map(int size){
        this.setSize(size);
        this.map = new String[this.size+2][this.size+2];
    }

    public void map_initialization(double vaccineProbability){
//        map = new String[size+2][size+2];
        int[] probability = new int[100];

        for(int i = 0; i < vaccineProbability*100; i++){
            probability[i] = 1;
        }

        for(int i = 1; i<=size; i++){
            for(int j = 1; j<=size; j++){
                int random = new Random().nextInt(probability.length);
                if(probability[random]==1){
                    map[i][j]="V";
                } else {
                    map[i][j]=" ";
                }
            }
        }
    }

    public void print_map(){
        for(int i = 1; i<=size; i++){
            System.out.print(" __");
        }
        System.out.println();
        for(int i = 1; i <=size; i++){
            System.out.print("|");
            for(int j = 1; j<=size; j++){
                System.out.print("  " + map[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
        for(int i = 1; i<=size; i++){
            System.out.print(" __");
        }
    }
    public void setSize(int size){
        if (size > 1){
            this.size = size;
        }
    }

}