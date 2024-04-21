package com.nasifproject.pcbuilder;

import com.nasifproject.pcbuilder.reviews.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "Project")
// it will let framework know that each class represent each documents in the pc builds collection

@Data
// takes care of all getter setter
@AllArgsConstructor
// creating a constructor that takes all these private field as argument
@NoArgsConstructor
//takes no parameter
public class PcBuilds {

    @Id
    private ObjectId id;
    private String buildid;
    private String cost;
    private String build_category;
    private String CPU;
    private String Ram;

    private String Gpu;

    private String Monitor;

    private String Storage;

    private String Psu;

    private String Info;
    private String poster;
    private String Buildname;
    //    private  List<Review>  backdrops;
    private List<String> Details;
    private List<String> backdrops;
    @DocumentReference
    //only id ta store rakhbe , and review gula onno collection e rakhbe
    private  List<Review>  reviewIds;

    //manually to add buildlinks
    private String buildlinks;
    public String getBuildlinks() {
        return buildlinks;
    }

    public void setBuildlinks(String buildlinks) {
        this.buildlinks = buildlinks;
    }
    //manually to add buildlinks


}
