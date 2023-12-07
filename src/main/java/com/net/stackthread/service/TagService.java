package com.net.stackthread.service;


import com.net.stackthread.dto.TagCustomDto;
import com.net.stackthread.entities.Tag;

import java.util.Set;


public interface TagService
{
   Set<TagCustomDto> findAll();

}
