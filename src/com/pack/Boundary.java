package com.pack;

/**
 * Created with IntelliJ IDEA.
 * User: edward
 * Date: 9/9/13
 * Time: 10:55 AM
 * Function : a Class contains algorithms of calculating Boundary values.
 */
public class Boundary extends SuperMethord implements TestMethord  {
    private String[][] getedString;
    private int BoundaryWidth;
    public Boundary(){
        this.getedString = null;
        BoundaryWidth=0;
    }
    private void setString(String[][] tgtString){
        if(tgtString!=null){
            this.getedString=tgtString;
        }
        else{
            System.out.println("Error: In Boundary,set String fail,String is empty");
        }
    }
    private void setBoundaryWidth(int width){
        this.BoundaryWidth=width;
    }
    private int[] getStringSize(){
        if(getedString!=null){
            int Lines = getedString.length;
            int[] StringSize = new int[Lines];
            for(int i=0;i<Lines;i++){
                StringSize[i] = getedString[i].length;
            }
            return StringSize;
        }
        else{
            System.out.println("Error: In Boundary,set String size fail ,String is empty");
            return null;
        }
    }
    private void SetBoundValues(){
        int[] StringLocation = getStringSize();
        if(getedString!=null){
            int Lines = getedString.length;
            for (int i=0;i<Lines;i++){
                if (BoundaryWidth*2>=getedString[i].length){}
                else{
                    String[] cache = new String[BoundaryWidth*2];
                    for (int j=0;j<BoundaryWidth;j++){
                        cache[j] = getedString[i][j];
                        cache[cache.length-j-1]= getedString[i][StringLocation[i]-1-j];
                    }
                    getedString[i]=cache;
                }
            }
        }

    }
    @Override
    public String[][] BoundaryValues(int width,String[][] inputString){
        setBoundaryWidth(width);
        setString(inputString);
        SetBoundValues();
        return getedString;
    }


}
