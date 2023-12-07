package com.net.stackthread.controllers;


import com.net.stackthread.entities.Comment;
import com.net.stackthread.entities.Post;
import com.net.stackthread.repositories.CommentRepository;
import com.net.stackthread.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/comments")
public class CommentController
{

   private final CommentRepository commentRepository;
   private final PostRepository postRepository;

   @Autowired
   public CommentController(CommentRepository commentRepository, PostRepository postRepository)
   {
      this.commentRepository = commentRepository;
      this.postRepository = postRepository;
   }

   @GetMapping("/{id}")
   public ResponseEntity<Comment> getCommentById(@PathVariable Long id)
   {
      Optional<Comment> optionalComment = commentRepository.findById(id);
      return optionalComment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }

   @GetMapping("/post/{postId}")
   public ResponseEntity<List<Comment>> getCommentsByPost(@PathVariable Long postId)
   {
      Optional<Post> optionalPost = postRepository.findById(postId);
      if (optionalPost.isPresent()) {
         List<Comment> comments = commentRepository.findByPost(optionalPost.get());
         return ResponseEntity.ok(comments);
      } else {
         return ResponseEntity.notFound().build();
      }
   }

   @PostMapping
   public ResponseEntity<Comment> createComment(@RequestBody Comment comment)
   {
      Comment savedComment = commentRepository.save(comment);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment updatedComment)
   {
      Optional<Comment> optionalComment = commentRepository.findById(id);
      if (optionalComment.isPresent()) {
         updatedComment.setId(id);
         Comment savedComment = commentRepository.save(updatedComment);
         return ResponseEntity.ok(savedComment);
      } else {
         return ResponseEntity.notFound().build();
      }
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteComment(@PathVariable Long id)
   {
      Optional<Comment> optionalComment = commentRepository.findById(id);
      if (optionalComment.isPresent()) {
         commentRepository.delete(optionalComment.get());
         return ResponseEntity.noContent().build();
      } else {
         return ResponseEntity.notFound().build();
      }
   }
}
