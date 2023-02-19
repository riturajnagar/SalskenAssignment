package com.system.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.system.model.Student;

public interface StudentRepo extends ElasticsearchRepository<Student, Integer>{

}
