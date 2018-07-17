package com.temporary.helix.exception;

/**
 * This file is part of Helix
 * Creation date: 7/17/2018
 * Created by: Dylan 'Dutchy' de Beer
 */

public class ModuleException extends Exception {
    public ModuleException() {
        super();
    }
    public ModuleException(String message) {
        super(message);
    }
    public ModuleException(String message, Throwable cause) {
        super(message, cause);
    }
    public ModuleException(Throwable cause) {
        super(cause);
    }
}
