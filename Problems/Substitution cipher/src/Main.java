import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Character, Character> mapEncode = new HashMap<>();
        HashMap<Character, Character> mapDecode = new HashMap<>();

        String keysLine = sc.nextLine();
        String valuesLine = sc.nextLine();

        for (int i = 0; i < keysLine.length(); i++) {
            Character key = keysLine.charAt(i);
            Character value = valuesLine.charAt(i);
            mapEncode.put(key, value);
            mapDecode.put(value, key);
        }

        String encode = sc.nextLine();
        String temp = "";
        String decode = sc.nextLine();
        for (int i = 0; i < encode.length(); i++) {
            temp += mapEncode.get(encode.charAt(i));
        }
        System.out.println(temp);
        temp = "";
        for (int i = 0; i < decode.length(); i++) {
            temp += mapDecode.get(decode.charAt(i));
        }
        System.out.println(temp);

    }
}