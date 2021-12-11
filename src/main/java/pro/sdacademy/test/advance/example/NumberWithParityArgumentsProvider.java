package pro.sdacademy.test.advance.example;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class NumberWithParityArgumentsProvider implements ArgumentsProvider {

  public NumberWithParityArgumentsProvider() {

  }

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
    return Stream.of(
        Arguments.of(1, true),
        Arguments.of(100, false),
        Arguments.of(101, true)
    );
  }
}
