package unit.com.usercard.domain.user;

import com.usercard.domain.card.Card;
import com.usercard.domain.user.User;
import com.usercard.domain.user.UserRepository;
import com.usercard.domain.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    public void shouldCreateUser() {
        when(userRepository.save(any())).thenReturn(userSample());
        Long result = userService.create(userSample());
        assertThat(result).isEqualTo(1L);
    }

    @Test
    public void shouldGetUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userSample()));
        User result = userService.get(1L);
        assertThat(result.getName()).isEqualTo("name");
        assertThat(result.getPhoneNumber()).isEqualTo("phoneNumber");
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getCards().size()).isOne();
    }

    @Test
    public void shouldDeleteUser() {
        userService.delete(1L);
        verify(userRepository).deleteById(1L);
    }

    @Test
    public void shouldUpdateUser() {
        User updatedUser = userSample();
        updatedUser.setName("updatedName");
        when(userRepository.save(any())).thenReturn(updatedUser);
        User result = userService.update(updatedUser);
        assertThat(result.getName()).isEqualTo("updatedName");
        assertThat(result.getPhoneNumber()).isEqualTo("phoneNumber");
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getCards().size()).isOne();
    }

    public User userSample() {
        return User.builder()
            .id(1L)
            .name("name")
            .phoneNumber("phoneNumber")
            .cards(Collections.singletonList(Card.builder().build()))
            .build();
    }
}
