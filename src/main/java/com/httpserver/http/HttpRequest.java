package com.httpserver.http;

public class HttpRequest extends HttpMessage{

    private HttpMethod method;
    private String requestTarget;
    private String httpVersion;


    public HttpRequest() {
    }

    public HttpMethod getMethod() {
        return method;
    }

    void setMethod (String methodName) throws HttpParsingException {
        for( HttpMethod method : HttpMethod.values()) {
            if(methodName.equals(method.name())) {
                this.method = method;
                return;
            }
        }
        throw new HttpParsingException( HttpStatusCode.SERVER_ERROR_501_METHOD_NOT_IMPLEMENTED);
    }
}
