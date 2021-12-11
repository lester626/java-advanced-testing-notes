package pro.sdacademy.test.advance.example.a;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private Long id;
  private String firstName;
  private String lastName;
}