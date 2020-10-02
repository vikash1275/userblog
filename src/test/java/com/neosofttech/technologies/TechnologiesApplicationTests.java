package com.neosofttech.technologies;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosofttech.technologies.Controller.UserController;
import com.neosofttech.technologies.Domain.User;
import com.neosofttech.technologies.Repository.UserRepository;
import com.neosofttech.technologies.Service.UserService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@AutoConfigureMockMvc
@ContextConfiguration(classes = {UserController.class})
@WebMvcTest
class TechnologiesApplicationTests {

	@Test
	void contextLoads() {
	}
        
        private MockMvc mockMvc;
        
        @Autowired
        private WebApplicationContext wac;
 
	@MockBean
	private UserService service;
        
         @Mock
         UserRepository mockRepository;
        
         @BeforeEach
         public void setup() {
         DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
         this.mockMvc = builder.build();         
         }
         
          private static final int id = 1;
          private static final String name = "vikash";
          
          @Test
	  public void testAddEmployee() throws Exception {
             
             User user=new User();
             user.setId(id);
             
             user.setName(name);
             
             when(mockRepository.save(any(User.class))).thenReturn(user);
             
             when(service.addUser(user)).thenReturn(user);
             
             assertNotNull(mockRepository.save(user));
             
             assertNotNull(user.getName());

             assertEquals(user.getId(), 1);
             
             Mockito.verify(mockRepository, times(1)).save(user);
             
           }
          
             @Test
	     public void testFindAllEmployee() throws Exception 
             {
                               
             User user1 = new User();
             
             User user2 = new User();
             
             user1.setId(id);
             user1.setName(name);
             
             user2.setId(id);
             user2.setName(name);
              
             List<User> user_list = new ArrayList<User>();
             
             user_list.add(user1);
             
             user_list.add(user2);
             
             when(mockRepository.findAll()).thenReturn(user_list);
             
             assertNotNull(mockRepository.findAll());

             Mockito.verify(mockRepository, times(1)).findAll();
             
             
           }
         
         public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	} 
        
        

}
