package org.example;

import java.util.List;
import java.util.Set;

public class ArticleService {
  private final ArticleRepository articleRepository;

  public ArticleService(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  public List<Article> findAll() {
    return articleRepository.findAll();
  }

  public Article findById(ArticleId articleId) {
    try {
      return articleRepository.findById(articleId);
    } catch (ArticleNotFoundException e) {
      throw new ArticleFindException("Cannot find article by id=" + articleId, e);
    }
  }

  public ArticleId createArticle(String name, Set<String> tegs, List<Comment> comment) {
    ArticleId articleId = articleRepository.generateArticleId();
    Article article = new Article(articleId, name, tegs, comment);
    try {
      articleRepository.createArticle(article);
    } catch (ArticleIdDuplicatedException e) {
      throw new ArticleCreateException("Cannot create article", e);
    }
    return articleId;
  }

  public void update(ArticleId articleId, String name, Set<String> tegs, List<Comment> comment) {
    Article article;
    try {
      article = articleRepository.findById(articleId);
    } catch (ArticleNotFoundException e) {
      throw new ArticleUpdateException("Cannot find article with id=" + articleId, e);
    }

    try {
      articleRepository.update(
              article.withName(name)
                      .withTegs(tegs)
                      .withComments(comment)
      );
    } catch (ArticleNotFoundException e) {
      throw new ArticleUpdateException("Cannot update article with id=" + articleId, e);
    }
  }

  public void deleteArticle(ArticleId articleId) {
    try {
      articleRepository.deleteArticle(articleId);
    } catch (ArticleNotFoundException e) {
      throw new ArticleDeleteException("Cannot delete article with id=" + articleId, e);
    }
  }
}
