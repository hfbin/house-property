package cn.hfbin.house.web.controller;

import java.util.List;

import cn.hfbin.house.common.constants.CommonConstants;
import cn.hfbin.house.common.model.Blog;
import cn.hfbin.house.common.model.Comment;
import cn.hfbin.house.common.model.House;
import cn.hfbin.house.common.page.PageData;
import cn.hfbin.house.common.page.PageParams;
import cn.hfbin.house.core.service.BlogService;
import cn.hfbin.house.core.service.CommentService;
import cn.hfbin.house.core.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BlogController {
  
  @Autowired
  private BlogService blogService;
  
  @Autowired
  private CommentService commentService;
  
  @Autowired
  private RecommendService recommendService;
  
  @RequestMapping(value="blog/list",method={RequestMethod.POST,RequestMethod.GET})
  public String list(Integer pageSize, Integer pageNum, Blog query, ModelMap modelMap){
    PageData<Blog> ps = blogService.queryBlog(query, PageParams.build(pageSize, pageNum));
    List<House> houses =  recommendService.getHotHouse(CommonConstants.RECOM_SIZE);
    modelMap.put("recomHouses", houses);
    modelMap.put("ps", ps);
    return "/blog/listing";
  }
  
  @RequestMapping(value="blog/detail",method={RequestMethod.POST,RequestMethod.GET})
  public String blogDetail(int id,ModelMap modelMap){
    Blog blog = blogService.queryOneBlog(id);
    List<Comment> comments = commentService.getBlogComments(id,8);
    List<House> houses =  recommendService.getHotHouse(CommonConstants.RECOM_SIZE);
    modelMap.put("recomHouses", houses);
    modelMap.put("blog", blog);
    modelMap.put("commentList", comments);
    return "/blog/detail";
  }
}
