package com.sayisal.loto.service;

import com.sayisal.loto.model.LotoSonuc;
import com.sayisal.loto.repository.LotoSonucRepository;
import jdk.nashorn.internal.runtime.ECMAException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service("lotoService")
public class LotoService {

    public static final Logger LOGGER= LoggerFactory.getLogger(LotoService.class);
    @Autowired
    private LotoSonucRepository lotoSonucRepository;

    public List<LotoSonuc> getAllLotoSonuc() {
        return  lotoSonucRepository.findAll();
    }

    public void insertLotoSonuc(LotoSonuc lotoSonuc) {
        lotoSonucRepository.save(lotoSonuc);
    }

    public List<LotoSonuc> getAllRakamlar(){
        return lotoSonucRepository.findAllData_Rakamlar();
    }

    public LotoSonuc getLotoSonucByCekilisTarihi(String date){
        return lotoSonucRepository.findByData_CekilisTarihi(date);
    }

    public ArrayList<String> getOldCekilisTarihleri(){
        ArrayList<String> cekList = new ArrayList<>();
        try{
            File file = new ClassPathResource("dates.txt").getFile();
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                cekList.add(strLine);
            }
            br.close();
        }catch (Exception e){
            LOGGER.error(e.toString());
        }
        return cekList;
    }

    public LotoSonuc getLotoSonucMP(String date){
        String mpNewURI = "http://www.millipiyango.gov.tr/sonuclar/cekilisler/sayisal/SAY_" + date + ".json";
        String mpOldURI = "http://www.millipiyango.gov.tr/sonuclar/cekilisler/sayisal/" + date + ".json";
        RestTemplate restTemplate = new RestTemplate();
        LotoSonuc lotoSonuc = new LotoSonuc();
        try{
            lotoSonuc = restTemplate.getForObject(mpNewURI, LotoSonuc.class);
        }catch (Exception e){
            LOGGER.error("yeni url çalışmadı. " + e);
            try{
                lotoSonuc = restTemplate.getForObject(mpOldURI, LotoSonuc.class);
            }catch (Exception a){
               LOGGER.error("eski url de çalışmadı." + a);
            }
        }

        return lotoSonuc;
    }

}
