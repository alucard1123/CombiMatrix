package com.pack;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: edward
 * Date: 1/15/13
 * Time: 10:34 PM
 */
public class main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String[][] arr = { { "test", "run", "mark"},
                { "A","B","C","D","E"},
                { "1", "5", "10" }};
        //fun(arr,arr.length-1);
        TestMethord tm = new Boundary();
        //String[][] haha = tm.BoundaryValues(1,arr);
        ConvertString cs = new SuperConvert();
        //cs.ConvertNumber(new String[]{"20-5"});
        String[][] test =  new String[][]{{"abc"}};
        tm = new Equivalence();
        tm.EquivalenceClass(false,test);

    }
    /* edward add in 2013.9.9
     * I note this to note myself the combine-matrixer is using an Iteration algorithm
     */
    public static void fun(String[][] arr,int index){
        //arr will be the style of {{a1,a2,a3},{b1,b2},{c1,c2,c3,c4,c5}}
        //for one time,do 2 of them,catch 1 using 'for' another using 'for in for'
        //String[][] reS = new String[arr[index].length][arr[index-1].length];
        String[] reS = new String[arr[index].length*arr[index-1].length];
        if(index-1<0){
            return;
        }
        for (int i=0;i<arr[index].length;i++){
            for(int j=0;j<arr[index-1].length;j++){
                //reS[i][j]=""+arr[index][i]+"--"+arr[index-1][j];
                reS[i*arr[index-1].length+j]=""+arr[index-1][j]+"--"+arr[index][i];
            }
            //System.out.print(arr[index][i]+"--");
        }
        fun(reS,index-2,arr);
    }
    public static void fun(String[] reS,int index,String[][] arr){
        if (index<0){
            for (int i=0;i<reS.length;i++){
                System.out.println(reS[i]);
            }
            System.out.println("match "+reS.length+" total.");
            return;
        }
        String[] reS2=new String[reS.length*arr[index].length];
        for(int i=0;i<arr[index].length;i++){
            for(int j=0;j<reS.length;j++){
                reS2[i*reS.length+j]=arr[index][i]+"--"+reS[j];
            }
        }/*
        for(int i=0;i<reS2.length;i++){
            System.out.println(reS2[i]+"**");
        }*/
        fun(reS2,index-1,arr);
    }
}
