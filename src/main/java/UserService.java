public class UserService {
    private final Validator validator;
    private final UserRepository userRepository;

    public UserService(final Validator validator, final UserRepository userRepository){
        this.userRepository = userRepository;
        this.validator = validator;
    }

    public User getUserById(final Long id){
        return userRepository.findById(id).orElseThrow();
    }

    public User createUser(final User user){
        if (validator.isUserValid(user)){
            return userRepository.addUser(user);
        }
        throw new IllegalArgumentException("User is invalid");
    }
}
