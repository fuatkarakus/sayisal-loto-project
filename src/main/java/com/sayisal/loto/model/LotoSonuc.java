package com.sayisal.loto.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "cekilis_sonuclar")
public class LotoSonuc {

    public LotoSonuc() {
    }
    @Id
    private ObjectId id;

    public Boolean success;

    public LotoData data;


}
