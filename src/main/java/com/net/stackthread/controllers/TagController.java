package com.net.stackthread.controllers;


import com.net.stackthread.dto.PostDto;
import com.net.stackthread.dto.TagCustomDto;
import com.net.stackthread.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/tags")
public class TagController
{

   private final TagService tagService;

   public TagController(TagService tagService)
   {

      this.tagService = tagService;
   }

   @GetMapping
   public ResponseEntity<Set<TagCustomDto>> getAllTags()
   {
      Set<TagCustomDto> tags = tagService.findAll();
      return ResponseEntity.ok(tags);
   }
}
