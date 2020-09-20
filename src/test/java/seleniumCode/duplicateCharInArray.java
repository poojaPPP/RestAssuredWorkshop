package seleniumCode;
import java.util.HashMap;
import java.util.Map;

public class duplicateCharInArray {


    public static void main(String[] arg){

            String var="Happynewyear";
            Map<Character, Integer> map = new HashMap<>();
            char[] charArray = var.toCharArray();

            for(char chr : charArray){
                if(map.containsKey(chr)){
                    System.out.println(map.get(chr) +" map.get(char)");
                    map.put(chr, map.get(chr)+1);
                }
                else{
                    map.put(chr, 1);
                }

            }
            System.out.println("total map size ==> "+map.size());
            for (Map.Entry<Character, Integer> entry : map.entrySet()){
                if(entry.getValue() >1){
                    System.out.println(entry.getKey() + " values for keys "+ entry.getValue());
                }
            }
        }
    }

