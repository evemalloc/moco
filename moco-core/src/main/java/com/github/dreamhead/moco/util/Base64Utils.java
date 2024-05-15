package com.github.dreamhead.moco.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.Objects;

public class Base64Utils {


    public static String decodeIfIsBase64String(String str){
        if(Objects.isNull(str)){
            return  str;
        }
        try {
            String tmpString =URLDecoder.decode(str,"utf-8");
            byte [] tempArrayByte= Base64.getDecoder().decode(tmpString);
            tmpString=new String(tempArrayByte);
            return  tmpString;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IllegalArgumentException  e){
//            e.printStackTrace();
        }

        return  str;
    }
}
