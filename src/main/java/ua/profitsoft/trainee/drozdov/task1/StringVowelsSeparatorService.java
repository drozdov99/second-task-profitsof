package ua.profitsoft.trainee.drozdov.task1;

import java.util.Arrays;
import java.util.List;

public class StringVowelsSeparatorService {

    private final List<String> vowels = Arrays.asList("e", "y", "u", "i", "o", "a");

    private static StringVowelsSeparatorService instance;

    private StringVowelsSeparatorService() {
    }

    public static StringVowelsSeparatorService getInstance() {
        if (instance == null) {
            instance = new StringVowelsSeparatorService();
        }
        return instance;
    }


    /**
     * @param line
     * @return line with separated vowels
     */
    public String interviewRecursionTest(String line) {
        if (line.length() == 0) {
            return line;
        }
        line = line.trim();

        String currentChar = String.valueOf(line.charAt(0));
        if((line.charAt(0) < 'a' || line.charAt(0) > 'z') && (line.charAt(0) < 'A' || line.charAt(0) > 'Z')){
            throw new IllegalArgumentException();
        }
        if (vowels.contains(currentChar.toLowerCase()) || (line.length() > 1 && vowels.contains(String.valueOf(line.charAt(1)).toLowerCase()))) {
                currentChar = currentChar + (line.length() > 1 ? "*" : "");
        }

        return currentChar + interviewRecursionTest(line.substring(1));
    }

}
