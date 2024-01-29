package task1;

public class AuthChecker {
    private static void validateLogin(String login) {
        if (login.length() > 20) {
            throw new WrongLoginException("Login must be 20 symbols or shorter");
        }
    }
    private static void validatePassword(String password, String confirmPassword) {
        if (password.length() > 20) {
            throw new WrongLoginException("Password must be 20 symbols or shorter");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Passwords did not match");
        }
    }
    public static boolean validateCredentials(String login, String password, String confirmPassword) {
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
        } catch (WrongLoginException exception) {
            System.out.println(exception.getMessage());
            return false;
        } catch (WrongPasswordException exception) {
            if (exception.getMessage().equals("Passwords did not match")) {
                System.out.println("Check your password. Values didn't match.");
            }
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
