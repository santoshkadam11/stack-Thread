package com.net.stackthread.service;


import com.net.stackthread.dto.PostDto;

import java.util.List;


public interface PostService
{
   PostDto createPost(PostDto postDto);

   List<PostDto> findAll();
}
