package task0502.model;

import task0502.utils.Helper;

import java.util.HashMap;

public class Translator {

    private HashMap<String, String> dictionary = new HashMap<>();

    public Translator() {
        dictionary.put("i", "я");
        dictionary.put("see", "видеть");
        dictionary.put("dead", "мертвый");
        dictionary.put("people", "люди");
    }

    public void addPairOfWords() {

        String rusWord = getRusWord();
        String engWord = getEngWord();

        dictionary.put(engWord.toLowerCase(), rusWord.toLowerCase());
    }

    private String getRusWord() {
        System.out.println("Enter russian word");

        return Helper.requestWord("[\u0430-\u044f \u0410-\u042f]+");
    }

    private String getEngWord() {
        System.out.println("Enter english word");

        return Helper.requestWord("[a-z A-Z]+");
    }


    public String translateEngToRus(String string) {

        String[] words = string.split(" ");

        StringBuilder sb = new StringBuilder();

        for(String str : words) {
            sb.append(getFromDictionary(str)).append(" ");
        }

        return sb.toString().trim();
    }

    private String getFromDictionary(String word) {
        String result = dictionary.get(word.toLowerCase());

        return result != null ? result : "UNKNOWN";
    }
}
