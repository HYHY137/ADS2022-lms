package by.it.group151051.voronko.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
В первой строке источника данных даны:
        - целое число 1<=n<=100000 (размер массива)
        - сам массив A[1...n] из n различных натуральных чисел,
          не превышающих 10E9, в порядке возрастания,
Во второй строке
        - целое число 1<=k<=10000 (сколько чисел нужно найти)
        - k натуральных чисел B[1...k] не превышающих 10E9 (сами числа)
Для каждого i от 1 до k необходимо вывести индекс 1<=j<=n,
для которого A[j]=B[i], или -1, если такого j нет.

        Sample Input:
        5 1 5 8 12 13
        5 8 1 23 1 11

        Sample Output:
        3 1 -1 1 -1

(!) Обратите внимание на смещение начала индекса массивов JAVA относительно условий задачи
*/

public class A_BinaryFind {
    int[] findIndex(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        //размер отсортированного массива
        int n = scanner.nextInt();
        //сам отсортированный массива
        int[] a=new int[n];
        for (int i = 1; i <= n; i++) {
            a[i-1] = scanner.nextInt();
        }

        //размер массива индексов
        int k = scanner.nextInt();
        int[] result=new int[k];
        for (int i = 0; i < k; i++) {
            int value = scanner.nextInt();
            //тут реализуйте бинарный поиск индекса
            int left = 0;
            int right = k-1;

            result[i] = 0;

            while (left <= right){
                int mid = (left + right)/2;
                if (a[mid] < value) left = mid + 1;
                else if (a[mid] > value) right = mid - 1;
                else {
                    result[i] = mid + 1;
                    break;
                }
                result[i] = -1;
            }
        }
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson04/dataA.txt");
        A_BinaryFind instance = new A_BinaryFind();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.findIndex(stream);
        //long finishTime = System.currentTimeMillis();
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}