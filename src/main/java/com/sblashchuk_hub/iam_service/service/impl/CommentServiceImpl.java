package com.sblashchuk_hub.iam_service.service.impl;

import com.sblashchuk_hub.iam_service.service.CommentService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class CommentServiceImpl implements CommentService {

    private final List<String> comments = new ArrayList<>();

    @Override
    public void createComment(String commentContent) {
        comments.add(commentContent);
        System.out.println("Standard comment created: " + commentContent.toUpperCase());
    }
}
