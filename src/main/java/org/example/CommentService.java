package org.example;


public class CommentService {
  private final CommentRepository commentRepository;

  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }


  public CommentId createComment(ArticleId articleId, String text) {
    CommentId commentId = commentRepository.generateCommentId();
    Comment comment = new Comment(commentId, articleId,  text);
    try {
      commentRepository.createComment(comment);
    } catch (ArticleIdDuplicatedException e) {
      throw new ArticleCreateException("Cannot create comment", e);
    }
    return commentId;
  }



  public void deleteComment(CommentId commentId) {
    try {
      commentRepository.deleteComment(commentId);
    } catch (CommentNotFoundException e) {
      throw new CommentDeleteException("Cannot delete comment with id=" + commentId, e);
    }
  }
}
