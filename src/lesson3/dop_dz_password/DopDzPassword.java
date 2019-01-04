package lesson3.dop_dz_password;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PasswordSyntaxException extends Exception { }


public class DopDzPassword {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Boolean isCorrect = false;
        String passwd;

        do {
            System.out.println("Type a password:\n");
            passwd = br.readLine();

            try {
                isCorrect = checkComplexity(passwd);
                System.out.println("Password OK");
            }
            catch (PasswordSyntaxException e) {
                System.out.println("Password Does Not Meet Requirements");
            }
        }
        while(!isCorrect);
    }

    static boolean checkComplexity(String pasword) throws PasswordSyntaxException {
        /**
         *
         * (?=.*[a-z]+?)            - хотя бы одна маленькая буква
         * (?=.*[A-Z]+?)            - хотя бы одна большая буква
         * (?=.*\d+?)               - хотя бы одна цифра
         * (?=.*[#$^+=!*()@%&]+?)   - хотя бы один спецзнак из набора
         * \\S{8,}                  - вся строка из 8-ми и более непробельных символов
         */
        Pattern p = Pattern.compile("^(?=.*[a-z]+?)(?=.*[A-Z]+?)(?=.*\\d+?)(?=.*[#$^+=!*()@%&]+?)\\S{8,}$");
        Matcher m = p.matcher(pasword);
        if(!m.matches()) throw new PasswordSyntaxException();
        return true;
    }
}
