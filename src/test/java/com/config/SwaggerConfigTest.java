package com.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * The type Swagger config test.
 */
class SwaggerConfigTest {
    /**
     * Test api.
     */
    @Test
    void testApi() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        Docket actualApiResult = (new SwaggerConfig()).api();
        assertTrue(actualApiResult.isEnabled());
        assertEquals("default", actualApiResult.getGroupName());
    }
}

