package com.application.cloudbox.Controller;

import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.application.cloudbox.LambdaRequestHandler;
import com.mongodb.assertions.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {

    @GetMapping("test")
    public static String test(
            @RequestParam(value = "name", required = false, defaultValue = "") String name
    ) {
        return "Server UP, Hello " + name;
    }
}
