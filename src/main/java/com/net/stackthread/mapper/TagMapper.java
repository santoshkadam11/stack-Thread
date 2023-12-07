package com.net.stackthread.mapper;


import com.net.stackthread.dto.TagCustomDto;
import com.net.stackthread.entities.Tag;
import org.springframework.stereotype.Component;


@Component
public class TagMapper
      implements Mapper<TagCustomDto, Tag>
{
   @Override
   public TagCustomDto toDto(Tag source, TagCustomDto destination)
   {
      destination.setTagName(source.getName());
      destination.setTagCount(source.getPosts().size());
      return destination;
   }

   @Override
   public Tag toEntity(TagCustomDto source, Tag destination)
   {
      return null;
   }
}
