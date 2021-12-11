package pro.sdacademy.test.advance.example.a;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

  Optional<User> findById(Long id);

  User addUser(User user);
}
