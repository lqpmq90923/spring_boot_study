package com.pigman.pro;

import com.pigman.pro.web.HelloController;
import com.pigman.pro.web.PnTypeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ProApplicationTests {
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new PnTypeController()).build();
	}

	@Test
	public void testPnTypeController() throws Exception {
		// 测试UserController
		RequestBuilder request = null;

		// 1、get查一下user列表，应该为空
		request = get("/pntype/");
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[]")));

		// 2、post提交一个user
		request = post("/pntype/")
				.param("id", "1")
				.param("comments", "测试大师");
		mvc.perform(request)
				.andExpect(content().string(equalTo("success")));

		// 3、get获取user列表，应该有刚才插入的数据
		request = get("/pntype/");
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"id\":1,\"comments\":\"测试大师\"}]")));

		// 4、put修改id为1的user
		request = put("/pntype/1")
				.param("comments", "测试终极大师");
		mvc.perform(request)
				.andExpect(content().string(equalTo("success")));

		// 5、get一个id为1的user
		request = get("/pntype/1");
		mvc.perform(request)
				.andExpect(content().string(equalTo("{\"id\":1,\"comments\":\"测试终极大师\"}")));

		// 6、del删除id为1的user
		request = delete("/pntype/1");
		mvc.perform(request)
				.andExpect(content().string(equalTo("success")));

		// 7、get查一下user列表，应该为空
		request = get("/pntype/");
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[]")));

	}

}
