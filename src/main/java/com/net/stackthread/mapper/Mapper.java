package com.net.stackthread.mapper;


public interface Mapper<D, E>
{
   D toDto(E source, D destination);

   E toEntity(D source, E destination);

}
