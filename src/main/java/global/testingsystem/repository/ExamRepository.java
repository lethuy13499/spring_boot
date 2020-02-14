

package global.testingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import global.testingsystem.entity.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
	@Query(value = " select e.id"
			+ ",e.name"
			+ ",s.name as subject_name"
			+ ", e.start_date"
			+ ", e.end_date,"
			+ " e.question_num, "
			+ "e.percent_passing,"
			+ "e.max_attempt,"
			+ " e.status,"
			+ "e.code,"
			+ " e.time, "
			+ "e.decription,"
			+ "e.title"
			+ ",e.media"
			+ ",e.creator_id" + 
			",e.type,"
			+ "e.create_type, "
			+ " e.subject_id " +
			"from exams e left outer join subjects s on e.subject_id = s.id left outer join users u on e.creator_id =u.id\r\n"
			+ "where (e.name like %:keySearch% or e.title like %:keySearch% or s.name like %:keySearch%) and e.type REGEXP :type\r\n"
			+ "order by e.id desc", nativeQuery = true)
			List<Object> list(@Param("keySearch") String keySearch,@Param("type") String type);
	

	@Query(value =
			"select e.id as domain_id, e.name as domain_name, s.name as subject_name, e.question_num, e.created_at, e.max_attempt " +
			"from exams e join subjects s on e.subject_id = s.id where e.creator_id =:creator_id and e.type = 0;", nativeQuery = true)
	List<Object> getListPractice(@Param("creator_id") int creator_id);


	@Query(value = "select a.id,a.name,a.question_num,a.time,b.id as subject_id,b.name as subject_name from exams a join subjects b on a.subject_id = b.id where a.type = 1 ORDER BY RAND() LIMIT 20;", nativeQuery = true)
			List<Object> listPracticeHomepage();
	@Query(value = "select * from exams e left outer join subjects s on e.subject_id = s.id where e.id =:exam_id", nativeQuery = true)
	Exam getExamByIDS(@Param("exam_id") int exam_id);

	
	Exam findFirstByOrderByIdDesc();
	
	@Query(value="select eq.question_id from exam_questions eq where eq.exam_id = :exam_id",nativeQuery=true)
	List<Integer> getListQuestion(@Param("exam_id") int exam_id);
	@Query(value="select e from exams e",nativeQuery=true)
	Object getExam(@Param("exam_id") int exam_id);
	
	@Query(value= "select *from exams where code =:code",nativeQuery=true)
	Object getExamByCode(@Param("code") String code);
	
	@Query(value = " select e.id"
			+ ",e.name"
			+ ",s.name as subject_name"
			+ ", e.start_date"
			+ ", e.end_date,"
			+ " e.question_num, "
			+ "e.percent_passing,"
			+ "e.max_attempt,"
			+ " e.status,"
			+ "e.code,"
			+ " e.time, "
			+ "e.decription,"
			+ "e.title"
			+ ",e.media"
			+ ",e.creator_id" + 
			",e.type,"
			+ "e.create_type, "
			+ " e.subject_id " +
			"from exams e left outer join subjects s on e.subject_id = s.id left outer join users u on e.creator_id =u.id "
			+ "where e.name like concat('%',:key,'%') "
			+ "or s.name like concat('%',:key,'%') "
			+ "or e.question_num like concat('%',:key,'%') "
			+ "or e.status like concat('%',:key,'%') "
			+ "or e.code like concat('%',:key,'%') "
			+ "order by e.id desc", nativeQuery = true)
	List<Object> search(@Param("key") String key);
	@Query(value = " select e.id"
			+ ",e.name"
			+ ",s.name as subject_name"
			+ ", e.start_date"
			+ ", e.end_date,"
			+ " e.question_num, "
			+ "e.percent_passing,"
			+ "e.max_attempt,"
			+ " e.status,"
			+ "e.code,"
			+ " e.time, "
			+ "e.decription,"
			+ "e.title"
			+ ",e.creator_id" + 
			",e.type,"
			+ "e.create_type, "
			+ " e.subject_id "
			+"from exams e left outer join subjects s on e.subject_id = s.id left outer join users u on e.creator_id =u.id "
			+ "where e.type like concat('%',:key,'%') "
			+ "order by e.id desc", nativeQuery = true)
	List<Object> filterByType(@Param("key") String key);

	@Query(value= "select * from exams as e where e.subject_id =:subId", nativeQuery = true)
	List<Object> getExamBySubjectId(@Param ("subId") int subId);
	@Query(value="SELECT e.id, e.name, e.code, e.subject_id, e.decription, e.question_num\r\n" + 
			"FROM exams as e where e.subject_id = :subId and e.exam_mode = 0 and e.status = 1 \r\n" + 
			"ORDER BY RAND()\r\n" + 
			"LIMIT 1", nativeQuery = true)
	List<Object> ranDomOneExamBySubject(@Param ("subId") int subId);
	



