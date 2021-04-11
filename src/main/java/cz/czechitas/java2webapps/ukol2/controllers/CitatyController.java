package cz.czechitas.java2webapps.ukol2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class CitatyController {
    private final Random random = new Random();

    @GetMapping("/")
    public ModelAndView vyberCitat() {
        int cisloCitatu = random.nextInt(4);
        List<String> seznamCitatu = new ArrayList<String>();
        seznamCitatu.add("A user interface is like a joke. If you have to explain it, it's not that good.");
        seznamCitatu.add("To replace programmers with robots, clients will have to accurately describe what they want. We're safe.");
        seznamCitatu.add("99 little bugs in the code, 99 bugs in the code. Take one down, patch it around. 127 little bugs in the code...");
        seznamCitatu.add("When I wrote this code, only God & I understood what it did. Now… Only God knows.");

        int cisloObrazku = random.nextInt(4);
        String nazevObrazku;
        switch (cisloObrazku) {
            case 0:
                nazevObrazku = "auto";
                break;
            case 1:
                nazevObrazku = "duha";
                break;
            case 2:
                nazevObrazku = "lisabon";
                break;
            default:
                nazevObrazku = "ulice";
                break;
        }

        ModelAndView result = new ModelAndView("index");
        result.addObject("citat", seznamCitatu.get(cisloCitatu));
        result.addObject("obrazek", "background-image: url(images/" + nazevObrazku + ".jpg");
        return result;
    }

}