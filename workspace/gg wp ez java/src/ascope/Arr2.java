package ascope;

public class Arr2 {
    public static void main(String args[]) {
        //int n = (int) (Math.random() * 10);
        int n =2;
        int p = 0;
         int arr[][] = new int[n][n];

        for (int i = 0; i < arr.length; i++) {

            System.out.println(" ");
            for (int j = 0; j < arr.length; j++){
                arr[0][j] = 1;
               arr[arr.length-1][j] = 1;

                   for( int k = p;k < arr.length-p ;k++ ){
                       p++;
                       for (int l = p-1 ; l<arr.length-p+1; l++){
                           arr[k][l] = 1;
                           arr[arr.length-p][l]=1;

                       }
                   }
                System.out.print(arr[i][j]);
            }
        }
    }
}