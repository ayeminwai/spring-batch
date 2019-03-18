package com.v6team.amw.springbatch.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class stockController {
	@Autowired
	JobLauncher jobLaunchar;
	
	@Autowired
	Job job;
	
	@GetMapping
	public BatchStatus stock() throws JobParametersInvalidException,JobExecutionException {
		Map<String, JobParameter> maps = new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters parameters = new JobParameters(maps);
		JobExecution jobExecution = jobLaunchar.run(job, parameters);
		
		System.out.println(jobExecution);
		while (jobExecution.isRunning()) {
			System.out.println("...");
			
		}
		return jobExecution.getStatus();
	}
	
}
