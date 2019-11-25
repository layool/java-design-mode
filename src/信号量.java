
class Semaphore {
    private boolean signal = false;   //使用signal可以避免信号丢失
    public synchronized void take() {
        this.signal = true;
        this.notify();
    }
    public synchronized void release() throws InterruptedException{
        while(!this.signal) //使用while避免假唤醒
            wait();
        this.signal = false;
    }
}
class SendingThread extends Thread {
    Semaphore semaphore = null;
    public SendingThread(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    public void run(){
        while(true){
            //do something, then signal
            this.semaphore.take();
        }
    }
}

class RecevingThread extends Thread{
    Semaphore semaphore = null;
    public RecevingThread(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    public void run(){
        while(true){
            try {
                this.semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //receive signal, then do something...
        }
    }
}

public class 信号量 {
    public static void main(String args[]) throws InterruptedException {
        Semaphore semaphore = new Semaphore();
        SendingThread sender = new SendingThread(semaphore);
        RecevingThread receiver = new RecevingThread(semaphore);
        receiver.start();
        sender.start();
    }
}
