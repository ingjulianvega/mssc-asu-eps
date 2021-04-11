package ingjulianvega.ximic.eps.exception;

import lombok.Getter;

@Getter
public class EpsException extends RuntimeException {

    private final String code;

    public EpsException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

