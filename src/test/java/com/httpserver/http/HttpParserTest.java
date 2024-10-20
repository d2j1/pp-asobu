package com.httpserver.http;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HttpParserTest {

    private static HttpParser parser;

    @BeforeAll
    public static void beforeClass(){
        parser = new HttpParser();
    }

   @Test
   public void parseHttpRequest() {

       HttpRequest request  = null;

       request =parser.parseHttpRequest(generateValidTestCase());

       assertEquals(request.getMethod(), HttpMethod.GET);
    }

    private InputStream generateValidTestCase(){
        String raw = "GET / HTTP/1.1\r\n" +
                "Host: localhost:3000\r\n" +
                "Connection: keep-alive\r\n" +
                "sec-ch-ua: \"Not)A;Brand\";v=\"99\", \"Google Chrome\";v=\"127\", \"Chromium\";v=\"127\"\r\n" +
                "sec-ch-ua-mobile: ?0\r\n" +
                "sec-ch-ua-platform: \"Windows\"\r\n" +
                "DNT: 1\r\n" +
                "Upgrade-Insecure-Requests: 1\r\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36\r\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7\r\n" +
                "Sec-Fetch-Site: none\r\n" +
                "Sec-Fetch-Mode: navigate\r\n" +
                "Sec-Fetch-User: ?1\r\n" +
                "Sec-Fetch-Dest: document\r\n" +
                "Accept-Encoding: gzip, deflate, br, zstd\r\n" +
                "Accept-Language: en-IN,en-GB;q=0.9,en-US;q=0.8,en;q=0.7,mr;q=0.6"
                + "\r\n";

        InputStream stream = new ByteArrayInputStream(raw.getBytes(StandardCharsets.US_ASCII));

        return stream;
    }

    @Test
    public void parseHttpRequestBadMethod1() {
        HttpRequest request =parser.parseHttpRequest(generateBadTestCaseMethodName1());

    }



    private InputStream generateBadTestCaseMethodName1(){
        String raw = "GeT / HTTP/1.1\r\n" +
                "Host: localhost:3000\r\n" +
                "Connection: keep-alive\r\n" +
                "sec-ch-ua: \"Not)A;Brand\";v=\"99\", \"Google Chrome\";v=\"127\", \"Chromium\";v=\"127\"\r\n" +
                "sec-ch-ua-mobile: ?0\r\n" +
                "sec-ch-ua-platform: \"Windows\"\r\n" +
                "DNT: 1\r\n" +
                "Upgrade-Insecure-Requests: 1\r\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36\r\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7\r\n" +
                "Sec-Fetch-Site: none\r\n" +
                "Sec-Fetch-Mode: navigate\r\n" +
                "Sec-Fetch-User: ?1\r\n" +
                "Sec-Fetch-Dest: document\r\n" +
                "Accept-Encoding: gzip, deflate, br, zstd\r\n" +
                "Accept-Language: en-IN,en-GB;q=0.9,en-US;q=0.8,en;q=0.7,mr;q=0.6"
                + "\r\n";

        InputStream stream = new ByteArrayInputStream(raw.getBytes(StandardCharsets.US_ASCII));

        return stream;
    }

    private InputStream generateBadTestCaseMethodName2(){
        String raw = "GETTTTER / HTTP/1.1\r\n" +
                "Host: localhost:3000\r\n" +
                "Connection: keep-alive\r\n" +
                "sec-ch-ua: \"Not)A;Brand\";v=\"99\", \"Google Chrome\";v=\"127\", \"Chromium\";v=\"127\"\r\n" +
                "sec-ch-ua-mobile: ?0\r\n" +
                "sec-ch-ua-platform: \"Windows\"\r\n" +
                "DNT: 1\r\n" +
                "Upgrade-Insecure-Requests: 1\r\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36\r\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7\r\n" +
                "Sec-Fetch-Site: none\r\n" +
                "Sec-Fetch-Mode: navigate\r\n" +
                "Sec-Fetch-User: ?1\r\n" +
                "Sec-Fetch-Dest: document\r\n" +
                "Accept-Encoding: gzip, deflate, br, zstd\r\n" +
                "Accept-Language: en-IN,en-GB;q=0.9,en-US;q=0.8,en;q=0.7,mr;q=0.6"
                + "\r\n";

        InputStream stream = new ByteArrayInputStream(raw.getBytes(StandardCharsets.US_ASCII));

        return stream;
    }
    @Test
    public void parseHttpRequestBadMethod2() {
        HttpRequest request =parser.parseHttpRequest(generateBadTestCaseMethodName2());

    }


    private InputStream generateBadTestCaseRequestLineInvalidNoOfItems(){
        String raw = "GETTTTER / Mokaliititit HTTP/1.1\r\n" +
                "Host: localhost:3000\r\n" +
                "Connection: keep-alive\r\n" +
                "sec-ch-ua: \"Not)A;Brand\";v=\"99\", \"Google Chrome\";v=\"127\", \"Chromium\";v=\"127\"\r\n" +
                "sec-ch-ua-mobile: ?0\r\n" +
                "sec-ch-ua-platform: \"Windows\"\r\n" +
                "DNT: 1\r\n" +
                "Upgrade-Insecure-Requests: 1\r\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36\r\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7\r\n" +
                "Sec-Fetch-Site: none\r\n" +
                "Sec-Fetch-Mode: navigate\r\n" +
                "Sec-Fetch-User: ?1\r\n" +
                "Sec-Fetch-Dest: document\r\n" +
                "Accept-Encoding: gzip, deflate, br, zstd\r\n" +
                "Accept-Language: en-IN,en-GB;q=0.9,en-US;q=0.8,en;q=0.7,mr;q=0.6"
                + "\r\n";

        InputStream stream = new ByteArrayInputStream(raw.getBytes(StandardCharsets.US_ASCII));

        return stream;
    }

    @Test
    public void parseHttpRequestReqLineInvNum() {
        HttpRequest request =parser.parseHttpRequest(generateBadTestCaseRequestLineInvalidNoOfItems());

    }

}