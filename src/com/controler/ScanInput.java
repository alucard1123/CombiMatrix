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
    private String[] output;
    Stack stack = new Stack(20);
    String[] Undone = new String[20];

    public ScanInput(String input) {
        this.Input = input;
        //SolveCondition();
        //SolveAnd();
        SolveTranslation();
        SolveNot();
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
        Pattern pt = Pattern.compile("(?<!\")!\\[(.*?)\\](?<!\")");
        //Pattern pt = Pattern.compile("\\(char\\)\\d{1,}");
        Matcher ma = pt.matcher(Input);
        //find conditions with NOT
        while (ma.find()){
            String FindedStr = ma.group(1);
            //get (char)
            Pattern pt1 = Pattern.compile("\\(char\\)");
            Matcher ma1 = pt1.matcher(FindedStr);
            while (ma1.find()){
                String Finded = ma.group();
                System.out.println(Finded);
                String[] test = Finded.split("\\(char\\)");
                System.out.println(test[1]);
            }
            /*
            pt = Pattern.compile("(?<!\\()char(?<!\\))\\d");
            ma = pt.matcher(Input);
            while (ma.find()){
                System.out.println(ma.group());
            }
            */
        }

    }
    // translate \" into phrase
    private void SolveTranslation(){

        int Cursor=0;
        Pattern pt = Pattern.compile("\"(.*?)\"");
        Matcher matcher = pt.matcher(Input);
        while(matcher.find()){
            this.Undone[Cursor++] = matcher.group();
            //System.out.println(Undone[Cursor-1]);
        }
        Input = matcher.replaceAll("CCC");
    }
    public String[] GetInput(){
        return this.output;
    }
    
}
