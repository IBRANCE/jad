package com.jad.jad.biz.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/decode")
public class DecodeController {

    private static final Logger logger = LoggerFactory.getLogger(DecodeController.class);

    @PostMapping("/get")
    public void get(@RequestBody Map<String, Object> bodyMap) {
        logger.info(bodyMap.toString());
        logger.error("end of get");
    }

}
