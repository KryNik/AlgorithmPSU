import java.util.*;

public class mission1_2 {

    public static void main(String[] args) {
        System.out.println("Введите размер матриц:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix1 = new int[n][n];
        int[][] matrix2 = new int[n][n];
        int[][] matrix3 = new int[n + 1][n + 1];
        int[][] matrix4 = new int[n + 1][n + 1];
        int[][] copymatrix1 = new int[n][n];
        int[][] copymatrix2 = new int[n][n];
        ArrayList<LinkedList<Integer>> adjLists1 = new ArrayList<LinkedList<Integer>>();
        ArrayList<LinkedList<Integer>> adjLists2 = new ArrayList<LinkedList<Integer>>();

        rand(n, matrix1, matrix2);
        addEdge(n, matrix1, matrix2, adjLists1, adjLists2);
        output(n, matrix1, matrix2, adjLists1, adjLists2);

//---------------------------------------Задание 2

        System.out.println("\n\n№1\na) Отождествление вершин");
        System.out.print("\nПервая вершина: ");
        Scanner in1 = new Scanner(System.in);
        int vertex1 = in1.nextInt() - 1;
        System.out.print("Вторая вершина: ");
        Scanner in2 = new Scanner(System.in);
        int vertex2 = in2.nextInt() - 1;

// №1

        for (int i = 0; i < matrix1.length; i++)
            for (int j = 0; j < matrix1[i].length; j++) {
                copymatrix1[i][j] = matrix1[i][j];
                copymatrix2[i][j] = matrix2[i][j];
            }
        identification(n, vertex1, vertex2, copymatrix1, copymatrix2);
        constriction(n, vertex1, vertex2, copymatrix1, copymatrix2, matrix1, matrix2);
        for (int i = 0; i < matrix1.length; i++)
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix3[i][j] = matrix1[i][j];
                matrix4[i][j] = matrix2[i][j];
            }
        separation(matrix3, matrix4);

// №2


    }

    public static void rand(int n, int[][] matrix1, int[][] matrix2) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix1[i][j] = (int) ((Math.random() * 2) + 0);
                matrix1[j][i] = matrix1[i][j];
                matrix2[i][j] = (int) ((Math.random() * 2) + 0);
                matrix2[j][i] = matrix2[i][j];

                if (i == j) {
                    matrix1[i][j] = 0;
                    matrix2[i][j] = 0;
                }
            }
        }
    }

    public static void addEdge(int n, int[][] matrix1, int[][] matrix2, ArrayList<LinkedList<Integer>> adjLists1, ArrayList<LinkedList<Integer>> adjLists2) {
        for (int i = 0; i < n; i++)
            adjLists1.add(new LinkedList<Integer>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix1[i][j] == 1)
                    adjLists1.get(i).add(j + 1);
            }
        }


        for (int i = 0; i < n; i++)
            adjLists2.add(new LinkedList<Integer>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix2[i][j] == 1)
                    adjLists2.get(i).add(j + 1);
            }
        }
    }

    public static void output(int n, int[][] matrix1, int[][] matrix2, ArrayList<LinkedList<Integer>> adjLists1, ArrayList<LinkedList<Integer>> adjLists2) {
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
        System.out.println("\nПервый список:");
        System.out.println(adjLists1);
        System.out.println("\nВторой список:");
        System.out.println(adjLists2);
    }

//---------------------------------------Задание 2
// №1 - Отождествление вершин

    public static void identification(int n, int vertex1, int vertex2, int[][] matrix1, int[][] matrix2) {
        int max;
        int min;
        int[] matrix3 = new int[n];
        int[] matrix4 = new int[n];

        if (vertex1 > vertex2) {
            max = vertex1;
            min = vertex2;
        } else {
            max = vertex2;
            min = vertex1;
        }

        for (int i = 0; i < n; i++) {
            matrix3[i] = matrix1[min][i] + matrix1[max][i];
            matrix4[i] = matrix2[min][i] + matrix2[max][i];
            if (matrix3[i] == 2)
                matrix3[i] = 1;
            if (matrix4[i] == 2)
                matrix4[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            matrix1[min][i] = matrix3[i];
            matrix1[i][min] = matrix3[i];
            matrix2[min][i] = matrix4[i];
            matrix2[i][min] = matrix4[i];
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i >= max) {
                    matrix1[i][j] = matrix1[i + 1][j];
                    matrix2[i][j] = matrix2[i + 1][j];
                } else if (j >= max) {
                    matrix1[i][j] = matrix1[i][j + 1];
                    matrix2[i][j] = matrix2[i][j + 1];
                }
                if (i >= max & j >= max) {
                    matrix1[i][j] = matrix1[i + 1][j + 1];
                    matrix2[i][j] = matrix2[i + 1][j + 1];
                }
            }
        }

        System.out.println("\nМатрица 1:\n");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nМатрица 2:\n");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
    }

// №1 - Стягивание ребра

    public static void constriction(int n, int vertex1, int vertex2, int[][] copymatrix1, int[][] copymatrix2, int[][] matrix1, int[][] matrix2) {
        System.out.println("\n\n№1\nб) Стягивание ребра");
        if (matrix1[vertex1][vertex2] != 1 & matrix2[vertex1][vertex2] != 1) {
            System.out.println("\nВыберите другие вершины, эти не связанные\n");
            return;
        }

        if (matrix1[vertex1][vertex2] == 1) {
            System.out.println("\nМатрица 1:\n");
            for (int i = 0; i < copymatrix1.length - 1; i++) {
                for (int j = 0; j < copymatrix1.length - 1; j++) {
                    if (i == j) {
                        copymatrix1[i][j] = 0;
                    }
                    System.out.print(copymatrix1[i][j] + " ");
                }
                System.out.println();
            }
        }

        if (matrix2[vertex1][vertex2] == 1) {
            System.out.println("\nМатрица 2:\n");
            for (int i = 0; i < copymatrix2.length - 1; i++) {
                for (int j = 0; j < copymatrix2.length - 1; j++) {
                    if (i == j) {
                        copymatrix2[i][j] = 0;
                    }
                    System.out.print(copymatrix2[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

// №1 - Расщепление вершины

    public static void separation(int[][] matrix1, int[][] matrix2){

        System.out.println("\n\n№1\nв) Расщепление вершины");
        System.out.print("\nРасщепить вершину под номером: ");
        Scanner in1 = new Scanner(System.in);
        int vertex3 = in1.nextInt() - 1;

        for (int i = 0; i < matrix1.length - 1; i++) {
            matrix1[i][matrix1.length - 1] = matrix1[i][vertex3];
            matrix2[i][matrix2.length - 1] = matrix2[i][vertex3];
        }
        matrix1[vertex3][matrix1.length - 1] = matrix1[matrix1.length - 1][vertex3] = 1;
        matrix1[matrix1.length - 1][matrix1.length - 1] = 0;
        matrix2[vertex3][matrix2.length - 1] = matrix2[matrix2.length - 1][vertex3] = 1;
        matrix2[matrix2.length - 1][matrix2.length - 1] = 0;

        System.out.println("\nМатрица 1:\n");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nМатрица 2:\n");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
    }
}