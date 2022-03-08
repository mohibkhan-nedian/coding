package com.Graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {

    // Also River Size of algo exp

    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0 ; j < matrix[i].length; j++) {
                if(matrix[i][j] == 1){
                    //go left right up and down
                    list.add(getRiverSize(matrix, i , j));

                }
            }
        }
        return list;
    }

    static int getRiverSize(int[][] matrix, int i, int j) {
        if(i < 0 || i == matrix.length || j < 0 || j == matrix[i].length)
            return 0;

        if(matrix[i][j] == 0) return 0;

        matrix[i][j] = 0;

        int size = 1;

        int[] k = {0 , 0, -1 , 1};
        int[] f = {-1 , 1, 0 , 0};

        for(int q = 0 ; q < 4; q++){
            size += getRiverSize(matrix, i + k[q], j+ f[q]);
        }
        return size;
    }
}
