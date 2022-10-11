import java.util.Scanner;

public class Message {
  public String encodedText = "";
  public String decodedText = "";

  private static String referenceTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";

  public String encode(String plaintext){
    // convert plaintext to upper case
    String newPlaintext = plaintext.toUpperCase();
    
    // randomly determine the offset character
    int offsetChIndex = (int) ((Math.random() * (43-0)) + 0);
    char offsetCh = referenceTable.charAt(offsetChIndex);

    // user set the offset character
    // Scanner offsetChInput = new Scanner (System.in);
    // System.out.println("Enter offset character below: ");
    // String offsetCh = offsetChInput.nextLine();
    // int offsetChIndex = referenceTable.indexOf(offsetCh);

    // hard set the offset character
    // String offsetCh = "B";
    // int offsetChIndex = referenceTable.indexOf(offsetCh);

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

  public String decode(String encodedText){
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
}