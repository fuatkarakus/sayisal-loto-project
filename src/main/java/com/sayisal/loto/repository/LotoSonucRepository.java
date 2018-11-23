package com.sayisal.loto.repository;

import com.sayisal.loto.model.LotoSonuc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LotoSonucRepository extends MongoRepository<LotoSonuc,String>{

    @Query(value = "{}", fields = "{_id : 0, data.rakamlar : 1}")
    public List<LotoSonuc> findAllData_Rakamlar();

    //date format 'gg/aa/yyyy'
    @Query(value = "{ data.cekilisTarihi : ?1}")
    public LotoSonuc findByData_CekilisTarihi(String date);
}
