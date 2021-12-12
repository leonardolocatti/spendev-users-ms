package br.com.llocatti.spendev.users;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class UsersApplicationTests {

  @Test
  void contextLoads() {
    assertDoesNotThrow(() -> UsersApplication.main(new String[] {}));
  }
}
