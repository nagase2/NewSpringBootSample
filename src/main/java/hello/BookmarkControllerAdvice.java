/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.VndErrors;
import org.springframework.hateoas.VndErrors.VndError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// tag::code[]
@ControllerAdvice
class BookmarkControllerAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors userNotFoundExceptionHandler(UserNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }

    
    @ResponseBody
    @ExceptionHandler(DontLikeTheNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    VndErrors dontLineTheNameExceptionHandler(DontLikeTheNameException ex) {
        
        VndError vnd1 = new VndError("logref1", "message1", new Link("http://www.yahoo.co.jp","info"));
        VndError vnd2 = new VndError("logref2", "message2", new Link("http://www.google.co.jp","error"));
        VndError vnd3 = new VndError("logref3", "message3");
        
        List<VndError> vList = new ArrayList<VndError>();
        vList.add(vnd1);
        vList.add(vnd2);
        vList.add(vnd3);
        
        return new VndErrors(vList);
    }
}
// end::code[]
