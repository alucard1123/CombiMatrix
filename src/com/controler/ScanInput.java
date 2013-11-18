package com.controler;

import com.stack.Stack;

import java.util.Arrays;
import java.util.Random;
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
            System.out.println(FindedStr);
            //get (char) ----------------------------------
            Pattern pt1 = Pattern.compile("\\(char\\)\\d{1,}");
            //String[] test = pt1.split(FindedStr);
            //System.out.println(Arrays.toString(test));

            Matcher ma1 = pt1.matcher(FindedStr);
            while (ma1.find()){
                String Finded = ma1.group();
                //System.out.println(Finded);
                String[] FoundBar = Finded.split("\\(char\\)");
                //System.out.println(FoundBar[1]);
                //check if FoundBar has value
                if(!FoundBar[1].isEmpty()){
                    //set circle

                }else {
                    System.out.println("ERROR:\n" +
                            "WRONG FORMANT:you probably forget add number after '(char)'");
                    System.exit(100);
                }
            }


            //----------------------------------------------
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
    // Rand not char
    private String _RandChar(int count){
        String ReturnStr = null;
        Random random = new Random();
        int mark =0;
        for (int i =0;i<count;i++){
            mark = random.nextInt(2);
            switch (mark){
                //rand a number
                case 0:
                    mark = random.nextInt(9)+48;

                    break;
            }

        }
        return null;
    }
    public String[] GetInput(){
        return this.output;
    }

}
