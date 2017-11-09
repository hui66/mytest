import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.Arrays;


public class test {
    public static void main(String[] args) {
        String formPath = "F:\\temp.txt";
        String toPath ="F:\\dest.txt";
        readFile(formPath,toPath);
    }

    private static void readFile(String formPath, String toPath) {
        try {
            BufferedInputStream fis = null;
            BufferedOutputStream fos = null;
            //输入流
            File  fromFile = new File(formPath);
            fis = new BufferedInputStream(new FileInputStream(fromFile));

            //输出流
            File toFile = new File(toPath);
            fos = new BufferedOutputStream(new FileOutputStream(toFile));
            byte[] buffer = new byte[1024];
            int temp = 0;
            while ((temp=fis.read(buffer))!=-1){
                byte[] sbuf = toUpperString(buffer);
                fos.write(sbuf);
            }
            fis.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static byte[] toUpperString(byte[] buffer) {
        String sbuffer=new String(buffer).trim().toUpperCase();
        byte[] sbuf = sbuffer.getBytes();
        return sbuf;
    }

}
