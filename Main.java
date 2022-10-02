class Main {

  public int getRandomNumber(int min, int max){
    return (int) ((Math.random() * (max-min)) + min);
  };
  
  public static String referenceTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";

  public static String encode(String plaintext){
    // convert plaintext to upper case
    String newPlaintext = plaintext.toUpperCase();
    
    // randomly determine the offset character
    int offsetChIndex = (int) ((Math.random() * (43-0)) + 0);
    char offsetCh = referenceTable.charAt(offsetChIndex);

    // initialise the encodedText
    String encodedText = "";
    encodedText += offsetCh;
    
    // loop thru each char in newPlaintext
    for (int i = 0; i < newPlaintext.length(); i++){
      char ch = newPlaintext.charAt(i);

      // if referenceTable does not include the char, return char as it is in the encodedText
      if (referenceTable.indexOf(ch) == -1){
        encodedText += ch;
        } else {
        // for each, get its index, and minus the offset to determine its newIndex
          int index = referenceTable.indexOf(ch);
          int newIndex = index - offsetChIndex;
          if (newIndex < 0){
            // if the newIndex is less than 0, newChar is 43+newIndex+1
            char newCh = referenceTable.charAt(44+newIndex);
            encodedText += newCh;
        } else {
            // else, newChar is referenceTable[newIndex]
            char newCh = referenceTable.charAt(newIndex);
            encodedText += newCh;
        }
      }
    }
    return encodedText;
  }

  public static String decode(String encodedText){
    String decodedText = "";
    
    // get the offset character 
    char offsetCh = encodedText.charAt(0);
    int offsetChIndex = referenceTable.indexOf(offsetCh);

    // loop thru each char in encodedText from index 1 onwards;
    for (int i = 1; i < encodedText.length(); i++){
      char ch = encodedText.charAt(i);
      // if referenceTable does not include the char, return char as it is in the decodedText
      if (referenceTable.indexOf(ch) == -1){
        decodedText += ch;
      } else {
        // for each, get its index, and add the offset to determine its newIndex
        int index = referenceTable.indexOf(ch);
        int newIndex = index + offsetChIndex;
        if (newIndex > 43){
          // if the newIndex is more than 43, newChar is newIndex - 43 + 1
          char newCh = referenceTable.charAt(newIndex - 44);
          decodedText += newCh;
        } else {
          // else, newChar is referenceTable[newIndex]
          char newCh = referenceTable.charAt(newIndex);
          decodedText += newCh;
        }
      } 
    }
    return decodedText;
  }

  public static void main(String[] args) {
    System.out.println("TEST CASE 1 -----------------");
    System.out.println(encode("HELLO WORLD"));
    System.out.println(decode("+MJQQT 1TWQI"));
    System.out.println(decode("BGDKKN VNQKC"));
    System.out.println("TEST CASE 2 -----------------");
    System.out.println(encode("*$ TEST CASE"));
    System.out.println(decode("VR$ .1-. ZX-1"));
    System.out.println(decode("B)$ SDRS B/RD"));
  }
}