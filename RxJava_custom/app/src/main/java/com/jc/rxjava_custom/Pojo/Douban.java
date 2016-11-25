package com.jc.rxjava_custom.Pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jc on 11/25/2016.
 */

public class Douban {

    @SerializedName(value = "subjects")
    private List<Subjects> subjects;

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }
}
