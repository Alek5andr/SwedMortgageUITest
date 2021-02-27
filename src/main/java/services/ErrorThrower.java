package services;

public class ErrorThrower {
    public void throwIllegalArgumentError(String message) {
        throw new IllegalArgumentException(message);
    }
}
