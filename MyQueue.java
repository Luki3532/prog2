public interface MyQueue {
    public void enqueue(float price);

    public float dequeue();

    public float viewFront();

    public boolean isEmpty();

}