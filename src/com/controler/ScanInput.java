package controler;

import com.stack.Stack;

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
        SolveTranslation();
        SolveNot();
    }

    private void SolveTranslation() {

        Pattern pt = Pattern.compile("\\[(.*?)\\]");
        Matcher ma = pt.matcher(Input);
       if(ma.find()) {
            if(ma.groupCount()>0){
                System.out.println(ma.group(1));
            }
        }

    }
    private void SolveAnd(){

    }

    private void SolveNot() {
        for (int i = 0; i < Input.length(); i++) {
            if (Input.charAt(i) == '!') {

            }
        }
    }
    public String GetInput(){
        return this.output;
    }
}
