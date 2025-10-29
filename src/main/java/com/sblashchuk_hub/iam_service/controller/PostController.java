package com.sblashchuk_hub.iam_service.controller;

import com.sblashchuk_hub.iam_service.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostServiceImpl postServiceImpl;

    @Autowired
    public PostController(PostServiceImpl postServiceImpl) {
        this.postServiceImpl = postServiceImpl;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody Map<String, Object> requestBody) {
        String title = (String) requestBody.get("title");
        String content = (String) requestBody.get("content");

        String postContent = String.format("Title: %s\n Content: %s\n", title, content);

        postServiceImpl.createPost(postContent);

        return new ResponseEntity<>("Post created with title: " + title, HttpStatus.OK);
    }
}
