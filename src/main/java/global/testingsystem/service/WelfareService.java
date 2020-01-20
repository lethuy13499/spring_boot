package global.testingsystem.service;

import java.util.List;

import global.testingsystem.entity.Welfare;

public interface WelfareService {
	
	List<Welfare> getAllWelfare();
	
	boolean addWelfare (Welfare welfare);
	
	boolean editWelfare (Welfare welfare);
	
	Welfare findWelfareById(int welfareId);
	 
	List<Object> fiWelfareByDescription(String key);
	
	void deleteWelfare(Integer welfareId);
	

}
