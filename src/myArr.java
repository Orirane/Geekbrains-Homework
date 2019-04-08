import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class myArr {
    private int[] arrCopy;
    private int[] arr;
    private int size;

    public myArr(int size) {
        this.size = size;
        this.arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = getRandom(0, size);
        }

        arrCopy = Arrays.copyOf(arr, size);

    }

    public void resetArray() {
        for (int i = 0; i < size; i++) {
            this.arr[i] = arrCopy[i];
        }
    }

    public void arrToString() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.arr[i]);
        }
    }

    public void arrDeleteElement(int target){
        do{
        int i;
        int len = this.arr.length;
        for (int j = 0; j < len; j++) {
            System.out.println(this.arr[j]);
        }

        //Поиск искомого элемента

        for (i = 0; i < len; i++) {
            if (this.arr[i] == target) {
                break;
            }
        }

        //Сдвиг всех элементов на 1 шаг влево
        for (int j = i; j < len - 1; j++) {
            this.arr[j] = this.arr[j + 1];
        }
        len--;

        //Вывод массива с удаленным элементом
        for (int j = 0; j < len; j++) {
            System.out.println(this.arr[j]);
        }}while(contains(arr,target ));
    }
    public void insertElement(int value){
        int i;
        for(i=0;i<this.size;i++){
            if (this.arr[i]>value)
                break;
        }
        for(int j=this.size;j>i;j--){
            this.arr[j] = this.arr[j-1];
        }
        this.arr[i] = value;
        this.size++;
    }


    public void sortBubble(){
        Instant start = Instant.now();
        int out, in;
        for (out = this.size - 1; out >= 1; out--) {
            for(in = 0; in < out; in++) {
                if (this.arr[in] > this.arr[in + 1]) {
                    change(in, in + 1);
                }
            }
        }
        Instant end = Instant.now();
        System.out.println("Bubble sort benchmark: " + Duration.between(start, end).toMillis());
    }

    public void sortSelect(){
        Instant start = Instant.now();
        int out, in, mark;
        for(out=0;out<this.size;out++){
            mark = out;
            for(in = out+1;in<this.size;in++){
                if (this.arr[in]< this.arr[mark]){
                    mark = in;
                }
            }
            change(out, mark);
        }
        Instant end = Instant.now();
        System.out.println("Select sort benchmark: " + Duration.between(start, end).toMillis());
    }

    public void sortInsert(){
        Instant start = Instant.now();
        int in, out;
        for(out = 1;out < this.size; out++){
            int temp = this.arr[out];
            in = out;
            while(in > 0 && this.arr[in-1] >=temp){
                this.arr[in] = this.arr[in-1];
                --in;
            }
            this.arr[in] = temp;
        }
        Instant end = Instant.now();
        System.out.println("Insert sort benchmark: " + Duration.between(start, end).toMillis());
    }



    private void change(int a, int b){
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }


    // returns random number between int min and int max
    public static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    private boolean contains(int[] arr, int item) {
        Integer intObj = new Integer(item);
        Integer[] arrInt = IntStream.of( arr ).boxed().toArray( Integer[]::new );
        return Arrays.stream(arrInt).anyMatch(intObj::equals);
    }
}
