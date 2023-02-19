package com.system.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.system.model.Student;
import com.system.repository.StudentRepo;

@Controller
public class StudentUIController {

	@Autowired
	private StudentRepo studentRepo;

	@GetMapping("/getAllStudents")
	public String getAllStudents(Model model) {
		Iterable<Student> itr = studentRepo.findAll();

		List<Student> students = new ArrayList<>();
		itr.forEach(students::add);

		model.addAttribute("mydata", students);

		return "result";

	}

	@PostMapping("addStudent")
	public String addStudents(@RequestBody Student student) {
		studentRepo.save(student);
		return "result";
	}

	@GetMapping("averagePercantage")
	public String averagePercentage(Model model) {
		List<Integer> marks = new ArrayList<>();

		Iterable<Student> itr = studentRepo.findAll();

		List<Student> students = new ArrayList<>();
		itr.forEach(students::add);

		for (Student s : students) {
			if (s.getSemester() == 2) {
				int marksSum = 0;
				marksSum += s.getEnglish() + s.getMaths() + s.getScience();
				marks.add(marksSum);
			}
		}

		int average = 0;
		int sum = 0;
		for (Integer i : marks) {
			sum += i;
		}

		average = sum / marks.size();

		model.addAttribute("mydata", average);

		return "averagePercentage";

	}

	@GetMapping("topTwoStudent")
	public String topTwoStudent(Model model) {

		HashMap<Integer, Integer> top = new LinkedHashMap<>();

		Iterable<Student> itr = studentRepo.findAll();

		List<Student> students = new ArrayList<>();
		itr.forEach(students::add);

		for (Student s : students) {

			int marksSum = 0;
			marksSum += s.getEnglish() + s.getMaths() + s.getScience();
			marksSum = marksSum/3;
			top.put(s.getRollNum(), marksSum);

		}
		List<Integer> top2 = new ArrayList<>();
		
		LinkedHashMap<Integer, Integer> sortedMap = top.entrySet()
			    .stream()
			    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			    .collect(Collectors.toMap(
			        Map.Entry::getKey,
			        Map.Entry::getValue,
			        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		
		top2.add(sortedMap.get(0));
		top2.add(sortedMap.get(1));
		
		model.addAttribute("mydata", top);
		
		return "topTwoStudent";
	}

}
