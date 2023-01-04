package com.dangkang.domain.exception;

public class DataBaseException extends ApplicationException{

    public static final String ERR_DATABASE_CODE="D001";


    public DataBaseException(){
        setErrorCode(ERR_DATABASE_CODE);
    }
}
