package integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usercard.UserCardApp;
import com.usercard.domain.card.CardDto;
import com.usercard.domain.card.CardMapper;
import com.usercard.domain.card.CardRepository;
import com.usercard.domain.card.CardService;
import com.usercard.domain.user.UserDto;
import com.usercard.domain.user.UserMapper;
import com.usercard.domain.user.UserRepository;
import com.usercard.domain.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = {UserCardApp.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class UserControllerIT {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private CardService cardService;
    @MockBean
    private EntityManager entityManager;
    @MockBean
    private CardRepository cardRepository;
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCreateUser() throws Exception {
        mockMvc.perform(
            post("/v1/users")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .content(objectMapper.writeValueAsString(userDtoSample()))
        ).andExpect(status().isCreated());
    }

    @Test
    public void shouldCreateCard() {

    }

    @Test
    public void shouldNotCreateCardUserNotFound() {

    }

    public UserDto userDtoSample() {
        return UserDto.builder()
            .name("name")
            .phoneNumber("phoneNumber")
            .id(1L)
            .cards(Collections.singletonList(CardDto.builder().build()))
            .build();
    }
}
