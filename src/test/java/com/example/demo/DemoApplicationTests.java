package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = webAppContextSetup(wac).build();
    }

    @Test
    public void test() throws Exception {
        try {
            MvcResult result = mvc.perform(get("/"))
                    .andDo(print())
                    .andExpect(request().asyncStarted())
                    .andReturn();
            mvc.perform(asyncDispatch(result))
                    .andDo(print())
                    .andExpect(status().isOk());
        } catch (NullPointerException ex) {
            logger.error("", ex);
            throw ex;
        }
    }

}
