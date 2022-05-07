import java.util.*;
import java.io.*;

public class HelloWorld
{
     public static void main(String []args)
     {
            StringIterations obj = new StringIterations();
 
            String str2 = "HELLO";
            System.out.println(obj.encode(str2, 5));
            // result: 
            
            String str1 = "BTWQI";
            System.out.println(obj.decode(str1, 5));
            // result: world
            
            String str3 = "IUHUR";
            System.out.println(obj.decode(str3, 6));
            // result: cobol
            
            String str4 = "innoWake rules";
            System.out.println(obj.encode(str4, 9));
            //result: rwwxFjtn adunb
     }
}

class StringIterations {
    String[] alphabet = {"a", "b", "c", "d","e", "f", "g", "h","i", "j", "k", "l","m", "n", "o", "p","q", "r", "s", "t","u", "v", "w", "x","y", "z"};
    List<String> alphaList = new ArrayList<>(Arrays.asList(alphabet));
    int alphaSize = alphaList.size();
    
    String encode(String str, int d) {
        return moveAround (str, d, "right");
    }
    
    String decode(String str, int d)
    {
        return moveAround (str, d, "left");
    }
    
    private String moveAround(String str, int d, String direction)
    {
            if (d < 0)
                return "";
            
            if (d == 0)
                return str;
            
            // TODO: how to handle more than 26 times
            
            String result = "";
            
            for (String element : str.split("")) {
                String elementLower = element.toLowerCase();
                if(alphaList.contains(elementLower)) {
                    int index = alphaList.indexOf(elementLower);
                    //System.out.println("index: " + index);
                    if (direction == "right") {
                        result = result + getIndexFromAlphabet(index + d);
                    }
                    if (direction == "left") {
                        result = result + getIndexFromAlphabet(index - d);
                    }
                }
                else {
                    // outside the alphabet
                    result = result + element;
                }
            }
            
            return result;
    }
    
    private String getIndexFromAlphabet(int index) {
        //System.out.println("start index: " + index);
        if (index >= alphaSize)
        {
            index = index - alphaSize;
        }
        else if (index < 0) { // why though
            index = alphaSize + index;
        }
        //System.out.println("end index: " + index);
        //System.out.println("----------");
        return alphaList.get(index);
    }
}