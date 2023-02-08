import java.util.*;

public class mission4 {
    public static void main(String[] args) {
        System.out.println("Введите размер матриц:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix1 = new int[n][n];
        int[][] matrix2 = new int[n][n];

        mission1_2 rnd = new mission1_2();
        rnd.rand(n, matrix1, matrix2);
        output(n, matrix1, matrix2);

//----------------------- Задание 4

        int[][] matrix3 = new int[n*n][n*n];

        Decart(n, matrix1, matrix2, matrix3);
    }

    public static void output(int n, int[][] matrix1, int[][] matrix2) {
        System.out.println("\nМатрица 1:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nМатрица 2:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
    }

//---------------------------------------Задание 4
// №1 - Декартово произведение графов

    public static void Decart(int n, int[][] matrix1, int[][] matrix2, int[][] matrix3){
        int count = -1;
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                count += 1;
                int number = 0;
                for ( int ii = 0; ii < matrix1.length; ii++){
                    for (int jj = 0; jj < matrix2.length; jj++){
                        if(i == jj & j == ii)
                            matrix3[count][number] = 0;
                        else if(i == ii)
                            matrix3[count][number] = matrix2[j][jj];
                        else if (j == jj)
                            matrix3[count][number] = matrix1[i][ii];
                        else
                            matrix3[count][number] = 0;
                        number += 1;
                    }
                }
            }
        }
        System.out.println("\nДекартово произведение матриц №1 и №2:\n");
        for (int i = 0; i < n*n; i++) {
            for (int j = 0; j < n*n; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
    }
}