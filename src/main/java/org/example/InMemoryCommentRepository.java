package org.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryCommentRepository implements CommentRepository{
  private final AtomicLong nextId = new AtomicLong(0);
  private final Map<CommentId, Comment> commentMap = new ConcurrentHashMap<>();
  @Override
  public CommentId generateCommentId() {
    return new CommentId(nextId.incrementAndGet());
  }

  @Override
  public synchronized void createComment(Comment comment) {
    if (commentMap.get(comment.getId()) != null) {
      throw new CommentIdDuplicatedException("Comment with the given id already exists: " + comment.getId());
    }
    commentMap.put(comment.getId(), comment);
  }

  @Override
  public void deleteComment(CommentId commentId) {
    if (commentMap.remove(commentId) == null) {
      throw new CommentNotFoundException("Cannot find comment by id=" + commentId);
    }
  }
}
