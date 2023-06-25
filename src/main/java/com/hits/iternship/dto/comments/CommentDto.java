package com.hits.iternship.dto.comments;



import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {

    UserDto user;

    Date timestamp;

    String text;
}
