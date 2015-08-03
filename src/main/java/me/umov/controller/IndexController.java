package me.umov.controller;

import javax.inject.Inject;

import me.umov.helper.MessageHelper;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	@Inject
	private Result result;
	@Inject
	private MessageHelper messages;

	@Get("/")
	public void index() {
		result.include("version", messages.getMessage("version"));
	}

}
