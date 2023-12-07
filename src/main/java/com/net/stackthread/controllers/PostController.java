package com.net.stackthread.controllers;


import com.net.stackthread.dto.PostDto;
import com.net.stackthread.entities.Post;
import com.net.stackthread.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController
{
   private final PostService postService;


   public PostController(PostService postService)
   {
      this.postService = postService;

   }

   @PostMapping
   public ResponseEntity<PostDto> createPost(@RequestBody PostDto post)
   {
      PostDto postDto = postService.createPost(post);
      return ResponseEntity.ok(postDto);
   }

   @GetMapping
   public ResponseEntity<List<PostDto>> getAllPosts()
   {
      List<PostDto> posts = postService.findAll();
      return ResponseEntity.ok(posts);
   }


}
