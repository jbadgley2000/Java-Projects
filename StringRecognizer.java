import java.util.*;

public class StringRecognizer{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String input = scanner.nextLine();
        scanner.close();

        if(Recognizer(input))
            System.out.println(input + " is in language");
         else {
            System.out.println(input + " is not in language");
        }
    }
    public static boolean Recognizer(String s){
        LinkBasedStack<Character> stack = new LinkBasedStack<>();
        int dollar = -1;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '$'){
                dollar = i;
                break;
            }
        }
        if(dollar == -1)
            return false;

        for(int i = 0; i < dollar; i++) {
            stack.push(s.charAt(i));
        }
        for(int i = dollar +1; i < s.length(); i++) {
            if(stack.isEmpty())
                return false;
            try {
                char top = stack.pop();
                if (top != s.charAt(i))
                    return false;

            } catch (StackException e) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}