package org.example;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Article {

  private final ArticleId id;
  private final String name;
  private final Set<String> tegs;
  private final List<Comment> comment;

  public Article(ArticleId id, String name, Set<String> tegs, List<Comment> comment) {
    this.id = id;
    this.name = name;
    this.tegs = tegs;
    this.comment = comment;
  }

  public Article withName(String newName) {
    return new Article(this.id, newName, this.tegs, this.comment);
  }

  public Article withTegs(Set<String> newTegs) {
    return new Article(this.id,this.name,  newTegs,this.comment );
  }
  public Article withComments(List<Comment> newComment) {
    return new Article(this.id,this.name,this.tegs,newComment );
  }

  public ArticleId getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Set<String> getTegs() {
    return tegs;
  }

  public List<Comment> getComment() {
    return comment;
  }


  @Override
  public String toString() {
    return "Article{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", tegs='" + tegs + '\'' +
            ", comment='" + comment + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Article article = (Article) o;
    return id == article.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

