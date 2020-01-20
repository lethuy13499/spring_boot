package global.testingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import global.testingsystem.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{

	//getAll job
	@Query(value="select*from job where status =1 order by created DESC ",nativeQuery=true)
	List<Job>getAllJob();
	
	// search job by key
	@Query(value="select * from job where  job.job_title like concat('%',:key,'%') or "
			+ "job.decription like concat('%',:key,'%') "
			+ "job.requitment like concat('%',:key,'%')",nativeQuery = true)
	List<Job> searchByKey();
	
	//findJobByWelfare
//	@Query(value="select job.job_id ,job.description ,job.job_title,job.requitment,job.salary,job.status ,welfare.welfare_id from job inner join welfare on job.welfare_id = welfare.welfare_id where welfare_id=:welfareId")
//	List<Object> getJobByWelfareId(@Param("welfareId")int welfareId);
	
	//FindJobByTitle
	@Query(value="select * from job where job.job_title=:title",nativeQuery = true)
	List<Job> findJobByTitle(@Param("title") String title);
	
	//findJobBySalary
	@Query(value="select * from job where job.salary=:salary",nativeQuery = true)
	List<Job> findJobBySalary(@Param("salary") String salaries);
	
	//findJobByStatus
	
	@Query(value="select*from job where job.status=:status",nativeQuery = true)
	List<Job> findJobByStatus(@Param("status")int status);
}
