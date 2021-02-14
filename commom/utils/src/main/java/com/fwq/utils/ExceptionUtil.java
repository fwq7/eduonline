package com.fwq.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

    private static String getMessage(Exception e){

        StringWriter stringWriter = null;
        PrintWriter printWriter = null;
        try {
            stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);

            e.printStackTrace();
            printWriter.flush();
            stringWriter.flush();
        }finally {
            if(stringWriter!=null){
                try {
                    stringWriter.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }

            if(printWriter!=null){
                printWriter.close();
            }
        }
        return stringWriter.toString();
    }
}
