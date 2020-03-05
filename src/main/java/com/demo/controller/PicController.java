package com.demo.controller;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * Created by lsy on 2020/3/5.
 */
@Controller
public class PicController {

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(@RequestBody Map<String,String> map) throws IOException
    {
        String image = map.get("image");
        String s = fileToPath(image);
        return s;
    }

    public String fileToPath(String file) throws IOException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileTrueName = new Random().nextInt(9000) + sf.format(new Date())+".jpg";
        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        String filePath = jarF.getParentFile().toString() +  "\\images";
        File f = new File(filePath);
        if(!f.exists()){
            f.mkdirs(); //创建目录
        }
        String fileFullName = filePath +"\\"+ fileTrueName;
        File filePic = new File(fileFullName);
        filePic.createNewFile();
        byte[] byteImgData1 = null;
        BASE64Decoder base64Decoder = new BASE64Decoder();
        String goodDetail = file.replaceFirst("data:(.+?);base64,", "");
        byteImgData1 = base64Decoder.decodeBuffer(goodDetail);
        OutputStream outputStream1 = new FileOutputStream(filePic);
        outputStream1.write(byteImgData1);
        outputStream1.flush();
        outputStream1.close();
        return fileFullName;

    }

    public static void main(String[] args)
    {
//        PicController picController = new PicController();
//        String s = picController.fileToPath("pic.jpg");
//        System.out.println(s);
    }
}
