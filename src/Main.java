import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    //System.out.println(encryption("iffactsdontfittotheorychangethefacts"));
    System.out.println(isPalindrom("kayak"));
  }

  /**
   * Method allowing to encrypt a message using a encryption scheme from hackerRank
   * @author Cheikh Fame
   * @param str
   * @return
   */
  public static String encryption(String str) {
    // Write your code here
    int row = (int) Math.floor(Math.sqrt(str.length()));
    int col;
    int limit;
    if(Math.floor(Math.sqrt(str.length())) == Math.sqrt(str.length())) {
      col = row;
      limit = row - 1;
    }else {
      col = row + 1;
      limit = row;
    }
    String finalString = "";
    for(int i = 0; i <= limit ; i++) {
      String word = "";
      for (int j = i; j < str.length(); j = j + col) {
        word += str.charAt(j);
      }
      finalString += word+ " ";
    }

    return finalString.trim();

  }

  public static boolean isPalindrom(String str) {
    Stack<Character> characterStack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      characterStack.push(str.charAt(i));
    }
    System.out.println(characterStack.size());
    for (int i = 0; i < characterStack.size(); i++) {

      sb.append(characterStack.pop());
    }
    System.out.println(sb.toString());
    return sb.toString().equals(str);
  }

}