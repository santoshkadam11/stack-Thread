package com.net.stackthread.dto;


import lombok.Data;


@Data
public class CommentDto
{
   private Long id;
   private Long postId;
   private String content;
   private String createdAt;
}
