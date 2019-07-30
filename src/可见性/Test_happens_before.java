/**
 * @Classname Test_happens_before
 * @Description
 * @Date 2019/7/24 20:38
 * @Created by liZhi
 */
public class Test_happens_before implements Runnable{

    int x = 0;
     volatile   boolean  v = false;

    public synchronized void writer(){
        x = 42;
        v = true;
    }
    public  void read(){

        if(this.v){
            System.out.println(this.x);
        }else{
            System.out.println("------");
            System.out.println(this.v);
            System.out.println(this.x);
        }
    }

    public static void main(String[] args) {
         Test_happens_before t1 =new Test_happens_before();
              Thread t2 = new Thread(()->{
                   t1.writer();
              });
              Thread t3 = new Thread(()->{
                  t1.read();
              });
              t3.start();
              t2.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
         this.read();
    }
}
