package global.testingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;

import global.testingsystem.entity.CV;

public interface CVRepository extends JpaRepository<CV, Integer>{
 
	//getAll CV
	@Query(value="select*from cv order by createdDate desc",nativeQuery = true)
	public List<CV> getAllCv();
	
	//findCvByEmail
	
	@Query(value="select*from cv where email=:email",nativeQuery = true)
	public List<CV> findCvByEmail(@Param("email") String email);
	
	//findCvByPhone
	
	@Query(value="select * from cv where phone=:phone",nativeQuery = true)
	public List<CV> findCvByPhone(@Param("phone") String phone);
	
	//findByApplicant
	
	@Query(value="select*from cv where applicant_name=:applicantName",nativeQuery = true)
	public List<CV> findCvByApplicant(@Param("applicantName") String applicantName);
	
	//findByStatus
	
	@Query(value="select * from cv where status=:status",nativeQuery = true)
	public List<CV> findCVByStatus(@Param("status") int status);
}
