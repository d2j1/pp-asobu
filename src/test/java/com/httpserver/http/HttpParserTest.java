package com.httpserver.http;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HttpParserTest {

    private static HttpParser parser;

    @BeforeAll
    public static void beforeClass(){
        parser = new HttpParser();
    }

   @Test
   public void parseHttpRequest() {
    }

    private InputStream generateValidTestCase(){}
    
}