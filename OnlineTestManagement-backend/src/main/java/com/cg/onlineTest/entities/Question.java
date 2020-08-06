package com.cg.onlineTest.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "QUESTIONS_TABLE")
public class Question implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "Question_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long questionId;
	
	@ElementCollection  
	@Column(name = "Question_Options")
	private Set<String> questionOptions;
	
	@Column(name = "Question_Title")
	private String questionTitle;
	
	@Column(name = "Question_Answer")
	private int questionAnswer;
	
	@Column(name = "Question_Marks")
	private long questionMarks;
	
	@Column(name = "Chosen_Answer")
	private int chosenAnswer;
	
	@Column(name = "Marks_scored")
	private long marksScored;
	
	@Column(name = "Question_category")
	private Category questionCategory;
	
	@ManyToOne(fetch =  FetchType.EAGER)
	@JoinColumn(name="Test_Id")
	private Test testQuestions;
	
	public Question() {
		
	}

	public Question(long questionId, Set<String> questionOptions, String questionTitle, int questionAnswer,
			long questionMarks, int chosenAnswer, long marksScored, Category questionCategory) {
		super();
		this.questionId = questionId;
		this.questionOptions = questionOptions;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksScored = marksScored;
		this.questionCategory = questionCategory;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public Set<String> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(Set<String> questionOptions) {
		this.questionOptions = questionOptions;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public int getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public long getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(long questionMarks) {
		this.questionMarks = questionMarks;
	}

	public int getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	public long getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(long marksScored) {
		this.marksScored = marksScored;
	}

	public Category getQuestionCategory() {
		return questionCategory;
	}

	public void setQuestionCategory(Category questionCategory) {
		this.questionCategory = questionCategory;
	}

	public Test getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(Test testQuestions) {
		this.testQuestions = testQuestions;
	}

	
	
	
	
	

}
