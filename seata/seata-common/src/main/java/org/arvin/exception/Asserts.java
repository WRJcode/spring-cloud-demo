package org.arvin.exception;

import org.arvin.api.IErrorCode;

public class Asserts {

    public static void fail(String message){
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode){
        throw new ApiException(errorCode);
    }
}
