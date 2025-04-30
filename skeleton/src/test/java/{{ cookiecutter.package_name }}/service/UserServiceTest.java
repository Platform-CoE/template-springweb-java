package {{ cookiecutter.package_name }}.service;

import {{ cookiecutter.package_name }}.dto.UserDto;
import {{ cookiecutter.package_name }}.mapper.UserMapper;
import {{ cookiecutter.package_name }}.model.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    private UserEntity testEntity;
    private UserDto testDto;

    @BeforeEach
    void setUp() {
        testEntity = new UserEntity();
        testEntity.setId(1L);
        testEntity.setUsername("testuser");
        testEntity.setEmail("test@example.com");
        testEntity.setRole("USER");
        testEntity.setEnabled(true);

        testDto = new UserDto();
        testDto.setId(1L);
        testDto.setUsername("testuser");
        testDto.setEmail("test@example.com");
        testDto.setRole("USER");
        testDto.setEnabled(true);
    }

    @Test
    void getUserById_정상_조회된다() {
        // Given
        when(userMapper.selectUserById(1L)).thenReturn(testEntity);

        // When
        UserDto result = userService.getUserById(1L);

        // Then
        assertNotNull(result);
        assertEquals(testDto.getId(), result.getId());
        assertEquals(testDto.getUsername(), result.getUsername());
        assertEquals(testDto.getEmail(), result.getEmail());
        assertEquals(testDto.getRole(), result.getRole());
        assertEquals(testDto.isEnabled(), result.isEnabled());
    }

    @Test
    void getAllUsers_정상_조회된다() {
        // Given
        List<UserEntity> entities = Arrays.asList(testEntity);
        when(userMapper.selectAllUsers()).thenReturn(entities);

        // When
        List<UserDto> results = userService.getAllUsers();

        // Then
        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals(testDto.getId(), results.get(0).getId());
    }

    @Test
    void createUser_정상_생성된다() {
        // Given
        when(userMapper.insertUser(any(UserEntity.class))).thenAnswer(invocation -> {
            UserEntity entity = invocation.getArgument(0);
            entity.setId(1L);
            return null;
        });

        // When
        Long id = userService.createUser(testDto);

        // Then
        assertNotNull(id);
        assertEquals(1L, id);
        verify(userMapper, times(1)).insertUser(any(UserEntity.class));
    }

    @Test
    void updateUser_정상_수정된다() {
        // Given
        doNothing().when(userMapper).updateUser(any(UserEntity.class));

        // When
        userService.updateUser(testDto);

        // Then
        verify(userMapper, times(1)).updateUser(any(UserEntity.class));
    }

    @Test
    void deleteUser_정상_삭제된다() {
        // Given
        doNothing().when(userMapper).deleteUser(anyLong());

        // When
        userService.deleteUser(1L);

        // Then
        verify(userMapper, times(1)).deleteUser(1L);
    }
} 