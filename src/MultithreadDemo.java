/*
multithreading :
using Thread class
using Runable Interface


 */
public class MultithreadDemo extends Thread{
    public void run(){
        int i=1;
        do {
            System.out.println("i "+i);
            try {
                sleep(300) ;//delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }while (i<5);
    }

    public static void main(String[] args) throws InterruptedException {
        MultithreadDemo mobj= new MultithreadDemo();
        mobj.start(); // to start thread
        MultithreadDemo mobj2= new MultithreadDemo();
        mobj.join();
        mobj2.start(); //to start new thread you need new object

        //using Runnable interface:
        Runnabledemo r1= new Runnabledemo();
        Thread t = new Thread(r1);
        t.start();
//      OR
        Runnable r= new Runnable() {
            @Override
            public void run() {
                for (int i=100;i<103;i++)
                    System.out.println(i);
            }
        };
        Thread t1= new Thread(r);
        t1.start();

        Thread t3= new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=200;i<203;i++)
                    System.out.println(i);
            }
        });
        t3.start();

        //synchronus method writing
        demoSynchronus dm= new demoSynchronus();
        SynchronousMethods obj= new SynchronousMethods(dm);
        Thread t5= new Thread(obj);
        t5.start();

        SynchronusMethos2 obj2=new SynchronusMethos2(dm);
        Thread t6= new Thread(obj2);
        t6.start();
    }
}

 class Runnabledemo implements Runnable{
    @Override
    public void run (){
        int i=1;
        do {
            System.out.println("Runnable i "+i);
            i++;
        }while (i<7);
    }


}
class demoSynchronus{
    public synchronized void display(){
       for (int i=896;i<900;i++)
           System.out.println(i);
    }
}

class SynchronousMethods implements Runnable{
    demoSynchronus objDemoSync= new demoSynchronus();
    public SynchronousMethods(demoSynchronus d){
        this.objDemoSync=d;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        objDemoSync.display();
    }
}

class SynchronusMethos2 implements Runnable{
    demoSynchronus objDemoSync= new demoSynchronus();
    public SynchronusMethos2(demoSynchronus d){
        this.objDemoSync=d;
    }

    @Override
    public void run() {
        objDemoSync.display();
    }
}
