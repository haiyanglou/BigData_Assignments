package JavaHDFS.JavaHDFS;

import java.io.*;  
import java.util.zip.*;  
import java.util.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.io.compress.DefaultCodec;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.io.compress.SnappyCodec;
import org.apache.hadoop.io.compress.BZip2Codec;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class Main {
	
	private void zip(ZipOutputStream out, File f, String base) throws Exception  
    {  
        if (f.isDirectory()) {  
            File[] files = f.listFiles();  
            base = (base.length() == 0 ? "" : base + "/");  
            for (int i = 0; i < files.length; i++) {  
                zip(out, files[i], base + files[i].getName());  
            }  
        } else {  
            out.putNextEntry(new ZipEntry(base));  
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));  
            int c;  
              
            while ((c = in.read()) != -1) {  
                out.write(c);  
            }  
            in.close();  
        }  
    }  
      
    private void zip(File inputFileName, String zipFileName) throws Exception  
    {  
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));  
        zip(out, inputFileName, "");  
        out.close();  
    }  
      
    //压缩文件，inputFileName表示要压缩的文件（可以为目录）,zipFileName表示压缩后的zip文件  
    public void zip(String inputFileName, String zipFileName) throws Exception  
    {  
        zip(new File(inputFileName), zipFileName);  
    }  
      
    //解压,zipFileName表示待解压的zip文件，unzipDir表示解压后文件存放目录  
    public void unzip(String zipFileName, String unzipDir) throws Exception  
    {  
        ZipInputStream in = new ZipInputStream(new FileInputStream(zipFileName));  
        ZipEntry entry;  
        while ((entry = in.getNextEntry()) != null) {  
              
            String fileName = entry.getName();  
             
            //有层级结构，就先创建目录  
            String tmp;  
            int index = fileName.lastIndexOf('/');  
            if (index != -1) {  
                tmp = fileName.substring(0, index);  
                tmp = unzipDir + "/" + tmp;  
                File f = new File(tmp);  
                f.mkdirs();  
            }  
              
            //创建文件  
            fileName = unzipDir + "/" + fileName;  
            File file = new File(fileName);  
            file.createNewFile();  
              
            FileOutputStream out = new FileOutputStream(file);  
            int c;  
            while ((c = in.read()) != -1) {  
                out.write(c);  
            }  
            out.close();  
        }  
        in.close();  
    }  
      
    public static void main(String[] args)  throws Exception
    {  
        try {  
              
            String inputFileName = args[1];  
            String zipFileName = args[0];  
            Main test = new Main();  
             
            test.unzip(zipFileName, inputFileName);  
  
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
    } 
}
