package hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class SayHelloTest {

  @Test
  void testSay() {
     SayHello sayHello = new SayHello();
     String message = sayHello.say("John Doe");
     assertEquals("Welcome John Doe", message);
  }


}