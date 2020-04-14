package Com.Mypackage.UnitTest;

import Com.Mypackage.StarUp;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)//底层用junit
@SpringBootTest(classes=StarUp.class)
@AutoConfigureMockMvc
public class MethodTest {

    @Autowired
    private MockMvc mockmvc;


    @Test
    public void testone() {
        System.out.println("test hello 1");
        TestCase.assertEquals(1, 1);
    }

    @Test
    public void apiTest() throws Exception {

        MvcResult Result=mockmvc.perform(MockMvcRequestBuilders.get("/api/User/getSetting"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int status=Result.getResponse().getStatus();
        System.out.println(status);


    }


    @Before
    public void testbefore() {
        System.out.println("test before");
        TestCase.assertEquals(1, 1);
    }

    @After
    public void testAfter() {
        System.out.println("test After");
        TestCase.assertEquals(1, 1);
    }

}
