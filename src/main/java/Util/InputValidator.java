package Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final int MAX_LENGTH = 255;
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{0," + MAX_LENGTH + "}$");

    public static boolean isValid(String input) {
        if (input == null || input.isEmpty()) {
            return false; // Trả về false nếu đầu vào rỗng
        }

        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
