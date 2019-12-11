package com.example.fbcommentclientdemo.controller;

import com.example.fbcommentclientdemo.model.FbComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/client/comments")
public class CommentClientController {
    private final String url="http://localhost:8080/comments";

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping
    public List<FbComment> getCommentUsers(){
        ResponseEntity<List<FbComment>> response=restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<FbComment>>() {
        });
        List<FbComment> fbComments = response.getBody();
        return fbComments;
    }

    @GetMapping("/latest")
    public List<FbComment> getLatestCommentUsers(){
        ResponseEntity<List<FbComment>> response=restTemplate.exchange(url+"/latest", HttpMethod.GET, null, new ParameterizedTypeReference<List<FbComment>>() {
        });
        List<FbComment> fbComments = response.getBody();
        return fbComments;
    }
}
