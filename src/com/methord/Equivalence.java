package com.methord;

import java.util.Random;

/**
 * User: edward
 * Date: 9/9/13
 * Time: 3:08 PM
 */
public class Equivalence extends SuperMethord implements TestMethord {
    private String[][] getedString;
    private boolean generFalse;
    private static Random rd = new Random();
    private ConvertString cs = new SuperConvert();
    private static String[] specialMark = new String[]{"*", "&", "%", "?", "@"};

    public Equivalence() {
        this.getedString = null;
        this.generFalse = false;
    }

    public void setGetedString(String[][] tgtString) {
        this.getedString = tgtString;
    }

    @Override
    public String[][] EquivalenceClass(boolean generateFalseClass, String[][] inputString) {
        setGenFalseClass(generateFalseClass);
        setGetedString(inputString);
        int equival = -1;
        for (int i = 0; i < inputString.length; i++) {
            equival = setEquivalType(inputString[i]);
            if (!(equival < 0)) {
                setEquival(equival);
            }
            /*
            for(int j=0;j<getedString[i].length;j++){
                System.out.println("showing: "+getedString[i][j]);
            }
            */

        }

        return null;
    }

    private void setGenFalseClass(boolean GFC) {
        this.generFalse = GFC;
    }

    /*
    dictionary of typeMark
    1 :interval
    2:focus in 1
    3:enumerate
     */
    private int setEquivalType(String[] income) {
        int typeMark = -1;
        switch (income.length) {
            case 0:
                System.out.println("empty String");
                break;
            case 1:
                //check if is interval
                if (cs.checkIsInterval(income[0])) {
                    typeMark = 1;
                }
                //set it to focus 1
                else {
                    typeMark = 2;
                }
                break;
            default:
                //set to enumerate
                typeMark = 3;
        }
        return typeMark;
    }

    private void setEquival(int type) {
        for (int i = 0; i < getedString.length; i++) {
            switch (setEquivalType(getedString[i])) {
                case 1:
                    getedString[i] = setIntervalValue(generFalse, getedString[i]);
                    break;
                case 2:
                    getedString[i] = setFocusValue(generFalse, getedString[i]);
                    break;
            }
        }
    }

    //interval solution
    private String[] setIntervalValue(boolean gener, String[] income) {
        String[] buff = cs.ConvertNumber(income);
        //here if gener is false ,we just generate ONLY false cases
        if (!gener) {
            int[] values = new int[5];
            int headMember = Integer.parseInt(buff[0]);
            int tailMember = Integer.parseInt(buff[buff.length - 1]);
            if (headMember > tailMember) {
                values[0] = headMember + 1;
                values[1] = tailMember - 1;
                values[2] = headMember + rd.nextInt(10);
                values[3] = tailMember - rd.nextInt(10);
            } else {
                values[0] = headMember - 1;
                values[1] = tailMember + 1;
                values[2] = headMember - rd.nextInt(10);
                values[3] = tailMember + rd.nextInt(10);
            }
            values[4] = Integer.parseInt(buff[(rd.nextInt(buff.length) - 1)]);
            income = new String[5];
            for (int counter = 0; counter < 5; counter++) {
                income[counter] = values[counter] + "";
            }
        } else {
            int elementNum = 2;
            if ((buff.length / 4) == 0) {
                elementNum = 2;
            } else if ((buff.length / 4) > 1) {
                elementNum = (buff.length / 4);
            }
            String[] values = new String[elementNum];
            for (int ii = 0; ii < values.length; ii++) {
                values[ii] = buff[(new Random().nextInt(elementNum))];
            }
            income = values;
        }
        return income;
    }

    //focus in 1 solution
    private String[] setFocusValue(boolean gener, String[] income) {
        String outCome = "";
        if (income.length != 1) {
            System.out.println("it's not a focus type!!");
        }
        if (!gener) { //generation false classes
            //use number-mark litter-number mixer
            if (cs.isNumber(income[0])) {
                for (int i = 0; i < income[0].length(); i++) {
                    outCome = (char) ((int) (income[0].charAt(i)) - 15) + outCome;
                }
            } else {
                System.out.println("wuygDebug:run here");
                int cricleMark = 0;
                for (int i = 0; i < income[0].length(); i++) {
                    if (cricleMark < 10) {
                        outCome = cricleMark + outCome;
                        cricleMark += 1;
                    } else {
                        cricleMark = 0;
                    }
                }
            }
        } else {
            outCome = income[0];
        }
        String[] OutCome = new String[]{outCome};
        return OutCome;
    }

    // enumerate
    private String[] setEnumerateValue(boolean gener, String[] income) {
        String[] outCome = null;
        if (!gener) {

        }
        return null;
    }


}
