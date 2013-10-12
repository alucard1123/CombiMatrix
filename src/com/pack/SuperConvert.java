package com.pack;

import java.util.regex.Pattern;

/**
 * User: edward
 * Date: 9/10/13
 * Time: 10:44 PM
 */
public class SuperConvert implements ConvertString {

    public SuperConvert(){
    }
    @Override
    public boolean isNumber(String income){
        boolean isnumber = false;
        Pattern pt = Pattern.compile("[0-9]*");
        if(pt.matcher(income).matches()){
            isnumber = true;
        }
        if(income.isEmpty()){
            isnumber = false;
        }
        return isnumber;
    }
    @Override
    public String[] ConvertNumber(String[] incomeString){
        String NumberInterval =  incomeString[0];
        String[] htArray=NumberInterval.split("-");
        try{
            int start,end;
            start = Integer.parseInt(htArray[0]);
            end = Integer.parseInt(htArray[1]);
            int ArrayWidth = StrictMath.abs(start-end)+1;
            String[] settedArray = new String[ArrayWidth];
            if(ArrayWidth==0){
                settedArray = new String[]{htArray[0]};
            }
            else if(start > end){
                for(int i=0;i<ArrayWidth;i++){
                    settedArray[i]=""+(start-i);
                }
            }
            else if(end > start){
                for(int i=0;i<ArrayWidth;i++){
                    settedArray[i]=""+(start+i);
                }
            }
            return settedArray;
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public boolean checkIsInterval(String checkedStr){
        boolean returnMark=false;
        String[] spliter = checkedStr.split("-");
        if(spliter.length==2){
            if(isNumber(spliter[0])&&isNumber(spliter[1])){
                returnMark=true;
            }
        }
        return returnMark;
    }
    public int switchEqualType(String income){

        return -1;
    }
}
