package com.rainier.singletonpattern;

import com.rainier.singletonpattern.hungry.CodeGenerator;
import com.rainier.singletonpattern.hungry.UpgradeCodeGenerator;
import com.rainier.singletonpattern.lazy.UpgradeDoubleCheckCodeGenerator;

import java.io.*;

public class SerializableTest{

    public static void main(String[] args) {

        Object obj = UpgradeDoubleCheckCodeGenerator.getInstance();

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {

            fileOutputStream = new FileOutputStream("SeriableSingleton.obj");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();


            fileInputStream = new FileInputStream("SeriableSingleton.obj");
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj2 = objectInputStream.readObject();

            System.out.println(obj);
            System.out.println(obj2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
