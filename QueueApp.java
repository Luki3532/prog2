import java.util.Scanner;

class UserQueue implements MyQueue {

    purchaceNode front; // front pointer of the queue
    purchaceNode rear; // rear pointer of the queue

    public void enqueue(float price) {
        // System.out.println("Enqueue: " + price);
        price = price * 10; // multiply the price by 10 to represent the total value of the stocks(10)
        purchaceNode newNode = new purchaceNode(price);// create a new node with the value of the stocks.
        if (isEmpty()) { // if the queue is empty then set the front and rear pointers to the new node
            front = newNode;
            rear = newNode;
        } else { // if the queue is not empty then add the new node to the rear of the queue
            rear.link = newNode;
            rear = newNode;
        }
    }

    public float dequeue() {
        /*
         * removes the front node from the queue and returns the value of the node
         * the front node represents the longest(oldest) standing stock owned by the
         * user.
         * IMPORTANT: the user/program should check if the queue is empty before calling
         * dequeue
         */
        if (isEmpty()) { // quickly return 0 if the queue is empty the user should check if the queue is
                         // empty before calling dequeue
            return 0.0f;
        }
        float price = front.price; // store the value of the front node in a temp variable
        front = front.link; // move the front pointer to the next node
        if (front == null) { // if the front pointer is null then the queue is empty
            rear = null; // then, set the rear pointer to null
        }
        return price; // in the end return the value of the front node
    }

    public float viewFront() {
        // returns the value of the front node
        // the user should check if the queue is empty before calling viewFront
        if (isEmpty()) { // quickly return 0 if the queue is empty to avoid errors.
            return 0.0f;
        }
        return front.price;
    }

    public boolean isEmpty() {
        // returns true if the queue is empty
        return ((front == null) && (rear == null)); // if both the front and rear pointers are null then the queue is
                                                    // empty
    }

    // innerClass purchaceNode
    class purchaceNode {
        // constructors for node
        public purchaceNode(float price) {
            this(price, null);
        }

        public purchaceNode(float initPrice, purchaceNode initLink) {
            price = initPrice;
            link = initLink;
        }

        private float price;
        private purchaceNode link;

    }
}

public class QueueApp {

    public static void main(String[] args) {
        UserQueue queue = new UserQueue();
        System.out.println("Welcome to the Queue App");

        float choice = -1;

        // while user input is
        while (choice != 3) { // While loop serves as the menu system for the queueApp[(static) class] loop
            // ends when user inputs 3

            System.out.println("0\tPurchace 10 shares of stock.");
            System.out.println("1\tSell 10 shares of stock.");
            System.out.println("2\tCheck the purchace price of the oldest 10 owned shares of stock.");
            System.out.println("3\tQuit");

            choice = getUserFloat(false); // get the user's choice for the menu options and store it in the
            // tempUserInput variable
            // menu options

            if (choice == 0) { // opt1:enqueue[item to the queue]
                float temp;
                System.out.print("The stock costs: $"); // print message to user. asking for the value of the
                                                        // stock");
                temp = getUserFloat(true); // getting user input for what int they wish to add to the queue
                queue.enqueue(temp); // push the user input to the queue
                System.out.print("You just purchaced 10 stocks at $" + temp + " totaling $" + temp * 10 + "\n\n");
                continue; // continue the loop from the top.
            }
            if (choice == 1) { // opt2: dequeue[remove item from the queue]

                if (queue.isEmpty() == false) { // if the queue as an element pop the element, if there are no
                    // items in the queue print message to user.
                    System.out.println("The item removed was of value: " + queue.dequeue() + "\n");

                } else {
                    System.out.println("NO STOCKS TO SELL!\n"); // print message to user. if queue is empty here
                }
                continue; // continue the loop from the top.
            }
            if (choice == 2) { // opt3: peek[look at the top of the queue]

                if (queue.isEmpty() == false) { // if the queue has a node then print the value of the node,
                    // if there are no items in the queue print message to user.
                    System.out.println(
                            "The item you have currently owned the longest was bought at: " + queue.viewFront() + "\n");

                } else {
                    System.out.println("NO STOCKS OWNED TO CHECK!\n"); // print message to user. if queue is empty here
                }
                continue; // continue the loop from the top.
            }
            System.out.println("NOT VALID MENU INPUT!\n"); // print message to user. That the input is not valid
        }

        // end menu

    }

    public static float getUserFloat(boolean forPriceInput) {
        Scanner sc = new Scanner(System.in);
        if (!forPriceInput) {
            System.out.print("Enter your choice: ");
        }
        return sc.nextFloat();

    }

}
