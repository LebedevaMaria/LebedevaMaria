package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


public class InMemoryArticleRepository implements ArticleRepository{
  private final AtomicLong nextId = new AtomicLong(0);
  private final Map<ArticleId, Article> articleMap = new ConcurrentHashMap<>();

  @Override
  public ArticleId generateArticleId() {
    return new ArticleId(nextId.incrementAndGet());
  }

  @Override
  public List<Article> findAll() {
    return new ArrayList<>(articleMap.values());
  }

  @Override
  public Article findById(ArticleId articleId) {
    Article article = articleMap.get(articleId);
    if (article == null) {
      throw new ArticleNotFoundException("Cannot find article by id=" + articleId);
    }
    return article;
  }

  @Override
  public synchronized void createArticle(Article article) {
    if (articleMap.get(article.getId()) != null) {
      throw new ArticleIdDuplicatedException("Article with the given id already exists: " + article.getId());
    }
    articleMap.put(article.getId(), article);
  }

  @Override
  public synchronized void update(Article article) {
    if (articleMap.get(article.getId()) == null) {
      throw new ArticleNotFoundException("Cannot find article by id=" + article.getId());
    }
    articleMap.put(article.getId(), article);
  }

  @Override
  public void deleteArticle(ArticleId articleId) {
    if (articleMap.remove(articleId) == null) {
      throw new ArticleNotFoundException("Cannot find book by id=" + articleId);
    }
  }
}
