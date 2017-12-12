package tujuh.suganda.repository.impl;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import tujuh.suganda.model.Student;
import tujuh.suganda.repository.StudentRepository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static final String KEY = "Student";
    
    private RedisTemplate<String, Student> redisTemplate;
    
    private HashOperations hashOps;
	
    @Override
	public void saveStudent(Student person) {
		 hashOps.put(KEY, person.getId(), person);
	}
}