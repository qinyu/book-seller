package info.qinyu.bookseller;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static info.qinyu.bookseller.Books.*;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookQueryController.class)
@Tag("api")
public class BookQueryAPITest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookRepository bookRepository;

    @Test
    public void should_return_book_by_query_book_name() throws Exception {
        given(bookRepository.findByName("Kotlin")).willReturn(singletonList(KIA));

        mockMvc.perform(get("/query?name=Kotlin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("@[0].name").value("Kotlin in Action"))
                .andExpect(jsonPath("@[0].price").value("89.00"))
                .andExpect(jsonPath("@[0].author").value("qinyu"));
        verify(bookRepository,only()).findByName("Kotlin");
    }
}
