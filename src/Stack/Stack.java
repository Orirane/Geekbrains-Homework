package Stack;

public class Stack {
    private int maxSize;
    private int[] stack;
    private int top;

    public Stack(int size){
        this.maxSize = size;
        this.stack = new int[this.maxSize];
        this.top = -1;
    }

    public void push(int i){
        this.stack[++this.top] = i;
    }

    public int pop(){
        return this.stack[this.top--];
    }

    public int peek(){
        return this.stack[this.top];
    }

    public boolean isEmpty(){
        return (this.top == -1);
    }

    public boolean isFull(){
        return (this.top == this.maxSize-1);
    }
}
