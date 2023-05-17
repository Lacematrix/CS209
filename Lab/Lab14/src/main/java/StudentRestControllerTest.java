//import com.example.mvcdemo.model.Student;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class StudentRestControllerTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @Order(1)
//    @Test
//    void getOneStudent() throws Exception {
//        mvc.perform(get("/api/students/getOne/{id}",1))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Mary"))
//                .andDo(print());
//    }
//
//    @Order(3)
//    @Test
//    void addOneStudent() throws Exception {
//        Student stu = new Student("Jack", "jack@mail.com");
//        ObjectMapper mapper = new ObjectMapper();
//
//        // convert user to JSON
//        String json = mapper.writeValueAsString(stu);
//
//        // send POST request to create user
//        mvc.perform(post("/api/students/save")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isOk());
//
//        // verify that user was indeed created
//        mvc.perform(get("/api/students/getOne/{id}",4))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is(stu.getName())))
//                .andExpect(jsonPath("$.email", is(stu.getEmail())));
//    }
//
//
//    @Order(2)
//    @Test
//    void getAllStudents() throws Exception {
//        mvc.perform(get("/api/students")).
//                andExpect(status().isOk()).
//                andExpect(jsonPath("$.*", hasSize(3))); // ensure 3 students are returned
//
//    }
//
//    @Order(4)
//    @Test
//    void getStudentsByEmail() throws Exception {
//        mvc.perform(get("/api/students/?email={email}", "jack")).
//                andExpect(status().isOk()).
//                andExpect(jsonPath("$.*", hasSize(1))). // ensure 1 student matches
//                andExpect(jsonPath("$.[0].name").value("Jack")). // verify student name
//                andDo(print());
//    }
//
//}