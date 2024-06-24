public class UserInputValidator {

    public static void validateInput(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        if (login.length() > 20 || !login.matches("[A-Za-z0-9_]+")) {
            throw new WrongLoginException("Логин неверен: он должен содержать до 20 символов и содержать только буквы, цифры и символы подчеркивания.");
        }

        if (password.length() > 20 || !password.matches("[A-Za-z0-9_]+")) {
            throw new WrongPasswordException("Пароль неверен: он должен содержать до 20 символов и содержать только буквы, цифры и символы подчеркивания.");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают.");
        }
    }

    public static void main(String[] args) {
        try {
            validateInput("java_skypro_go", "D_1hWiKjjP_15", "D_1hWiKjjP_15");
            System.out.println("Ввод действителен.");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка завершена.");
        }
    }
}
