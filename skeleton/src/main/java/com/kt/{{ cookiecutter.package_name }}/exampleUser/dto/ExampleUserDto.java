package {{ cookiecutter.package_name }}.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExampleUserDto {
    @Schema(description = "사용자 ID")
    private Long id;

    @Schema(description = "사용자 이름")
    private String username;

    @Schema(description = "사용자 이메일")
    private String email;

    @Schema(description = "사용자 권한")
    private String role;

    @Schema(description = "생성일시")
    private LocalDateTime createdAt;

    @Schema(description = "수정일시")
    private LocalDateTime updatedAt;
}