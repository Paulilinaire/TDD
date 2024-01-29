package org.example.exceptions;

import java.io.Serializable;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("non trouvé !!!");
    }
}
