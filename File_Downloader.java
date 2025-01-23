public class File_Downloader implements Runnable{
    private File_Object file_object;

    File_Downloader(File_Object file_object){
        this.file_object = file_object;
    }
    

    public void run() {
        System.out.println("file downloader starts");
        file_object.fileDownloader();
    }
}