package hello;

public class SayHello {

  public String say(String name) {
	return "Welcome " + name;
  }

public static void main(String[] args) {
   System.out.println(new SayHello().say("John Doe"));
}

}