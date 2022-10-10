class Main {
  public static void main(String[] args) {
    System.out.println("------ TEST CASE 1: ENCODE ------");
    Message message1 = new Message();
    System.out.println(message1.encode("HELLO WORLD"));
    System.out.println(message1.decode(message1.encodedText));

    System.out.println("------ TEST CASE 2: DECODE ------");
    Message message2 = new Message();
    System.out.println(message2.decode("US$ /2./ 0Y.2"));
    System.out.println(message2.encode(message2.decodedText));
  }
}