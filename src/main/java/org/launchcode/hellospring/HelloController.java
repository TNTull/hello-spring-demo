//Teresa Tull worked on this on 10-9-2022 ch 10 exercises

package org.launchcode.hellospring;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
   //public class HelloController {
//        return "Hello, Spring!";
//    }


        // lives at /hello/goodbye
        @GetMapping("goodbye")
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
        public String helloWithQueryParam(@RequestParam String name) {
            return "Hello, " + name + "!";
        }

        // Handles requests of the form /hello/LaunchCode
        @GetMapping("{name}")
        public String helloWithPathParam(@PathVariable String name) {
            return "Hello, " + name + "!";
        }

        // /hello/form
        @GetMapping("form")
        public String helloForm() {
            return "<html>" +
                    "<body>" +
                    "<form action = '/hello/hello' method = 'post'>" +
                    "<input type = 'text' name = 'name' />" +
                    "<select name = 'language' id='lang'>" +
                    "<option value = 'English'>English</option>" +
                    "<option value = 'French'>French</option>" +
                    "<option value = 'Spanish'>Spanish</option>" +
                    "<option value = 'German'>German</option>" +
                    "<option value = 'Italian'>Italian</option>" +
                    "<option value = 'Japanese'>Japanese</option>" +
                    "</select>" +
                    "<input type = 'submit' value = 'Greet Me!' >" +
                    "</form>" +
                    "</body>" +
                    "</html>";
        }

        //    Exercises


        @RequestMapping(method = RequestMethod.POST, value = "hello")
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
