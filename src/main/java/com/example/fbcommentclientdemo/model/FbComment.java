package com.example.fbcommentclientdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

public @Data
@JsonIgnoreProperties(ignoreUnknown = true)
class FbComment {
    private String post;
    private List<CommentDetail> commentDetails;

}