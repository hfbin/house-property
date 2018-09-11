package cn.hfbin.house.core.mapper;

import java.util.List;

import cn.hfbin.house.common.model.Comment;
import cn.hfbin.house.common.model.Community;
import cn.hfbin.house.common.model.House;
import cn.hfbin.house.common.model.UserMsg;
import cn.hfbin.house.common.page.PageParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface CommentMapper {

  List<House> selectHouse(@Param("house") House query, @Param("pageParams") PageParams pageParams);

  Long selectHouseCount(@Param("house") House query);

  List<Community> selectCommunity(Community community);

  int insertUserMsg(UserMsg userMsg);

  int updateHouse(House house);

  int insert(Comment comment);

  List<Comment> selectComments(@Param("houseId") long houseId, @Param("size") int size);

  List<Comment> selectBlogComments(@Param("blogId") long blogId, @Param("size") int size);
  
}

