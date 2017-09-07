package JavaHDFS.JavaHDFS;

import java.io.File;
import java.io.InputStream;

public class Test {
	  public static void main(String[] args) throws Exception {
		  
        String url = args[0];
        String[] split = url.split("\\/");
        String fileName = split[split.length - 1];
        File file = new File(args[1], fileName);

        InputStream inputStream = HttpURLConnectionUtil
                .getInputStreamByGet(url);
        HttpURLConnectionUtil.saveData(inputStream, file);
    }
}
