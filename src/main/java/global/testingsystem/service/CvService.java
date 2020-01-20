package global.testingsystem.service;

import java.util.List;

import global.testingsystem.entity.CV;

public interface CvService {
	
	List<CV> getAllCv();
	
	boolean addCV(CV cv);
	
	boolean editCV(CV cv);
	
	CV findCVById(int cvId);
	
	List<CV> searchCVByPhone(String phone);
	
	List<CV> searchCVByEmail(String email);
	
	List<CV> searchCVByApplicant(String applicantName);
	
	List<CV> searhByStatus(int status);
	
	boolean deleteCv(int cvId);

}
