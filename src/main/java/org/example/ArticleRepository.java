package org.example;

import java.util.List;

public interface ArticleRepository {
  ArticleId generateArticleId();

  List<Article> findAll();


  Article findById(ArticleId articleId);


  void createArticle(Article article);


  void update(Article article);


  void deleteArticle(ArticleId articleId);

}
