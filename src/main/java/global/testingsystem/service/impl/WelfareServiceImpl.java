package global.testingsystem.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import global.testingsystem.entity.Role;
import global.testingsystem.entity.Subject;
import global.testingsystem.entity.Welfare;
import global.testingsystem.repository.WelfareRepository;
import global.testingsystem.service.WelfareService;
@Service
public class WelfareServiceImpl implements WelfareService{
	private static Logger log = Logger.getLogger(WelfareServiceImpl.class);
	@Autowired
	private WelfareRepository repo;
	@Autowired
	private WelfareService repoService;
	@Override
	public List<Welfare> getAllWelfare() {
		return repo.getAllWelfare();
	}

	@Override
	public boolean addWelfare(Welfare welfare) {
		boolean isSuccess = false;
		Welfare addWelfare = repo.save(welfare);
		if (addWelfare != null) {
			isSuccess = true;
		} else {
			isSuccess = false;
			log.error("insert fall ");
		}
		
		return false;
	}

	@Override
	public boolean editWelfare(Welfare welfare) {
		boolean isSuccess = false;
		Welfare editWelfare = repo.save(welfare);
		if (editWelfare != null) {
			isSuccess = true;
		} else {
			isSuccess = false;
			log.error("update fall ");
		}
		return isSuccess;
		
	}

	@Override
	public Welfare findWelfareById(int welfareId) {
		
		for (Welfare welfare : repo.findAll()) {
			if (welfare.getWelfareId() == welfareId) {
				return welfare;
			}
		}
		return null;
	}

	@Override
	public List<Object> fiWelfareByDescription(String key) {
		return repoService.fiWelfareByDescription(key);
	}

	@Override
	public void deleteWelfare(Integer welfareId) {
		Welfare welfare = repo.getOne(welfareId);
		if (welfare != null) {
			if (welfare.getStatus() == 0) {
				welfare.setStatus(1);

			} else {
				welfare.setStatus(0);
			}
			repo.save(welfare);
		}
	}

}
