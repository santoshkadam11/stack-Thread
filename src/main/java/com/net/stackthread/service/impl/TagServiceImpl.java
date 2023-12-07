package com.net.stackthread.service.impl;


import com.net.stackthread.dto.TagCustomDto;
import com.net.stackthread.entities.Tag;
import com.net.stackthread.mapper.TagMapper;
import com.net.stackthread.repositories.TagRepository;
import com.net.stackthread.service.TagService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class TagServiceImpl
      implements TagService
{
   private final TagRepository tagRepository;
   private final TagMapper tagMapper;

   public TagServiceImpl(TagRepository tagRepository, TagMapper tagMapper)
   {
      this.tagRepository = tagRepository;
      this.tagMapper = tagMapper;
   }

   @Override
   public Set<TagCustomDto> findAll()
   {
      Set<TagCustomDto> tagCustomDtos = new HashSet<>();
      List<Tag> tags = tagRepository.findAll();
      tags.forEach(tag -> {
         tagCustomDtos.add(tagMapper.toDto(tag, new TagCustomDto()));
      });
      return tagCustomDtos;
   }
}
