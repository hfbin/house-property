package cn.hfbin.house.commom.model;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Blog {
  private Integer id;
  private String  tags;
  private String  content;
  private String  title;
  private Date    createTime;
  private String  digest;
  
  private List<String> tagList = Lists.newArrayList();
  

  
  

}
