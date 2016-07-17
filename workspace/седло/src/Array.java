/**
 * Created by Хозяин on 04.06.2016.
 */


public class Array {

    public static void main(String[] args) {
        int n = (int) (10 * Math.random());
        int a[][] = new int[n][n];
        int maxst[] = new int[n];
        int maxsr[] = new int[n];
        int minst[] = new int[n];
        int minsr[] = new int[n];
        int i, j, points;

        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                a[i][j] = (int) (10 * Math.random());
                System.out.print(a[i][j]);
            }
        }
        for (i = 0; i < n; i++) {
            minsr[i] = a[i][0];
            maxsr[i] = a[i][0];
            for (j = 1; j < n; j++) {
                if (a[i][j] < minsr[i]) {
                    minsr[i] = a[i][j];
                }
                if (a[i][j] > maxsr[i]) {
                    maxsr[i] = a[i][j];
                }
            }
        }
        for (j = 0; j < n; j++) {
            minst[j] = a[0][j];
            maxst[j] = a[0][j];
            for (i = 0; i < n; i++) {
                if (a[i][j] < minst[j]) {
                    minst[j] = a[i][j];
                }
                if (a[i][j] > maxst[j]) {
                    maxst[j] = a[i][j];
                }
            }
        }

            points = 0;
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (((a[i][j] == maxsr[i]) && (a[i][j] == minst[j])) || ((a[i][j] == maxst[j]) && (a[i][j] == minsr[i]))) {

                        System.out.println("\n"+"Седловая точка находится в [" + i + "][" + j + "]");
                        points++;
                    }
                }
            }
            if (points == 0) {
                System.out.println("\n"+"Таких точек нет");
            }


        }

}
