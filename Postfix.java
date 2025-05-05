import java.util.*;
public class Postfix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a postfix expression:");
        String input = s.nextLine();
        String[] tokens = input.split("\\s+");

        LinkBasedStack<Integer> stack = new LinkBasedStack<>();

        try {
            for(String token : tokens) {
                if(isNumber(token))
                    stack.push(Integer.parseInt(token));
                 else if (isOperator(token)) {
                    if(stack.size() < 2)
                        throw new StackException("Not enough operands in stack: " + token);

                    int o2 = stack.pop();
                    int o1 = stack.pop();
                    int result = performOperation(o1, o2, token);
                    stack.push(result);
                } else if (token.isEmpty()) {
                    throw new StackException("Incorrect token: " + token);
                }
            }
            if(stack.size() == 1)
                System.out.println("Equals: " + stack.pop());
             else
                throw new StackException("Too many values left on the stack.");

        } catch (StackException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    private static int performOperation(int o1, int o2, String operator) {
        return switch (operator) {
            case "+" -> o1 + o2;
            case "-" -> o1 - o2;
            case "*" -> o1 * o2;
            case "/" -> {
                if (o2 == 0)
                    throw new StackException("Cannot divide by 0");
                yield o1 / o2;
            }
            default -> throw new StackException("Incorrect operator: " + operator);
        };
    }
}