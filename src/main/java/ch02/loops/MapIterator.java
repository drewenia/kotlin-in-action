package ch02.loops;

import java.util.HashMap;
import java.util.Map;

public class MapIterator {
    public static void main(String[] args) {
        Map<Character, String> binaryMap = new HashMap<>();
        for (char c = 'A'; c <= 'F'; c++) {
            String binaryString = Integer.toBinaryString(c);
            binaryMap.put(c,binaryString);
        }

        for (Map.Entry<Character,String> map : binaryMap.entrySet()){
            System.out.print(map.getKey() + ":");
            System.out.print(map.getValue() + "\n");
        }

        binaryMap.forEach((k,v)-> System.out.println(k + ":" + v));

    }
}
