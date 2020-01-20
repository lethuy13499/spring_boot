package global.testingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import global.testingsystem.entity.Welfare;
@Repository
public interface WelfareRepository extends JpaRepository<Welfare, Integer>{
//search by key
	@Query(value="select * from welfare where welfare.desciption LiKE CONTACT ('%',:key,'%') ", nativeQuery = true)
	public List<Welfare>searchByKey(@Param("key") String key);
// get list welfare 
	 @Query(value="select * from welfare where status = 1",nativeQuery = true)
	public List<Welfare> getAllWelfare();
	 
}
