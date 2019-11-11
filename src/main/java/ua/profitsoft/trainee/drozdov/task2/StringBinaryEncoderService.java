package ua.profitsoft.trainee.drozdov.task2;

public class StringBinaryEncoderService {

    private StringBinaryEncoderService() {
    }

    private static StringBinaryEncoderService instance;

    public static StringBinaryEncoderService getInstance() {
        if (instance == null) {
            instance = new StringBinaryEncoderService();
        }
        return instance;
    }

    /**
     * @param line
     * @return encoded message
     */
    public String encodeMessage(String line) {
        if (line.length() == 0) {
            return line;
        }
        if(line.length()>100) {
            throw new IllegalArgumentException();
        }

        line = line.trim();

        StringBuilder result = new StringBuilder();

        char[] charArray = line.toCharArray();

        for (char character : charArray) {

            String binaryChar = charToFullBinaryString(character);
            char prevChar = binaryChar.charAt(0);

            for (int i = 0; i < binaryChar.length(); i++) {
                char currentChar = binaryChar.charAt(i);
                if (currentChar == prevChar && i > 0) {
                    result.append('0');
                } else {
                    if (currentChar == '0') {
                        result.append(" 00 0");
                    }
                    if (currentChar == '1') {
                        result.append(" 0 0");
                    }
                    prevChar = currentChar;
                }
            }
        }
        return result.toString().trim();
    }

    /**
     * Adding extra zeros if it need
     * Integer.toBinaryString(char c) returns a string representation without extra zeros in the beginning
     * @param character
     * @return Binary String representation with extra zeros
     */
    private String charToFullBinaryString(char character){
        return String.format("%8s", Integer.toBinaryString(character)).replace(' ', '0');

    }


}
