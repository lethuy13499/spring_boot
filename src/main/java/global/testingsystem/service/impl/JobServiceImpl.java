package global.testingsystem.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.testingsystem.entity.Job;
import global.testingsystem.entity.Role;
import global.testingsystem.repository.JobRepository;
import global.testingsystem.service.JobService;
@Service
public class JobServiceImpl implements JobService{
	private static Logger log = Logger.getLogger(JobServiceImpl.class);
	@Autowired
	private JobRepository repo;
	@Autowired
	private JobService service;

	@Override
	public List<Job> getAllJob() {
		
		return repo.getAllJob();
	}

	@Override
	public boolean addJob(Job job) {
	
		boolean isSuccess = false;
		Job addJob = repo.save(job);
		if (addJob != null) {
			isSuccess = true;
		} else {
			isSuccess = false;
			log.error("insert fall ");
		}
		return isSuccess;
	}

	@Override
	public boolean editJob(Job job) {
		
		boolean isSuccess = false;
		Job editJob = repo.save(job);
		if (editJob != null) {
			isSuccess = true;
		} else {
			isSuccess = false;
			log.error("insert fall ");
		}
		return isSuccess;
	}

	@Override
	public Job findJobById(int jobId) {
	
		for (Job job : repo.findAll()) {
			if (job.getJobId() == jobId) {
				return job;
			}
		}
		return null;
	}

	@Override
	public List<Job> FindJobByTitle(String title) {
		return  repo.findJobByTitle(title);
		
	}

	@Override
	public List<Job> FindJobByKey(String key) {
		
		return  repo.searchByKey();
	}

	@Override
	public List<Job> FindBySalary(String salary) {
		return  repo.findJobBySalary(salary);
	}

	@Override
	public List<Job> FinByStatus(int status) {
	
		return  repo.findJobByStatus(status);
	}

}
