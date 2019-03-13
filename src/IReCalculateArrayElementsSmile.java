public class IReCalculateArrayElementsSmile extends Thread {
    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;
    private float[] arr;
    private float[] arrHalf= new float[HALF];
    private boolean isFirstArray;

    IReCalculateArrayElementsSmile(float[] arr, boolean isFirstArray){
        this.arr = arr;
        this.isFirstArray = isFirstArray;

    }
    private void changeEveryValue(){
        if (isFirstArray) {
            System.arraycopy(arr, 0, arrHalf, 0, HALF);

            for (int i = 0; i < arrHalf.length; i++) {
                arrHalf[i] = (float) (arrHalf[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
            }
            System.arraycopy(arrHalf, 0, arr, 0, HALF);
        }
        else {
            System.arraycopy(arr, HALF, arrHalf, 0, HALF);
            for (int i = 0; i < arrHalf.length; i++) {
                int iplushalf = i + HALF;
                arrHalf[i] = (float) (arrHalf[i] * Math.sin(0.2f + (float) iplushalf / 5) * Math.cos(0.2f + (float) iplushalf / 5) * Math.cos(0.4f + (float) iplushalf / 2));
            }
            System.arraycopy(arrHalf, 0, arr, HALF, HALF);
        }

    }
    public void run() {
        changeEveryValue();
    }
}
