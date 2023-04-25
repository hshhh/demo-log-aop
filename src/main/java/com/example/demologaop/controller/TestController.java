package com.example.demologaop.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public Dict test(@RequestParam(name="who") String who){
        String value = StrUtil.isBlank(who) ? "me" :who;
        return Dict.create().set("who",value);
    }

    @PostMapping("/testJson")
    public Dict testJson(@RequestBody Map<String,Object> map){
        final String jsonStr = JSONUtil.toJsonStr(map);
        log.info(jsonStr);
        return Dict.create().set("json",map);
    }
    @GetMapping("/testError")
    public Dict testError(){
        int i=0;
        return Dict.create().set("error",4/i);
    }



}
