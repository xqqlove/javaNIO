package com.yiwa.io;

import org.junit.Test;

import java.io.*;

public class InputAndReader {

    @Test
    public void FIleReaderStream() throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("D:\\qiangInFile\\file1.txt");
            char[] b = new char[1034];
            int hasread = 0;
            while ((hasread = fileReader.read(b)) > 0) {
                System.out.println(new String(b, 0, hasread));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileReader.close();
        }
    }


    @Test
    public void testFileInputStream() throws IOException {
        FileInputStream fileInputStream = null;
        try {
//            File file=new File("D:\\qiangInFile\\file1.txt");
            fileInputStream = new FileInputStream("e:\\io.txt");
            byte[] b = new byte[1024];
            int hsaRead = 0;
            while ((hsaRead = fileInputStream.read(b)) > 0) {
                System.out.println(new String(b, 0, hsaRead, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }

    }

    @Test
    public void outStream() throws IOException{
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("D:/qiangInFile/file1.txt");
            fileOutputStream = new FileOutputStream("D:/qiangInFile/file2.txt");
            byte[] b = new byte[1024];
            int hasRead = 0;
            while ((hasRead = fileInputStream.read(b)) > 0) {
                fileOutputStream.write(b, 0, hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }

    @Test
    public void testBufferedStream() throws IOException{
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;

        try {
            fileInputStream=new FileInputStream("D:/qiangInFile/file1.txt");
            fileOutputStream=new FileOutputStream("D:/qiangInFile/file13.txt");
            bufferedInputStream=new BufferedInputStream(fileInputStream);
            bufferedOutputStream=new BufferedOutputStream(fileOutputStream);

            byte[] b=new byte[1024];
            int hasread=0;
            while ((hasread=bufferedInputStream.read(b))>0){
                bufferedOutputStream.write(b,0,hasread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }
    }

    @Test
    public void testInputStreamReader(){
        try {
            InputStreamReader reader=new InputStreamReader(System.in);
            BufferedReader bufferedReader=new BufferedReader(reader);
            File file=new File("e:/file14.txt");
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            byte [] b=new byte[2048];
            String buf=null;
            while((buf=bufferedReader.readLine())!=null){
                b=buf.getBytes();
                bufferedOutputStream.write(b,0,b.length);
                if (buf.equals("exit")){
                    System.exit(1);
                }
                System.out.println("输入内容： "+buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void main(String[] args) throws IOException{
        InputStreamReader reader=null;
        BufferedReader bufferedReader=null;
        FileOutputStream fileOutputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try {
            reader =new InputStreamReader(System.in);
            bufferedReader=new BufferedReader(reader);
//            File file=new File("e:/file14.txt");
//            if (!file.exists()){
//                file.createNewFile();
//            }
            fileOutputStream=new FileOutputStream("e:/file14.txt");
//            bufferedOutputStream.flush();
            byte [] b=null;
            String buf=null;
            while((buf=bufferedReader.readLine())!=null){
                b=buf.getBytes();
                fileOutputStream.write(b,0,b.length);
                if (buf.equals("exit")){
                    System.exit(1);
                }
                System.out.println("输入内容： "+buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
        }
    }


    @Test
    public void testObjectStream(){
        OutputStream outputStream=null;
        BufferedOutputStream buf=null;
        ObjectOutputStream objectOutputStream=null;
        try {
            outputStream=new FileOutputStream("D:/qiangInFile/file15Object.txt");
            buf=new BufferedOutputStream(outputStream);
            objectOutputStream=new ObjectOutputStream(buf);
            objectOutputStream.writeObject(new Person("Abcc",21));
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readObject() {
        try {
            InputStream inputStream=new FileInputStream("D:/qiangInFile/file15Object.txt");
            BufferedInputStream buf=new BufferedInputStream(inputStream);
            ObjectInputStream obj=new ObjectInputStream(buf);
            Person person= (Person) obj.readObject();
            System.out.println("person :"+person);
            obj.close();
            buf.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
