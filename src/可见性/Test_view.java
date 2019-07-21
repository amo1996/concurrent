package 可见性;

/**
 * @Classname Test_view
 * @Description
 * @Date 2019/7/21 20:04
 * @Created by liZhi
 */
public class Test_view {

    private static long count=0;

   private void add10K(){
       int idx=0;
       while(idx++<10000){
           count+=1;
       }
   }

   public static long calc(){
       final Test_view test_view =new Test_view();
       Thread t1=new Thread(()->{
           test_view.add10K();
       });

       Thread t2=new Thread(()->{
             test_view.add10K();
       });
       t1.start();
       t2.start();
     //  t1.join();
      // t2.join();
       try {
           t1.join();
           t2.join();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
      //     System.out.println(Test_view.count);
        return  count;
   }

    public static void main(String[] args) {
        calc();
    }
}
