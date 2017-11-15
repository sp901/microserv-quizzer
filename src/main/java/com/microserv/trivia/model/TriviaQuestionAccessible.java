/*
 * The MIT License
 *
 * Copyright 2016 DJ Spiess.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.microserv.trivia.model;

import java.util.List;

/**
 * Interface for the data access to a trivia question database.
 * 
 * @author DJ Spiess
 */
public interface TriviaQuestionAccessible {
    TriviaQuestion getQuestionByIndex(long index);
    TriviaQuestion getQuestionById(long id);
    TriviaQuestion getRandomQuestion();
    List<TriviaQuestion> getQuestionList(long offset);
    List<TriviaQuestion> getSpecifiedQuestionList(long... id);
    long getQuestionListSize();
}