package com.net.stackthread.mapper;


import com.net.stackthread.dto.CommentDto;
import com.net.stackthread.entities.Comment;


public class CommentMapper implements Mapper<CommentDto, Comment>
{
   @Override
   public CommentDto toDto(Comment source, CommentDto destination)
   {
      destination.setId(source.getId());
      destination.setPostId(source.getPost().getId());
      destination.setContent(source.getContent());
      destination.setCreatedAt(source.getCreatedAt().toString());
      return destination;
   }

   @Override
   public Comment toEntity(CommentDto source, Comment destination)
   {
      destination.setId(source.getId());
      destination.setContent(source.getContent());
      return destination;
   }
}
