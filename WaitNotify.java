public class WaitNotify {
    public static void main(String[]args)throws InterruptedException{
        System.out.println("Start of main thread");
        File_Object file_object = new File_Object();
        Runnable r1 = new File_Downloader(file_object);
        Runnable r2 = new File_Path_Setter(file_object);
        Thread t1 = new Thread(r1,"T1");
        Thread t2 = new Thread(r2, "T2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("End of main thread");
    }
}