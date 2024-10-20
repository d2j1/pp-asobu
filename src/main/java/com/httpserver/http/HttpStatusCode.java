package com.httpserver.http;

public enum HttpStatusCode {

//    Client errors
    CLIENT_ERROR_400_BAD_REQUEST(400, "Bad Request"),
    CLIENT_ERROR_401_METHOD_NOT_ALLOWED(401, "Method Not Allowed"),
    CLIENT_ERROR_400_URI_TOO_LONG(414, "URI Too Long"),

//    Server Errors
    SERVER_ERROR_506_INTERNAL_SERVER_ERROR(506, "Internal Server Error"),
    SERVER_ERROR_501_METHOD_NOT_IMPLEMENTED(501, "Method Not Implemented");


    public final int STATUS_CODE;
    public final String MESSAGE;

    private HttpStatusCode(int statusCode, String message) {
        this.STATUS_CODE = statusCode;
        this.MESSAGE = message;
    }

}
