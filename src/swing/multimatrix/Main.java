package swing.multimatrix;

import java.util.Random;
import java.util.Scanner;

public class Main {
    // Найти произведение двух матриц
    static int startNumber;
    static int endNumber;
    static int row1;
    static int row2;
    static int colum1;
    static int colum2;

    static Scanner scn = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {
        
        System.out.println("Введите начало диапазона заполнения: ");
        startNumber = scn.nextInt();
        System.out.println("Введите конец диапазона заполнения: ");
        endNumber = scn.nextInt();
        System.out.println("Введите количесвто строк в первой матрице: ");
        row1 = scn.nextInt();
        System.out.println("Введите количесвто столбцов первой матрице: ");
        colum1 = scn.nextInt();
        System.out.println("Введите количесвто строк второй матрице: ");
        row2 = scn.nextInt();
        System.out.println("Введите количесвто столбцов второй матрице: ");
        colum2 = scn.nextInt();

        int[][] matrix1 = new int [row1][colum1];
        int[][] matrix2 = new int [row2][colum2];

        if(row1 != colum2 || row2 != colum1){
            System.out.println("Заданные матрицы нельзя перемножить");
            return;
        }
        FillArray(matrix1, startNumber, endNumber);
        FillArray(matrix2, startNumber, endNumber);
        System.out.println("Первая матрица: ");
        PrintArray(matrix1);
        System.out.println("Вторая матрица");
        PrintArray(matrix2);
        System.out.println("Результат перемножения двух матриц: ");
        PrintArray(MultiMatrix(matrix1, matrix2));
        System.out.println("Сумма двух матриц: ");
        PrintArray(SumMatrix(matrix1, matrix2));

    }
    static void FillArray(int[][] arr, int start, int end){

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j <arr[i].length; j++){
                arr[i][j] = rnd.nextInt(start, end);
            }
        }
    }

    static void PrintArray(int[][] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static  int[][] MultiMatrix(int[][] arr1, int[][] arr2){

        int[][] m = new int[row1][colum1];
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2[i].length; j++){
                for(int k = 0; k < arr2.length; k++){
                    m[i][k] = m[i][k] + arr1[i][j] * arr2[j][k];
                }
            }
        }
        return m;
    }

    static int[][] SumMatrix(int[][] arr1, int[][] arr2){

        int[][] a = new int[row1][colum1];
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[i].length; j++){
                a[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return a;
    }
}
