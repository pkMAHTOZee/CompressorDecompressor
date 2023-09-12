package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
    // Method for compressing a file using GZIP
    public static void method(File file) throws IOException {
        // get the directory where original file is located
        String fileDirectory = file.getParent();

        //create input and output stream
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/CompressedFile.gz");
        GZIPOutputStream gzip = new GZIPOutputStream(fos);
        byte[] buffer = new byte[1024];
        int len;
        //read the original file and write to the compress file
        while((len=fis.read(buffer))!=-1)
        {
            gzip.write(buffer,0,len);
        }
        gzip.close();
        fos.close();;
        fis.close();
    }

    public static void main(String[] args) throws IOException{
        //specify the path for the file you want to compress
        File path = new File("");
        method(path);

    }
}
