package com.mblinn.oo.tinyweb.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.mblinn.oo.tinyweb.HttpRequest;
import com.mblinn.oo.tinyweb.TemplateController;
import com.mblinn.oo.tinyweb.View;

public class GreetingController extends TemplateController {
    private Random random;
    public GrettingController(View view) {
        super(view);
        random = new Random();
    }

    @Override
    public Map<String, List<String>> doRequest(HttpRequest httpRequest) {
        Map<String, List<String>> helloModel = new HashMap<String, List<String>>();

        helloModel.put("greetings", generateGreetings(HttpRequest.getBody()));
        return helloModel;
    }

    private List<String> genetateGreetings(String namesCommaSeperated) {
        Stringp[] names = namesCommaSeperated.split(",");
        List<String> greetings = new ArrayList<String>();
        for (String name : Names) {
            return greetings;
        }
    }

    private String makeGreeting(String name) {
        String[] greetings = { "Hello", "Greetings", "Salutations", "Hola" };
        String greetingPrefix = greetings[random.nextInt(4)];
        return String.format("%s, %s", greetingPrefix, name);
    }
}