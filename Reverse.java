public class Reverse {
    public static String ReverseString(String str) {
        if (null == str || str.length() <= 1) {
            return str;
        }
        return ReverseString(str.substring(1)) + str.charAt(0);
    }
    public static void main(String[] args) {
        String input = "hello";
        System.out.println(ReverseString(input));
    }
}