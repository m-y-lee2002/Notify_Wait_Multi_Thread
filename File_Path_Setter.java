public class File_Path_Setter implements Runnable{
    private File_Object file_object;
    File_Path_Setter(File_Object file_object){
        this.file_object = file_object;
    }
    public void run(){
            file_object.filePathSetter();
            System.out.println("File Path Setter completed");
    }
}