package com.controler;

import com.stack.Stack;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: edward
 * Date: 11/12/13
 * Time: 2:20 PM
 */
public class ScanInput {

    private String Input;
    private String output;
    Stack stack = new Stack(20);

    public ScanInput(String input) {
        this.Input = input;
        //SolveCondition();
        //SolveNot();
        //SolveAnd();
        SovlveTranslation();
    }

    private void SolveCondition() {
        //positive way (?<!")\[(.*?)\](?<!")
        //negative way (?<!")!\[(.*?)\](?<!")
        //using this positive way:
        Pattern pt = Pattern.compile("(?<!\")\\[(.*?)\\](?<!\")");
        //another greedy matching will be \[([^}]+)\]
        Matcher ma = pt.matcher(Input);
       while(ma.find()) {
            if(ma.groupCount()>0){
                System.out.println(ma.group(1));
            }
        }

    }
    private void SolveAnd(){
        Pattern pt = Pattern.compile("and");
        String[] testStr = pt.split(Input);
        for(int i=0;i<testStr.length;i++){
            this.Input = testStr[i];
            System.out.println("Translation:"+testStr[i]);
            SolveCondition();
        }
        //System.out.println(Arrays.toString(testStr));

    }
    private void MoveNot(){

    }
    private void SolveNot() {

    }
    // translate \" into phrase
    private void SovlveTranslation(){
        String[] Undone = new String[20];
        int Cursor=0;
        Pattern pt = Pattern.compile("\"(.*?)\"");
        Matcher matcher = pt.matcher(Input);
        while(matcher.find()){
            Undone[Cursor++] = matcher.group(1);
            System.out.println(Undone[Cursor]);
            matcher.replaceAll("CCC");

        }
        System.out.println(Input);

    }
    public String GetInput(){
        return this.output;
    }
}
