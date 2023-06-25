package com.hits.iternship.dto.comments;

import lombok.Data;

public class CommentOnCreateDto {
    Integer userId;
    String text;

    public String getText() {
        return text;
    }
}
