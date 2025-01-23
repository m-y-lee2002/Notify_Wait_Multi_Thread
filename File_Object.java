public class File_Object{
    private int download_status;
    private String download_path;
    private boolean isReady = false;
    File_Object(){
        this.download_status = 0;
        this.download_path = "NO PATH SET";
    }
    public String getDownloadPath(){
        return this.download_path;
    }
    public void setDownloadPath(String download_path){
        this.download_path = download_path;
    }
    public int getDownloadStatus(){
        return this.download_status;
    }
    public void updateDownloadStatus(){
        this.download_status+=25;
    }

    public synchronized void filePathSetter(){
        while(!isReady){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("thread has been interrupted");
            }
        }
        System.out.println("File path setter has control");
        this.setDownloadPath("c:/object/file/example/");
        this.isReady = false;
        notifyAll();
    }
    public synchronized void fileDownloader(){
        while(isReady){
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
        }
        for(int i = 0; i < 4; i++){
            this.updateDownloadStatus();
            System.out.println(Thread.currentThread().getName()+ " has control: "+ this.getDownloadStatus() + "% | File Path: " + this.getDownloadPath());
            
            if(this.getDownloadStatus() == 50){
                System.out.println("Stop downloading");
                this.isReady = true;
                notifyAll();
                try{
                    wait();
                }catch(InterruptedException e){
                    System.out.println("Thread has been interrupted");
                }
            }
        }
        
    }
}