package me.umov.controller;

import static br.com.caelum.vraptor.view.Results.http;
import static br.com.caelum.vraptor.view.Results.xml;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.mockito.Mock;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.Serializer;
import br.com.caelum.vraptor.serialization.XMLSerialization;
import br.com.caelum.vraptor.view.HttpResult;

public class ControllerTestBase {

	@Mock
	protected Result result;
	@Mock
	protected Serializer serializer;
	@Mock
	protected XMLSerialization xmlResult;
	@Mock
	private HttpResult httpResult;

	@Before
	public void setUp() {
		initMocks(this);
		given(result.use(xml())).willReturn(xmlResult);
		given(result.use(http())).willReturn(httpResult);
		given(xmlResult.from(any(Object.class))).willReturn(serializer);
		given(serializer.include(anyString())).willReturn(serializer);
	}
	
}
