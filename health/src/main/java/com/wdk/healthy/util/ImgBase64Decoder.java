package com.wdk.healthy.util;

import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class ImgBase64Decoder {

    /**
     * Base64解码为图片写入流
     * @param imgDatas
     * @param id
     * @param picNum
     * @return
     */
    public static  String photo( String imgDatas,String id,String picNum) {

        String bs = "data:image/png;base64,";
        String base = imgDatas.replace(bs, "");
        BASE64Decoder decoder = new BASE64Decoder();
        String imgFilePath=null;
        try {
            //解码
            byte[] b = decoder.decodeBuffer(base);
            for (int i = 0; i < b.length; ++i) {
                //调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            imgFilePath = "/root/img/" + id+ "_" + picNum + ".png";
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();

        } catch (Exception e) {
            return "error";
        }
        return imgFilePath;
    }
}
