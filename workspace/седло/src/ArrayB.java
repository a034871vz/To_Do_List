import javax.swing.*;

/**
 * Created by Хозяин on 03.06.2016.
 */
public class ArrayB {
    public static void main(String[] args) throws java.lang.Exception {
        int[][] mas = new int[4][6];

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = (int) (Math.random() * 9 - 1);
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }



        for (int i = 0; i < mas[0].length; i++) {
            int max = mas[0][i];
            int min = mas[0][i];
            for (int j = 0; j < mas.length; j++) {

                if (max < mas[j][i]) {max = mas[j][i];}
                if (min > mas[j][i]) {min = mas[j][i];}
            }
            System.out.print("максимальный эл. в столбце"+max + "\n");
            System.out.print("минимальный эл. в столбце"+min + "\n");
        }


    }
}