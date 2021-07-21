package unit.com.usercard.domain.user;

import com.usercard.domain.card.Card;
import com.usercard.domain.card.CardDto;
import com.usercard.domain.card.CardMapper;
import com.usercard.domain.user.User;
import com.usercard.domain.user.UserDto;
import com.usercard.domain.user.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserMapperTest {
    @Mock
    private CardMapper cardMapper;
    @InjectMocks
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void shouldMapUserToUserDto() {
        when(cardMapper.toDto(any())).thenReturn(cardDtoSample());
        UserDto result = userMapper.toDto(userSample());
        assertThat(result.getName()).isEqualTo("name");
        assertThat(result.getPhoneNumber()).isEqualTo("phoneNumber");
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getCards().size()).isOne();
    }

    public User userSample() {
        return User.builder()
            .name("name")
            .phoneNumber("phoneNumber")
            .id(1L)
            .cards(Collections.singletonList(Card.builder().build()))
            .build();
    }

    public CardDto cardDtoSample() {
        return CardDto.builder().build();
    }
}