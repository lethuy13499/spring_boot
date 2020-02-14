package global.testingsystem.service;

import java.util.List;


import org.springframework.data.repository.query.Param;


import global.testingsystem.DTO.ExamDto;
import global.testingsystem.DTO.QuestionDTO;
import global.testingsystem.entity.Exam;
import global.testingsystem.entity.Exam_Setting;
import global.testingsystem.entity.Question;
import global.testingsystem.entity.Users;

public interface ExamService {
	List<Object> list(String keySearch, String status);
	// trung

	List<ExamDto> listExam(String keySearch, String type, String examMode);

	// end trung
	// Mr Duc
	List<Object> listPracticeHomepage();

    Exam getExamById(int id);
	Exam insert(Exam exam);


	Object getExamByIDS(int id);

	// Mr Duc
	boolean delete(int id);

//	Exam getExamById(int id);
//
//	Integer insert(Exam exam);


//	int insertGetId(Exam exam);
//	boolean insert(Exam exam);
	Exam insertGetId(Exam exam);

	boolean update(Exam exam);

	Exam findById(int id);

	Exam findLastId();

	List<Object> listPractice(int user_id); // Practice: example with type=1

	void readExcel(String excelFilePath);

	void deleteObjectInvite(String list, String type, int examId);

	boolean InsertObjectInvite(String list, String type, int examId);

	List<Integer> getListQuestion(int id);

	Object getExamByCode(String code);

	List<Object> search(String key);

	List<Object> filterByType(String type);

	// ngo minh anh

	List<Object> getExamBySubjectId(int subId);

	List<Object> ranDomOneExamBySubject(int subId);

	Object getNumAndSubjectByExamId(int id);

	List<QuestionDTO> getListQuestionExam(int idExam);

	List<QuestionDTO> getListQuestionExamDetail(int idExam, int examUserId);

	int importUserExam(int exam, String excelFilePath);

	//
	List<Exam> getExamByExamDemo();

	List<Object> getExamCompletedByUser(int userId);
	
	List<Object> getExamByUserAndSubject(int userId, int subjectId);

	List<Exam> getExamByEntryTest();

	List<Exam> getExamByExamUser();

	List<Exam> getExam();

	List<Object> getExamUserByExamId(int id);
	//
	List<Exam> GetExamByExamMode(int exam_mode);
	
	ExamDto findByExamId(Integer id);
	
	List<String> getDomainsNameByExamId(int examId);
	
	List<String> getChaptersNameByExamId(int examId);

	List<Exam_Setting> getListExamSettingByExamId(int examId);
	
	List<Object> getRestUser(int id);
	List<Exam> getExamComingSoon(int userId);
	
	List<Exam> getListExam();
	
}
