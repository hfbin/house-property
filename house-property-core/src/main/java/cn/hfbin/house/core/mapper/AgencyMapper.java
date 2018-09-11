package cn.hfbin.house.core.mapper;

import java.util.List;

import cn.hfbin.house.common.model.Agency;
import cn.hfbin.house.common.model.User;
import cn.hfbin.house.common.page.PageParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface AgencyMapper {
  
    List<Agency> select(Agency agency);

    int insert(Agency agency);

    List<User>	selectAgent(@Param("user") User user, @Param("pageParams") PageParams pageParams);

	Long selectAgentCount(@Param("user") User user);

}