//	@Query(value ="  select e.id,e.name,s.name as subject_name,u.fullname, e.start_date, e.end_date,\r\n" + 
//			"			e.question_num,e.percent_passing,e.max_attempt,e.status,\r\n" + 
//			"			e.code,e.time,e.decription,e.title,e.creator_id,e.type,\r\n" + 
//			"			e.create_type,e.subject_id,e.exam_mode from exams e \r\n" + 
//			"           left outer join subjects s on e.subject_id = s.id \r\n" + 
//			"           left outer join users u on e.creator_id =u.id\r\n" + 
//			"			where (e.name like %:keySearch% or e.title like %:keySearch% or s.name like %:keySearch%)\r\n" + 
//			"           and e.type REGEXP :type\r\n"+ 
//			"           and e.exam_mode REGEXP :exam_mode" + 
//			"			order by e.id desc",nativeQuery = true )
	
	@Query(value ="      select e.id,e.name,s.name as subject_name,u.fullname, e.start_date, e.end_date,\r\n" + 
			"			 e.status,e.time, e.creator_id,e.type,e.subject_id,e.exam_mode from exams e \r\n" + 
			"            left outer join subjects s on e.subject_id = s.id \r\n" + 
			"            left outer join users u on e.creator_id =u.id\r\n" + 
			"			 where (e.name like %:keySearch% or e.title like %:keySearch% or s.name like %:keySearch%) \r\n" + 
			"            and e.type REGEXP :type and e.exam_mode REGEXP :exam_mode\r\n" + 
			"          	 order by e.id desc",nativeQuery = true )
	List<Object> listExam(@Param("keySearch") String keySearch,@Param("type") String type, @Param("exam_mode") String examMode);
	//end

	@Query(value="select ea.question_id from exam_answer ea where ea.exam_user_id =:exam_user_id",nativeQuery=true)
	List<Integer> getListQuestionResult(@Param("exam_user_id") int exam_user_id);


	@Query(value= "select question_num,subject_id from exams where id = :id",nativeQuery=true)
	Object getNumAndSubjectByExamId(@Param("id") int id);
	//
	@Query(value="select * from exams where type=1 and exam_mode=0 and status=1 order by id desc", nativeQuery = true)
	List<Exam>getExamByExamDemo();
	@Query(value="select*from exams where type=1 and exam_mode=1 and status=1 order by id desc", nativeQuery = true)
	List<Exam>getExamByEntryTest();
	@Query(value="select*from exams where type=1 and exam_mode=2 and status=1 order by id desc", nativeQuery = true)
	List<Exam>getExamByExamUser();
	@Query(value="select*from exams where type=1 and exam_mode=3 and CURDATE()-DATE(exams.end_date) <= 2 and DATE(exams.end_date)-CURDATE() >= 0 and status=1", nativeQuery = true)
	List<Exam>getExam();
	//
	 @Query(value = "select * from exams",nativeQuery = true)
	 List<Exam>getListExam();
	
	
	@Query(value ="select*from exams where type=1 and exam_mode=:exam_mode and status=1",nativeQuery = true)
	List<Exam>getExamByExamMode(@Param("exam_mode") int exam_mode );
	
	@Query(value="select * from exam_user where exam_id = :id and user_id is null ", nativeQuery = true)
	List<Object> getExamUser(int id);
	
	@Query(value="SELECT eu.id result_id,eu.exam_id,eu.user_id,e.name,e.title,eu.created_at,eu.completed,eu.total_score,eu.pass,e.max_attempt,e.question_num,eu.correct_num, eu.time,"
			+ "(select count(*) from exam_user where exam_user.exam_id = e.id and exam_user.user_id = :userId and exam_user.completed = 2) count FROM testing_online.exam_user eu  join exams e on eu.exam_id = e.id INNER JOIN\r\n" + 
			"( SELECT max(eu.id) max FROM testing_online.exam_user eu  join exams e on eu.exam_id = e.id where eu.user_id = :userId and e.type = 0 and e.exam_mode in (2,3)  group by eu.exam_id\r\n" + 
			") t2 on eu.id = t2.max"
			+ " where eu.user_id = :userId and e.type = 1 and e.exam_mode in (2,3)", nativeQuery = true)
	List<Object> getExamCompletedByUser(@Param("userId") int userId);
	
	@Query(value="SELECT eu.id result_id,eu.exam_id,eu.user_id,e.name,e.title,eu.created_at,eu.completed,eu.total_score,eu.pass,e.max_attempt,e.question_num,eu.correct_num, eu.time,"
			+ "(select count(*) from exam_user where exam_user.exam_id = e.id and exam_user.user_id = :userId and exam_user.completed = 2) count FROM testing_online.exam_user eu  join exams e on eu.exam_id = e.id INNER JOIN\r\n" + 
			"( SELECT max(eu.id) max FROM testing_online.exam_user eu  join exams e on eu.exam_id = e.id where eu.user_id = :userId and e.type = 0 and e.exam_mode in (2,3)  group by eu.exam_id\r\n" + 
			") t2 on eu.id = t2.max"
			+ " where eu.user_id = :userId and e.type = 1 and e.exam_mode in (2,3) and e.subject_id =:subjectId ", nativeQuery = true)
	List<Object> getExamByUserAndSubject(@Param("userId") int userId,@Param("subjectId") int subjectId);
	
	@Query(value="select * from exam_user where email like %:email% and exam_id = :exam", nativeQuery =  true)
	List<Object> checkExistEmail(int exam , String email);
	
	@Query(value= "select d.name from domains as d join exam_setting as e on d.id= e.domain_id where e.exam_id=:examId", nativeQuery = true)
	List<String> getDomainsNameByExamId(int examId);
	
	@Query(value= "select c.name from chapters as c join exam_setting as e on c.id= e.chapter_id where e.exam_id=:examId", nativeQuery = true)
	List<String> getChaptersNameByExamId(int examId);
	
	@Query(value="select count(*) from exam_user where exam_id=:idExam and completed=2", nativeQuery = true)
	Integer listUserTested(@Param("idExam") int idExam);
	
//	@Query(value= "SELECT * FROM testing_online.exam_user where exam_id=:examid", nativeQuery = true)
//	List<Exam_User> getUserByExam(int examId);
	
	@Query(value= "SELECT * FROM exams where id=:examid", nativeQuery = true)
	Exam getExamById(@Param("examid") int examId);
	
	@Query(value= "SELECT * FROM exams ex inner join exam_user eu on ex.id = eu.exam_id where \r\n" + 
			"(DATE(ex.end_date)-CURDATE() <= 3 and DATE(ex.end_date)-CURDATE() >= 0) \r\n" + 
			"and ex.type = 1 and eu.completed = 0 and ex.exam_mode in (2,3) and eu.user_id = :userId", nativeQuery = true)
	List<Exam> getExamComingSoon(@Param("userId") int userId);
} 