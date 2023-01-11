package domain.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
@Data
public class SessionAssemblyRequest {
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime finalVote;

    public SessionAssemblyRequest() {
    }

    public SessionAssemblyRequest(LocalDateTime finalVote) {
        this.finalVote = finalVote;
    }
}
