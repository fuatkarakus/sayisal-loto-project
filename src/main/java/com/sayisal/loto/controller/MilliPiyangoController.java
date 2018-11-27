package com.sayisal.loto.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayisal.loto.service.LotoService;

@RestController
@RequestMapping("/Cekilis")
public class MilliPiyangoController {

    public static final Logger LOGGER = LoggerFactory.getLogger(MilliPiyangoController.class);

    @Autowired
    LotoService lotoService;

    @GetMapping("/insertAll")
    public String insertAllLotoSonuc() throws Exception{
        ArrayList<String> dates = lotoService.getOldCekilisTarihleri();

        for(String date : dates){
            lotoService.insertLotoSonuc(lotoService.getLotoSonucMP(date));
            LOGGER.info(date+ " tarihli cekilis sonucu database'e kaydedildi.");
        }

        return dates.get(0);
    }
    

}
