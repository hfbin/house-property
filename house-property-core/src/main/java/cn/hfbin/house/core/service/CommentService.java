package cn.hfbin.house.core.service;

import java.util.List;

import cn.hfbin.house.common.constants.CommonConstants;
import cn.hfbin.house.common.model.Comment;
import cn.hfbin.house.common.model.User;
import cn.hfbin.house.common.utils.BeanHelper;
import cn.hfbin.house.core.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CommentService {
  
  @Autowired
  private CommentMapper commentMapper;
  
  @Autowired
  private UserService userService;

  public void addHouseComment(Long houseId, String content, Long userId) {
    addComment(houseId,null, content, userId,1);
  }

  @Transactional(rollbackFor=Exception.class)
  private void addComment(Long houseId,Integer blogId, String content, Long userId,int type) {
    Comment comment = new Comment();
    if (type == 1) {
      comment.setHouseId(houseId);
    }else {
      comment.setBlogId(blogId);
    }
    comment.setContent(content);
    comment.setUserId(userId);
    comment.setType(type);
    BeanHelper.onInsert(comment);
    BeanHelper.setDefaultProp(comment, Comment.class);
    commentMapper.insert(comment);
  }

  public List<Comment> getHouseComments(long houseId,int size) {
    List<Comment> comments = commentMapper.selectComments(houseId,size);
    comments.forEach(comment -> {
       User user = userService.getUserById(comment.getUserId());
       comment.setAvatar(user.getAvatar());
       comment.setUserName(user.getName());
    });
    return comments;
  }

  public List<Comment> getBlogComments(long blogId, int size) {
    List<Comment> comments = commentMapper.selectBlogComments(blogId,size);
    comments.forEach(comment -> {
       User user = userService.getUserById(comment.getUserId());
       comment.setUserName(user.getName());
       comment.setAvatar(user.getAvatar());
    });
    return comments;
  }

  public void addBlogComment(int blogId, String content, Long userId) {
    addComment(null,blogId, content, userId, CommonConstants.COMMENT_BLOG_TYPE);
  }
  
  

}
