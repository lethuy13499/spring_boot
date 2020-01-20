package global.testingsystem.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.testingsystem.entity.CV;
import global.testingsystem.entity.Welfare;
import global.testingsystem.repository.CVRepository;
import global.testingsystem.service.CvService;
@Service
public class CVServiceImpl implements CvService{
	private static Logger log = Logger.getLogger(CVServiceImpl.class);
	@Autowired
	private CVRepository repo;
	@Override
	public List<CV> getAllCv() {
	
		return repo.getAllCv();
	}

	@Override
	public boolean addCV(CV cv) {
		boolean isSuccess = false;
		CV addCV = repo.save(cv);
		if (addCV != null) {
			isSuccess = true;
		} else {
			isSuccess = false;
			log.error("insert fall ");
		}
		
		return false;
	}

	@Override
	public boolean editCV(CV cv) {
		boolean isSuccess = false;
		CV editCV = repo.save(cv);
		if (editCV != null) {
			isSuccess = true;
		} else {
			isSuccess = false;
			log.error("insert fall ");
		}
		
		return false;
	}

	@Override
	public CV findCVById(int cvId) {
		for (CV cv : repo.findAll()) {
			if (cv.getCvId() == cvId) {
				return cv;
			}
		}
		return null;
	}

	@Override
	public List<CV> searchCVByPhone(String phone) {
	
		return repo.findCvByPhone(phone);
	}

	@Override
	public List<CV> searchCVByEmail(String email) {
		return repo.findCvByEmail(email);
	}

	@Override
	public List<CV> searchCVByApplicant(String applicantName) {
		return repo.findCvByApplicant(applicantName);
	}

	@Override
	public List<CV> searhByStatus(int status) {
		return repo.findCVByStatus(status);
	}

}
