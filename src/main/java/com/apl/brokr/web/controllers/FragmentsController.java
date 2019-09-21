package com.apl.brokr.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


    @Controller
    public class FragmentsController {

        @GetMapping("/header")
        public String getHeader() {
            return "header.html";
        }

        @GetMapping("/footer")
        public String getFooter() {
            return "footer.html";
        }

        @GetMapping("/layout")
        public String getLayout() {
            return "layout.html";
        }
    }


