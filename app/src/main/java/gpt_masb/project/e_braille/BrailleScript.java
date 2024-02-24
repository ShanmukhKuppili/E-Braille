package gpt_masb.project.e_braille;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BrailleScript {

    public Map<Character, int[]> getAlphabetsMap() {   //Return the map of braille characters for alphabets
        ArrayList<Character> charList = new ArrayList<>();
        Map<Character, int[]> hashMap = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            charList.add(c);
        }

        int[] aArray = {1,0,0,0,0,0};
        int[] bArray = {1,1,0,0,0,0};
        int[] cArray = {1,0,0,1,0,0};
        int[] dArray = {1,0,0,1,1,0};
        int[] eArray = {1,0,0,0,1,0};
        int[] fArray = {1,1,0,1,0,0};
        int[] gArray = {1,1,0,1,1,0};
        int[] hArray = {1,1,0,0,1,0};
        int[] iArray = {0,1,0,1,0,0};
        int[] jArray = {0,1,0,1,1,0};
        int[] kArray = {1,0,1,0,0,0};
        int[] lArray = {1,1,1,0,0,0};
        int[] mArray = {1,0,1,1,0,0};
        int[] nArray = {1,0,1,1,1,0};
        int[] oArray = {1,0,1,0,1,0};
        int[] pArray = {1,1,1,1,0,0};
        int[] qArray = {1,1,1,1,1,0};
        int[] rArray = {1,1,1,0,1,0};
        int[] sArray = {0,1,1,1,0,0};
        int[] tArray = {0,1,1,1,1,0};
        int[] uArray = {1,0,1,0,0,1};
        int[] vArray = {1,1,1,0,0,1};
        int[] wArray = {0,1,0,1,1,1};
        int[] xArray = {1,0,1,1,0,1};
        int[] yArray = {1,0,1,1,1,1};
        int[] zArray = {1,0,1,0,1,1};

        hashMap.put(charList.get(0), aArray);
        hashMap.put(charList.get(1), bArray);
        hashMap.put(charList.get(2), cArray);
        hashMap.put(charList.get(3), dArray);
        hashMap.put(charList.get(4), eArray);
        hashMap.put(charList.get(5), fArray);
        hashMap.put(charList.get(6), gArray);
        hashMap.put(charList.get(7), hArray);
        hashMap.put(charList.get(8), iArray);
        hashMap.put(charList.get(9), jArray);
        hashMap.put(charList.get(10), kArray);
        hashMap.put(charList.get(11), lArray);
        hashMap.put(charList.get(12), mArray);
        hashMap.put(charList.get(13), nArray);
        hashMap.put(charList.get(14), oArray);
        hashMap.put(charList.get(15), pArray);
        hashMap.put(charList.get(16), qArray);
        hashMap.put(charList.get(17), rArray);
        hashMap.put(charList.get(18), sArray);
        hashMap.put(charList.get(19), tArray);
        hashMap.put(charList.get(20), uArray);
        hashMap.put(charList.get(21), vArray);
        hashMap.put(charList.get(22), wArray);
        hashMap.put(charList.get(23), xArray);
        hashMap.put(charList.get(24), yArray);
        hashMap.put(charList.get(25), zArray);

        return hashMap;
    }

    public Map<Character, int[]> getNumbersMap() {   //Return the map of braille characters for alphabets
        Map<Character, int[]> hashMap = new HashMap<>();


        int[] oneArray = {1,0,0,0,0,0};
        int[] twoArray = {1,1,0,0,0,0};
        int[] threeArray = {1,0,0,1,0,0};
        int[] fourArray = {1,0,0,1,1,0};
        int[] fiveArray = {1,0,0,0,1,0};
        int[] sixArray = {1,1,0,1,0,0};
        int[] sevenArray = {1,1,0,1,1,0};
        int[] eightArray = {1,1,0,0,1,0};
        int[] nineArray = {0,1,0,1,0,0};
        int[] zeroArray = {0,1,0,1,1,0};

        hashMap.put('1', oneArray);
        hashMap.put('2', twoArray);
        hashMap.put('3', threeArray);
        hashMap.put('4', fourArray);
        hashMap.put('5', fiveArray);
        hashMap.put('6', sixArray);
        hashMap.put('7', sevenArray);
        hashMap.put('8', eightArray);
        hashMap.put('9', nineArray);
        hashMap.put('0', zeroArray);

        return hashMap;
    }

    public <K, V> K getKeyByValue(Map<K, V> map, V value) {   //Return the value of key for braille character
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (Arrays.equals((int[])entry.getValue(),(int[]) value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
