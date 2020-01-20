package global.testingsystem.service;

import java.util.List;

import global.testingsystem.entity.Job;

public interface JobService {
	
	List<Job> getAllJob();
	
	boolean addJob (Job job);
	
	boolean editJob (Job job);
	
	Job findJobById (int jobId);
	
	List<Job> FindJobByTitle(String title);
	
	List<Job> FindJobByKey(String key);
	
	List<Job> FindBySalary(String salary);
	
	List<Job> FinByStatus(int status);

}
