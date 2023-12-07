package com.net.stackthread.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tags")
public class Tag
{

   public Tag(String tag)
   {
      this.name = tag;
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false, unique = true)
   private String name;

   @Column(nullable = false)
   private Date createdAt = new Date();

   @ManyToMany(mappedBy = "tags")
   private Set<Post> posts = new HashSet<>();


   @Override
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Tag tag = (Tag) o;
      return Objects.equals(name, tag.name);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(name);
   }

}
