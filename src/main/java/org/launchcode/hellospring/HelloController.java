//Teresa Tull worked on this on 10-10-2022 ch 10
//and on 10-19-2022 ch 13

package org.launchcode.hellospring;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("hello")
//lives at /hello
public class HelloController {

     // Handle request at path /hello (ch 10)
   //public class HelloController {
//        return "Hello, Spring!";
//    }

        // lives at /hello/goodbye (ch 10)
        @GetMapping("goodbye")
        @ResponseBody
        public String goodbye() {
            return "Goodbye, Spring!";
        }

        //    // Handles requests of the form /hello?name=LaunchCode (ch 10)
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }
        // Handles requests of the form /hello?name=LaunchCode (ch 10)
//        @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//        @ResponseBody
//        public String helloWithQueryParam(@RequestParam String name) {
//            return "Hello, " + name + "!";
//        }

        // Handles requests of the form /hello/LaunchCode (ch 10)
//        @GetMapping("{name}")
//        @ResponseBody
//        public String helloWithPathParam(@PathVariable String name) {
//            return "Hello, " + name + "!";
//        }

//    // /hello/form (ch 10)
//    @GetMapping("form")
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action = '/hello/hello' method = 'post'>" +
//                "<input type = 'text' name = 'name' />" +
//                "<select name = 'language' id='lang'>" +
//                "<option value = 'English'>English</option>" +
//                "<option value = 'French'>French</option>" +
//                "<option value = 'Spanish'>Spanish</option>" +
//                "<option value = 'German'>German</option>" +
//                "<option value = 'Italian'>Italian</option>" +
//                "<option value = 'Japanese'>Japanese</option>" +
//                "</select>" +
//                "<input type = 'submit' value = 'Greet Me!' >" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    // /hello/form using Thymeleaf form
    // ch 13
        @GetMapping("form")
        public String helloForm() {
            return "form";
        }
    // Handles requests of the form /hello?name=LaunchCode using Thymeleaf hello
    // ch 13
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithThymeleaf(@RequestParam String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
            return "hello";
    }

    // Handles requests of the form /hello/LaunchCode using Thymeleaf hello
    // ch 13
    // can do like code above or not use variable theGreeting as below
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    // Handles requests of the form /hello-names using Thymeleaf hello
    // ch 13
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

    //    Exercises (ch 10)
        @RequestMapping(method = RequestMethod.POST, value = "hello")
        @ResponseBody
        public String helloPost(@RequestParam String name, @RequestParam String language) {
            if (name == null) {
                name = "World";
            }
            return createMessage(name, language);
        }
        public static String createMessage(String n, String l) {
            String greeting = "";

            if (l.equals("English")) {
                greeting =  "Hello, ";
            } else if (l.equals("French")) {
                    greeting =  "Bonjour, ";
            } else if (l.equals("Spanish")) {
                greeting = "Hola, ";
            } else if (l.equals("German")) {
                greeting = "Hallo, ";
            } else if (l.equals( "Italian")) {
                greeting = "Ciao, ";
            } else if (l.equals("Japanese")) {
                greeting = "Kon'nichiwa, ";
            }

            return greeting + n + "!";
        }

    }
