public class Main{
    private static final int SIZE = 10000000;
    private static float[] boringArr = new float[SIZE];
    private static float[] arr = new float[SIZE];


    public static void main(String[] args) {
        boringVirginSingleThreadArray();
        chadMultiThreadArray();
        // if you want to check if arrays are equal - uncomment this and also
        //arraycopy @boringVirginSingleThreadArray
        /*boolean arraysAreEqual = true;
        for (int i = 0; i < SIZE ; i++) {
            if (arr[i] != boringArr[i]){
                arraysAreEqual = false;
            }
        }
        System.out.println(arraysAreEqual);*/

    }

    private static void boringVirginSingleThreadArray(){

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        changeEveryValue(arr);
        System.out.println(System.currentTimeMillis() - a);
        //System.arraycopy(arr, 0, boringArr, 0, SIZE);
    }

    private static void chadMultiThreadArray(){
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        IReCalculateArrayElementsSmile arr1Calc = new IReCalculateArrayElementsSmile(arr, true);
        arr1Calc.start();
        IReCalculateArrayElementsSmile arr2Calc = new IReCalculateArrayElementsSmile(arr, false);
        arr2Calc.start();
        try{
            //set me to true if you want to interrupt :)
            boolean wannaInterrupt = false;
            if(wannaInterrupt){
                arr2Calc.interrupt();
                throw new InterruptedException();
            }
        }catch (InterruptedException e){
            System.out.println("I'm Rainbows :) ");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        while(arr1Calc.isAlive() || arr2Calc.isAlive()){ }

        System.out.println(System.currentTimeMillis() - a);

    }
    private static void changeEveryValue(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (float)i / 5) * Math.cos(0.2f + (float)i / 5) * Math.cos(0.4f + (float)i / 2));
        }

    }
}
