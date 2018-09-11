package cn.hfbin.house.core.mapper;

import java.util.List;

import cn.hfbin.house.common.model.Blog;
import cn.hfbin.house.common.page.PageParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface BlogMapper {

  public List<Blog> selectBlog(@Param("blog") Blog query, @Param("pageParams") PageParams params);

  public Long selectBlogCount(Blog query);

}
