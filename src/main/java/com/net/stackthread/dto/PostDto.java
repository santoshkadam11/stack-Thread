package com.net.stackthread.dto;


import lombok.Data;

import java.util.List;
import java.util.Set;


@Data
public class PostDto
{
   private Long id;
   private String userName;
   private String title;
   private String content;
   private String codeContent;
   private Set<String> tags;
   private List<CommentDto> comments;

}
