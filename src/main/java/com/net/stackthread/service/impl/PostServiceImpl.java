package com.net.stackthread.service.impl;


import com.net.stackthread.config.TagSetToStringSetConverter;
import com.net.stackthread.dto.PostDto;
import com.net.stackthread.entities.Post;
import com.net.stackthread.entities.Tag;
import com.net.stackthread.entities.User;
import com.net.stackthread.mapper.PostMapper;
import com.net.stackthread.repositories.PostRepository;
import com.net.stackthread.repositories.TagRepository;
import com.net.stackthread.repositories.UserRepository;
import com.net.stackthread.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl
      implements PostService
{
   private final PostRepository postRepository;
   private final UserRepository userRepository;
   private final TagRepository tagRepository;
   private final PostMapper postMapper;

   public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, TagRepository tagRepository,
                          PostMapper postMapper)
   {

      this.postRepository = postRepository;
      this.userRepository = userRepository;
      this.tagRepository = tagRepository;
      this.postMapper = postMapper;
   }

   @Override
   public PostDto createPost(PostDto postDto)
   {
      Optional<User> user = Optional.ofNullable(userRepository.findByUsername(postDto.getUserName()));
      user.orElseThrow(() -> new RuntimeException("User not found"));

      Post mappedPost = postMapper.toEntity(postDto, new Post());


      List<Tag> tags = new ArrayList<>();
      if (postDto.getTags() != null) {
         postDto.getTags().forEach(tag -> {
            if (!tag.isEmpty()) {
               final String postTag = tag.trim().toUpperCase();
               Optional<Tag> tagOptional = Optional.ofNullable(tagRepository.findByName(postTag));
               tags.add(tagOptional.orElseGet(() -> tagRepository.save(new Tag(postTag))));
            }
         });
      }

      tags.forEach(mappedPost::addTag);
      mappedPost.setUser(user.get());
      postRepository.save(mappedPost);
     return postMapper.toDto(mappedPost, postDto);

   }

   @Override
   public List<PostDto> findAll()
   {
      List<Post> posts = postRepository.findAll();
      List<PostDto> postDtos = new ArrayList<>();
      posts.forEach(post -> postDtos.add(postMapper.toDto(post, new PostDto())));
      return postDtos;
   }
}
