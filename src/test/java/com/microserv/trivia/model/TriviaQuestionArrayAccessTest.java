package com.microserv.trivia.model;

import org.junit.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class TriviaQuestionArrayAccessTest {
/**
 * Generally the pattern is usually we make the call and we build an object that 
 * matches what we expect. If the 2 are equal, we pass the test
 * 
 * Best Practice: Create test for each defect found in the system, then fix the bug
 */
	
    /**
     * Test of getQuestion method, of class TriviaQuestionArrayAccess.
     */
    @Test
    public void testGetQuestion() {
        System.out.println("getQuestion");
        long index = 1;
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();	// get a list of questions
        TriviaQuestion expResult = (new TriviaQuestionBuilder())
                .id(1)
                .question("What was the first toy advertised on television?")
                .answerA("The Rubix Cube")
                .answerB("Mr. Potato Head")
                .answerC("Barbie")
                .answerD("A hula hoop")
                .correctAnswer("B")
                .hint("Use your head on this one")
                .lastUpdated(new Date())
                .build();
        TriviaQuestion result = instance.getQuestionById(index);
        assertEquals("Trivia questions 1 do not match in ::getQuestion().", expResult.getId(), result.getId());
    }

    /**
     * Test of getRandomQuestion method, of class TriviaQuestionArrayAccess.
     */
    @Test
    public void testGetRandomQuestion() {
        System.out.println("getRandomQuestion");
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();
        TriviaQuestion result = instance.getRandomQuestion();
        assertNotNull("A random question was not returned in ::getRandomQuestion().", result);
    }

    /**
     * Test of getQuestionList method, of class TriviaQuestionArrayAccess.
     */
    @Test
    public void testGetQuestionList() {
        System.out.println("getQuestionList");
        long offset = 0L;
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();	
        List<TriviaQuestion> result = instance.getQuestionList(offset);	// get a list of questions
        
        assertNotNull("Trivia question list not returned in ::getQuestionList.", result);	// check that list is not null
        assertEquals(10, result.size());	// check to make sure size is 10
        // if these conditions are met, we assume the test pass
    }

    /**
     * Test of getQuestionListSize method, of class TriviaQuestionArrayAccess.
     */
    @Test
    public void testGetQuestionListSize() {
        System.out.println("getQuestionListSize");
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();
        long expResult = 11;
        long result = instance.getQuestionListSize();
        assertEquals("There should only be 11 trivia questions in ::getQuestionListSize.", expResult, result);
    }

    @Test
    public void getQuestionsBySpecifiedList(){

        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();

        List<TriviaQuestion> questionList = instance.getSpecifiedQuestionList(0L, 1L, 2L);

        List<Long> actual = questionList.stream()
                                        .map(TriviaQuestion::getId)
                                        .collect(Collectors.toList());

        List<Long> expected = Arrays.asList(0L, 1L, 2L);
        assertTrue(actual.containsAll(expected));

    }

}