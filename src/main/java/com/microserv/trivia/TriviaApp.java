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
package com.microserv.trivia;

import java.util.Date;
import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * JAX-RS application. Root path is /trivia
 *
 */
@ApplicationPath("/trivia")
@Path("")
public class TriviaApp extends Application {
	private final int BUILD_VERSION_NUMBER = 1;

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    /*
	 * Will return Links to the caller
	 * Links inform the caller what services are available
	 */
    public Response getDirectory(@Context UriInfo uri) {
    	
    	/*
    	 * Just a pointer to what url produced this response 
    	 */
        Link selfLink = Link.fromUri(uri.getBaseUri())
                .rel("self").type(MediaType.APPLICATION_JSON)
                .build();
        /*
         * The questionsLink will send to the client an endpoint link for them to use to get
         * the questions
         */
        Link questionsLink = Link.fromUri(uri.getBaseUri() + "questions")
                .rel("questions").type(MediaType.APPLICATION_JSON)
                .build();

        return Response.ok()
                .lastModified(new Date())
                .header("trivia-version", BUILD_VERSION_NUMBER)
                .location(uri.getRequestUri())
                .links(selfLink, questionsLink)
                .build();
    }

}