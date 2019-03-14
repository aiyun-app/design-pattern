package com.rainier.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Common {
    public static String readConsoleLine() throws Exception{
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        try {
            String result = bufferedReader.readLine();
            return result;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return "";
        }
        finally {
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(streamReader != null){
                streamReader.close();
            }
        }
    }
}

