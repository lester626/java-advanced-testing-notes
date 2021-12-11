public class UserValidator {
    private final Validator validator;

    public UserValidator(Validator validator){
        this.validator = validator;
    }
    public boolean isValidUser(User user){
        //return !user.getFirstName().isBlank() && !user.getLastName().isBlank();
        return validator.isUserValid(user);
    }
}
