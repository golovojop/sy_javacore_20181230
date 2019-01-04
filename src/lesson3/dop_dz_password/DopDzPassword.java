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
         * При любом условии пароль слабый;
         *
         * .{0,7}               - вся строка менее 8 символов       (ИЛИ)
         * (?:.*\s+.*)          - присутствует хотя бы один пробел  (ИЛИ)
         * |[^0-9]+             - все символы не цифры              (ИЛИ)
         * [^A-Z]+              - нет строчных букв                 (ИЛИ)
         * [^a-z]+              - нет прописных букв                (ИЛИ)
         * [^#$^+=!*()@%&]+     - нет спецсиволов из списка
         */

        Pattern p = Pattern.compile("^(.{0,7}|(?:.*\\s+.*)|[^0-9]*|[^A-Z]*|[^a-z]*|[^#$^+=!*()@%&]*)$");
        Matcher m = p.matcher(pasword);

        if(m.matches()) throw new PasswordSyntaxException();
        return true;
    }

}
