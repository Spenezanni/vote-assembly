package domain.response;

import lombok.Data;

@Data
public class SessionAssemblyResponse {

    private String message;

    public SessionAssemblyResponse() {
    }
    public SessionAssemblyResponse(String message) {
        this.message = message;
    }
}
