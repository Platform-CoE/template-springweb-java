import java.util.List;
import com.kt.{{ cookiecutter.package_name }}.exampleUser.dto.ExampleUserDto;
import com.kt.{{ cookiecutter.package_name }}.exampleUser.dto.ExampleUserRegistrationRequestDto;

public interface ExampleUserService {
    public List<ExampleUserDto> findAll();
    public ExampleUserDto findById(Long id);
    public ExampleUserDto findByEmail(String email);
    public void register(ExampleUserRegistrationRequestDto request);
}