package com.ies.co.batch;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ies.co.entities.BatchRunDetails;
import com.ies.co.entities.CoTriggers;
import com.ies.co.repository.BatchRunRepository;
import com.ies.co.repository.CoRepository;

@Component
public class CoGenDlyBatch {
	@Autowired
	private BatchRunRepository batchRepo;

	@Autowired
	private CoRepository coRepository;

	public void preProcess() {
		BatchRunDetails batchRunDetails = new BatchRunDetails();

		LocalDateTime dateTime = LocalDateTime.now();
		Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
		batchRunDetails.setStartDate(date);
		batchRunDetails.setBatchRunStatus("starting");
		batchRepo.save(batchRunDetails);

	}

	public List<CoTriggers> start(String trgStatus) {

		List<CoTriggers> coTriggers = coRepository.findByTrgStatus(trgStatus);
		return coTriggers;
	}

	public void postProcess() {
		BatchRunDetails batchRunDetails = new BatchRunDetails();

		LocalDateTime dateTime = LocalDateTime.now();
		Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
		batchRunDetails.setEndDate(date);
		batchRunDetails.setBatchRunStatus("completed");
		batchRepo.save(batchRunDetails);

	}

}
