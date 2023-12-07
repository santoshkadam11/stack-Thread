package com.net.stackthread.mapper;


import com.net.stackthread.dto.CommentDto;
import com.net.stackthread.dto.PostDto;
import com.net.stackthread.entities.Post;
import com.net.stackthread.entities.Tag;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class PostMapper
      implements Mapper<PostDto, Post>
{


   @Override
   public PostDto toDto(Post source, PostDto postDto)
   {
      postDto.setId(source.getId());
      postDto.setUserName(source.getUser().getUsername());
      postDto.setTitle(source.getTitle());
      postDto.setContent(source.getContent());
      postDto.setCodeContent(source.getCodeContent());
      postDto.setTags(source.getTags().stream().map(Tag::getName).collect(Collectors.toSet()));
      postDto.setComments(source.getComments().stream().map(comment -> new CommentMapper().toDto(comment, new CommentDto()))
            .collect(Collectors.toList()));
      return postDto;
   }

   @Override
   public Post toEntity(PostDto source, Post post)
   {
      post.setId(source.getId());
      post.setTitle(source.getTitle());
      post.setContent(source.getContent());
      post.setCodeContent(source.getCodeContent());
      return post;
   }
}
