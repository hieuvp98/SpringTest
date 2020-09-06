package com.itstudent.exception;

import javax.servlet.ServletException;

public class NotFoundException extends ServletException {

    public NotFoundException(String mess){
        super(mess);
    }
}
