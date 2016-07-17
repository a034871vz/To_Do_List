import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Хозяин on 03.06.2016.
 */
public class ArrayA {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        //int n = Integer.parseInt(r.readLine());
        //int n = Integer.parseInt(JOptionPane.showInputDialog("Введи размерность матрицы: "));
        int n = (int) (10 * Math.random());
        String str = "Матрица";
        int mass[][] = new int[n][n];
        for (int i = 0; i < mass.length; i++) {
            str += "\n";
            for (int j = 0; j < mass.length; j++) {
                mass[i][j] = (int) (10 * Math.random());
                str += mass[i][j] + " ";
            }
        }
        //JOptionPane.showMessageDialog(null,str);
        System.out.println(str);

        int max_i[] = new int[n];
        int min_j[] = new int[n];
        int value;

        for (int i = 0; i < mass.length; i++) {
            max_i[i] = mass[i][0];
            for (int j = 1; j < mass.length; j++) {
                if (max_i[i] < mass[i][j]) {
                    max_i[i] = mass[i][j];
                }
            }
        }
        for (int j = 0; j < mass.length; j++) {
            min_j[j] = mass[0][j];
            for (int i = 1; i < mass.length; i++) {
                if (min_j[j] > mass[i][j]) {
                    min_j[j] = mass[i][j];
                }
            }
        }

        int points = 0;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                if (mass[i][j] == max_i[i] && mass[i][j] == min_j[j]) {
                    System.out.println("\n" + "Седловая точка находится в [" + i + "][" + j + "]");
                    points++;
                }
            }
        }
        if (points == 0) {
            System.out.println("\n"+"Таких точек нет");
        }
    }
}