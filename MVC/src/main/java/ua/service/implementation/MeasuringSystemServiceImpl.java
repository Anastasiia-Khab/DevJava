package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.MeasuringSystem;
import ua.repository.MeasuringSystemRepository;
import ua.service.MeasuringSystemService;
@Service
public class MeasuringSystemServiceImpl implements MeasuringSystemService{

	@Autowired
	private MeasuringSystemRepository measuringSystemRepository;
	
	@Override
	public void delete(int id) {
		measuringSystemRepository.delete(id);
	}

	@Override
	public void save(String name) {
		MeasuringSystem system = new MeasuringSystem();
		system.setName(name);
		measuringSystemRepository.save(system);
	}

	@Override
	public List<MeasuringSystem> findAll() {
		return measuringSystemRepository.findAll();
	}

	@Override
	public MeasuringSystem findOne(int id) {
		return measuringSystemRepository.findOne(id);
	}
}