package StringReverser;

public class Stack {
    private int maxSize;
    private char[] stack;
    private int top;

    public Stack(int size){
        this.maxSize = size;
        this.stack = new char[this.maxSize];
        this.top = -1;
    }

    public void push(char i){
        this.stack[++this.top] = i;
    }

    public char pop(){
        return this.stack[this.top--];
    }

    public char peek(){
        return this.stack[this.top];
    }

    public boolean isEmpty(){
        return (this.top == -1);
    }

    public boolean isFull(){
        return (this.top == this.maxSize-1);
    }
}
