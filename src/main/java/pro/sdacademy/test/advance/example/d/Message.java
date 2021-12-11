package pro.sdacademy.test.advance.example.d;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

  private UUID id;
  private String value;
  private LocalDateTime sendAt;
  private String author;
  private String recipent;
}
