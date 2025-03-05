import java.util.Scanner;

class UserQueue implements MyQueue {

    public void enqueue(float price) {
        System.out.println("Enqueue: " + price);
    }

    public float dequeue() {
        return 0.0f;
    }

    public float viewFront() {
        return 0.0f;
    }

    public boolean isEmpty() {
        return true;
    }

    // innerClass purchaceNode
    class purchaceNode {
        // constructors for node
        public purchaceNode(float price) {
            this(price, null);
        }

        public purchaceNode(float price, purchaceNode next) {
            this.price = price;
            this.next = next;
        }

        private float price;
        private purchaceNode next;

    }
}

public class QueueApp {

    public static void main(String[] args) {
        UserQueue queue = new UserQueue();
        System.out.println("Welcome to the Queue App");

        while (true) {
            System.out.println("0\tPurchace 10 shares of stock.");
            System.out.println("1\tSell 10 shares of stock.");
            System.out.println("2\tCheck the purchace price of the oldest 10 owned shares of stock.");
            System.out.println("3\tQuit");

            float choice = getUserFloat();

            // while user input is
            while (choice != 3) { // While loop serves as the menu system for the queueApp[(static) class] loop
                // ends when user inputs 3

                choice = getUserFloat(); // get the user's choice for the menu options and store it in the
                // tempUserInput variable
                // menu options
                if (choice == 0) { // opt1:enqueue[item to the queue]
                    float temp;
                    System.out.print("The stock costs: $"); // print message to user. asking for the value of the
                                                            // stock");
                    temp = getUserFloat(); // getting user input for what int they wish to add to the queue
                    queue.enqueue(choice); // push the user input to the queue
                    System.out.println(); // this line provides formatting spacing for ease of use.
                    continue; // continue the loop from the top.
                }
                if (choice == 1) { // opt2: dequeue[item from the queue]

                    if (queue.isEmpty() == false) { // if the queue as an element pop the element, if there are no
                        // items in the queue print message to user.
                        System.out.println("The item removed was of value: " + queue.dequeue() + "\n");

                    } else {
                        System.out.println("QUEUE IS EMPTY"); // print message to user. if queue is empty here
                    }
                    continue; // continue the loop from the top.
                }
                if (choice == 2) { // opt3: peek[at the top of the queue]

                    if (queue.isEmpty() == false) { // if the queue has a node then print the value of the node,
                        // if there are no items in the queue print message to user.
                        System.out.println("the item on the top of the queue is: " + queue.viewFront() + "\n");

                    } else {
                        System.out.println("QUEUE IS EMPTY"); // print message to user. if queue is empty here
                    }
                    continue; // continue the loop from the top.
                }
                System.out.println("NOT VALID MENU INPUT"); // print message to user. That the input is not valid
            }
        }

        // end menu

    }

    public static float getUserFloat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        return sc.nextFloat();
    }

}
