//Teresa Tull worked on this on 10-10-2022 ch 10
//and on 10-19-2022 ch 13

package org.launchcode.hellospring;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
   //public class HelloController {
//        return "Hello, Spring!";
//    }

        // lives at /hello/goodbye
        @GetMapping("goodbye")
        @ResponseBody
        public String goodbye() {
            return "Goodbye, Spring!";
        }

        //    // Handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }
        // Handles requests of the form /hello?name=LaunchCode
        @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
        @ResponseBody
        public String helloWithQueryParam(@RequestParam String name) {
            return "Hello, " + name + "!";
        }

        // Handles requests of the form /hello/LaunchCode
        @GetMapping("{name}")
        @ResponseBody
        public String helloWithPathParam(@PathVariable String name) {
            return "Hello, " + name + "!";
        }

        // /hello/form
        @GetMapping("form")
        public String helloForm() {
            return "form";
        }

        //    Exercises


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
