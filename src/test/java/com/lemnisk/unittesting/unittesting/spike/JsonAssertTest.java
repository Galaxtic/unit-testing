package com.lemnisk.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.json.JsonContentAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void JsonAssert_StrictTrue() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void JsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\" }";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void JsonAssert_WithoutEscapeSequence() throws JSONException {
        String expectedResponse = "{id:1, name:Ball}";//Only time escape sequence is needed is when we have Spaces in our string.
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
