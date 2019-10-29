/**
 * @Author ZhangGJ
 * @Date 2019/10/28
 *
 * 刚写完排序算法，就被开除了…
 * 排序排成这样，不开除你，开除谁？
 */
public class ArraySort implements Runnable{

    private int number;

    public ArraySort(int number){
        this.number = number;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{102, 338, 62, 9132, 580, 666};
        for (int number : numbers) {
            new Thread(new ArraySort(number)).start();
        }
    }

    @Override
    public void run(){
        try {
            Thread.sleep(this.number);
            System.out.println(this.number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
