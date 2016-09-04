package com.vasylieva.music_service.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Throwables;

/**
 * General error handler for the application.
 */
@ControllerAdvice
@RestController
public class MusicServiceExceptionHandler {

	/**
	 * Handle exceptions thrown by handlers.
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponseModel> exception(Exception exception, WebRequest request) {
		ModelAndView modelAndView = new ModelAndView("error/general");
		modelAndView.addObject("errorMessage", Throwables.getRootCause(exception));
		return new ResponseEntity<ErrorResponseModel>(new ErrorResponseModel(), HttpStatus.BAD_REQUEST);
	}
}