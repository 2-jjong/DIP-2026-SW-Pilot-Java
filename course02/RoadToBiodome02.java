package course02;

public class RoadToBiodome02 {
    private static char[] stack;
    private static int top = -1;

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력된 메시지가 올바르지 않습니다. 다시 한번 확인해주세요.");
            return;
        }

        String input = String.join(" ", args);

        if (input == null || input.trim().isEmpty()) {
            System.out.println("입력된 메시지가 올바르지 않습니다. 다시 한번 확인해주세요.");
            return;
        }

        if (isPalindrome(input)) {
            System.out.println(input);
            return;
        }

        top = -1;
        stack = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            push(input.charAt(i));
        }

        char[] reversedChars = new char[input.length()];
        int idx = 0;

        while (!isEmpty()) {
            reversedChars[idx++] = pop();
        }

        String reversedString = new String(reversedChars);
        System.out.println(reversedString);
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void push(char c) {
        top++;

        if (top >= stack.length) {
            char[] newStack = new char[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[top] = c;
    }

    public static char pop() {
        if (isEmpty()) {
            return '\0';
        }

        char c = stack[top];
        top--;

        return c;
    }

    public static char peek() {
        if (isEmpty()) {
            return '\0';
        }

        return stack[top];
    }

    public static boolean isEmpty() {
        return top == -1;
    }
}
