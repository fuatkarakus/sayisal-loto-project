package com.sayisal.loto.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cekilis_sonuclar")
public class LotoSonuc {

    public LotoSonuc() {
    }
    @Id
    private ObjectId id;

    public String success;

    public LotoData data;


}
