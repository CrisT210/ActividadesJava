package com.cristian.dojoverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cristian.dojoverflow.models.Answer;
import com.cristian.dojoverflow.models.Question;
import com.cristian.dojoverflow.models.Tag;
import com.cristian.dojoverflow.repositories.AnswerRepository;
import com.cristian.dojoverflow.repositories.QuestionRepository;
import com.cristian.dojoverflow.repositories.TagRepository;

@Service
public class DojoOverflowService {
	
	private final QuestionRepository qRepo;
	private final TagRepository tRepo;
	private final AnswerRepository aRepo;
	
	public DojoOverflowService(QuestionRepository qRepo, TagRepository tRepo, AnswerRepository aRepo) {
		this.qRepo = qRepo;
		this.tRepo = tRepo;
		this.aRepo = aRepo;
	}
	
	public List<Question> allQuestions(){
		return qRepo.findAll();
	}
	
	public List<Tag> allTags(){
		return tRepo.findAll();
	}
	
	public Question crearQuestion(Question q) {
		return qRepo.save(q);
	}

	public Tag crearTag(Tag t) {
		return tRepo.save(t);
	}
	
	public List<String> allTagNames(){
		List<String> tags = new ArrayList<>();
		for (Tag i : tRepo.findAll()) {
			tags.add(i.getSubject());
		}
		return tags;
	}
	
	public Tag searchTagName(String s) {
		return tRepo.findBySubject(s);
	}
	
	public Question infoQuestion(Long id) {
		Optional<Question> op = qRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	
	public void addTagQuestion(Tag tag, Question question) {
		if(question.getTags() == null) {
			List<Tag> t = new ArrayList<>();
			t.add(tag);
			question.setTags(t);
			qRepo.save(question);
			tRepo.save(tag);
		} else {
			question.getTags().add(tag);
			qRepo.save(question);
			tRepo.save(tag);
		}	
	}
	
	public Answer createAnswer(Answer a) {
		return aRepo.save(a);
		
	}
}
