package com.sblashchuk_hub.iam_service.controller;

import com.sblashchuk_hub.iam_service.service.CommentService;
import com.sblashchuk_hub.iam_service.service.impl.CommentServiceImpl;
import com.sblashchuk_hub.iam_service.service.impl.SecondCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public void setCommentService(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> addComment(@RequestBody Map<String, Object> requestBody) {
        String content = (String) requestBody.get("content");
        commentService.createComment(content);

        return new ResponseEntity<>("Comment added: " + content, HttpStatus.OK);
    }

    @PostMapping("/switchService")
    public ResponseEntity<String> switchToSecondService(@RequestBody Map<String, Object> requestBody) {
        this.commentService = new SecondCommentServiceImpl();

        String content = (String) requestBody.get("content");
        commentService.createComment(content);

        return new ResponseEntity<>("Switch to SecondService and added: " + content, HttpStatus.OK);
    }
}
