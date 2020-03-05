package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by lsy on 2020/3/5.
 */
@Controller
public class PicController {

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(@RequestBody Map<String,String> map)
    {
        String image = map.get("image");
        System.out.println(image);
        return "ok";
    }

}
