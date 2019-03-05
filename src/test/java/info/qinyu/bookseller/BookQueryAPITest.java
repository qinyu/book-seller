package info.qinyu.bookseller;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookQueryController.class)
public class BookQueryAPITest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_return_book_by_query_book_name() throws Exception {
        mockMvc.perform(get("/query?name=Kotlin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("@.name").value("Kotlin in Action"))
                .andExpect(jsonPath("@.price").value("89.00"))
                .andExpect(jsonPath("@.author").value("qinyu"));
    }
}
