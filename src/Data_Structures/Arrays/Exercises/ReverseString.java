package Data_Structures.Arrays.Exercises;

public class ReverseString {

  public static String reverse(String str)
  {
    if(str == null || str.isEmpty())
    {
      throw new IllegalArgumentException("Invalid Input!");
    }

    StringBuilder sb = new StringBuilder();
    for(int i = str.length() - 1; i >= 0; i--){
      sb.append(str.charAt(i));
    }

    return sb.toString();
  }

  public static String reverse2(String str)
  {
    if(str == null || str.isEmpty())
    {
      throw new IllegalArgumentException("Invalid Input!");
    }

    return new StringBuilder(str).reverse().toString();
    
  }

  public static void main(String[] args) {
        System.out.println(reverse("Hello World!"));
        System.out.println(reverse2("Hello World!"));

    }
}
