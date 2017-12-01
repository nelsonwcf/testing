import java.io.*;
import java.util.*;

public class ArrayOfArrayProducts {

    static int[] arrayOfArrayProducts(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        int len = arr.length;
        int[] aux1 = new int[len];
        int previousRight = 1;

        aux1[0] = 1;
        for (int i = 1; i < len; i++) {
            aux1[i] = aux1[i - 1] * arr[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            previousRight *= arr[i + 1];
            aux1[i] *= previousRight;
        }

        return aux1;
    }

    public static void main(String[] args) {
        int[] x = {2, 7, 3, 4};

        for (int n : arrayOfArrayProducts(x))
            System.out.print(n + " ");

    }

}