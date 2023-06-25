package com.hits.iternship.entities.comments;

import com.hits.iternship.entities.interviews.InterviewEntity;
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
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interviewId", referencedColumnName = "interviewId")
    InterviewEntity interviewEntity;

    Date timestamp;

    String text;
}