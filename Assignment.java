import java.util.ArrayList;
import java.util.HashMap;

public class Task {
    public static void main(String[] args) {
        ArrayList<Character> charArr = new ArrayList<>();
        for(char start = 'a'; start <= 'z' ;  start++){
            charArr.add(start);
        }
        HashMap<Character , Integer> charMap = new HashMap<>();
        for( int i = 0;  i < charArr.size() - 1; i++){
            for(int j = i+1; j<charArr.size(); j++ ){
                char key = (char) (charArr.get(i) & charArr.get(j));
                if(charMap.containsKey(key)){
                    charMap.put(key , charMap.get(key)+1 );
                } else {
                    charMap.put(key , 1 );
                }
            }
        }
        for( Character k: charMap.keySet() ){
            System.out.println(k + " - " + charMap.get(k));
        }
    }
}
