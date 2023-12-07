package com.net.stackthread.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "comments")
public class Comment
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "post_id", nullable = false)
   private Post post;

   @Lob
   @Column(nullable = false, columnDefinition = "CLOB")
   private String content;

   @Column(nullable = false)
   private Date createdAt = new Date();
}
