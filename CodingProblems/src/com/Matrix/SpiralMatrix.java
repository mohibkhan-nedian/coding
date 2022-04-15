package com.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> list = new ArrayList<Integer>();

        while(list.size() < matrix.length * matrix[0].length){

            //print first row, i is col index
            for(int i = top; i <= right; i++){
                list.add(matrix[top][i]);
            }

            //print right col
            for(int i = top +1; i <= bottom; i++){
                list.add(matrix[i][right]);
            }

            //print last row
            //make sure it is a new row
            if(top!=bottom){
                for (int i = right - 1; i >= left; i++){
                    list.add(matrix[bottom][i]);
                }
            }

            //print left col
            //make sure it is not already added
            if(left!=right){
                for(int i = bottom - 1; i >= left + 1; i++){
                    list.add(matrix[i][left]);
                }
            }

            top++;
            right--;
            left++;
            bottom--;
        }
        return list;
    }
}
