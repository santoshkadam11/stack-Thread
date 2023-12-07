package com.net.stackthread.config;


import com.net.stackthread.entities.Tag;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class TagSetToStringSetConverter
      extends AbstractConverter<Set<Tag>, Set<String>>
{
   @Override
   protected Set<String> convert(Set<Tag> source)
   {

      return source.stream().map(Tag::getName).collect(Collectors.toSet());

   }
}
