package cn.hfbin.house.core.mapper;

import java.util.List;

import cn.hfbin.house.common.model.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

	public List<User>  selectUsers();
	
	public int insert(User account);

	public int delete(String email);

	public int update(User updateUser);

	public List<User> selectUsersByQuery(User user);
}
