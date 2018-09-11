package cn.hfbin.house.core.mapper;

import java.util.List;

import cn.hfbin.house.common.model.*;
import cn.hfbin.house.common.page.PageParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HouseMapper {

    public List<House>  selectPageHouses(@Param("house") House house, @Param("pageParams") PageParams pageParams);
    
    public Long selectPageCount(@Param("house") House query);
	
	public int insert(User account);

	public List<Community> selectCommunity(Community community);

	public int insert(House house);

	public HouseUser selectHouseUser(@Param("userId") Long userId, @Param("id") Long houseId, @Param("type") Integer integer);
	
	public HouseUser selectSaleHouseUser(@Param("id") Long houseId);

	public int insertHouseUser(HouseUser houseUser);

	public int insertUserMsg(UserMsg userMsg);

	public int updateHouse(House updateHouse);
	
	public  int downHouse(Long id);

	public int deleteHouseUser(@Param("id") Long id, @Param("userId") Long userId, @Param("type") Integer value);
	
}
