package course02;

public class RoadToBiodome08 {
    private static int[] queue = new int[10];
    private static int front = 0;
    private static int rear = 0;

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력된 값이 올바르지 않습니다.");
            return;
        }

        for (String arg : args) {
            try {
                int val = Integer.parseInt(arg.replace(",", "").trim());
                enqueue(val);
            } catch (NumberFormatException e) {
                System.out.println("입력된 값이 올바르지 않습니다.");
                return;
            }
        }

        while (!isEmpty()) {
            int val = dequeue();
            System.out.println("자원 제공: " + val);
        }

        System.out.println("모든 요청이 처리되었습니다.");
    }

    public static void enqueue(int val) {
        if (rear >= queue.length) {
            int newCapacity = queue.length + 10;
            System.out.println("Queue의 크기가 " + newCapacity + "으로 늘어났습니다.");

            int[] newQueue = new int[newCapacity];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }

        queue[rear] = val;
        rear++;
    }

    public static int dequeue() {
        if (isEmpty()) {
            return -1;
        }

        int val = peek();
        front++;
        return val;
    }

    public static int peek() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public static boolean isEmpty() {
        return front >= rear;
    }
}
