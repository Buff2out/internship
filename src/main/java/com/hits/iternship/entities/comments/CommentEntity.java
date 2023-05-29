package com.hits.iternship.entities.comments;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
//import java.util.List;

@Data
@Entity
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(insertable=false, updatable=false)
    Integer commentId;

    //    String interviewId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId", referencedColumnName = "authorId")
    AuthorEntity author;
    Date timestamp;

    String text;
}