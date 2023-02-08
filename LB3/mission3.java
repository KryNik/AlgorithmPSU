import java.util.*;

public class mission3 {
    public static void main(String[] args) {
        System.out.println("Введите размер матриц:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix1 = new int[n][n];
        int[][] matrix2 = new int[n][n];

        mission1_2 rnd = new mission1_2();
        rnd.rand(n, matrix1, matrix2);
        output(n, matrix1, matrix2);

//----------------------- Задание 3

        int[][] matrix3 = new int[n][n];

        combineGraphs(n, matrix1, matrix2, matrix3);
        confluence(n, matrix1, matrix2, matrix3);
        annularSum(n, matrix1, matrix2, matrix3);
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

//---------------------------------------Задание 3
// №1 - Объединение графов

    public static void combineGraphs(int n, int[][] matrix1, int[][] matrix2, int[][] matrix3){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix1[i][j] == 1 | matrix2[i][j] == 1)
                    matrix3[i][j] = 1;
                else
                    matrix3[i][j] = 0;
            }
        }
        System.out.println("\nОбъединение графов:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
    }

// №2 - Пересечение графов

    public static void confluence(int n, int[][] matrix1, int[][] matrix2, int[][] matrix3){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix1[i][j] == 1 & matrix2[i][j] == 1)
                    matrix3[i][j] = 1;
                else
                    matrix3[i][j] = 0;
            }
        }
        System.out.println("\nПересечение графов:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
    }

// №3 - Кольцевая сумма графов

    public static void annularSum(int n, int[][] matrix1, int[][] matrix2, int[][] matrix3){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((matrix1[i][j] == 1 & matrix2[i][j] == 0) | (matrix1[i][j] == 0 & matrix2[i][j] == 1))
                    matrix3[i][j] = 1;
                else
                    matrix3[i][j] = 0;
            }
        }
        System.out.println("\nКольцевая сумма графов:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
