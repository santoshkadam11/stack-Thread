package com.net.stackthread.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;


@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id", nullable = false)
   private User user;

   @Column(nullable = false)
   private String title;

   @Lob
   @Column(columnDefinition = "CLOB", nullable = false)
   private String content;

   @Lob
   @Column(columnDefinition = "CLOB")
   private String codeContent;

   @Column(nullable = false)
   private Date createdAt = new Date();

   @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
   private Set<Comment> comments = new HashSet<>();

   @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
   @JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
   private Set<Tag> tags = new HashSet<>();

   public void addTag(Tag tag)
   {
      tags.add(tag);
      tag.getPosts().add(this);

   }

   public void removeTag(Tag tag)
   {
      tags.remove(tag);
      tag.getPosts().remove(this);
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if (!(o instanceof Post))
         return false;
      return id != null && id.equals(((Post) o).getId());
   }

   @Override
   public int hashCode()
   {
      return getClass().hashCode();
   }
}
