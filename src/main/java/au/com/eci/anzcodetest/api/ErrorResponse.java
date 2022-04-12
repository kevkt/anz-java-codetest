package au.com.eci.anzcodetest.api;

/**
 * Define the structure of the API error response.
 */
public class ErrorResponse {

    private String errorId;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(String errorId, String message) {
        this.errorId = errorId;
        this.message = message;
    }

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
