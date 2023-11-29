package org.example;

public interface CommentRepository {
  CommentId generateCommentId();

  void createComment(Comment comment);

  void deleteComment(CommentId commentId);
}
