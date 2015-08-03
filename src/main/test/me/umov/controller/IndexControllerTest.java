package me.umov.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import me.umov.controller.IndexController;
import me.umov.helper.MessageHelper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.caelum.vraptor.Result;

public class IndexControllerTest {

	@InjectMocks
	private IndexController controller;
	@Mock
	private Result result;
	@Mock
	private MessageHelper messages;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void shouldReturnCurrentVersionWhenCallingRootAction() {
		String version = "1.0";
		given(messages.getMessage("version")).willReturn(version);
		controller.index();
		verify(result).include("version", version);
	}

}
