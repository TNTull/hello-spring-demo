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
                    "<form method = 'post'>" +
                    "<input type = 'text' name = 'name' />" +
                    "</br></br>" +
                    "<select name = 'language' id='lang'>" +
                    "<option value = 'French'>French</option>" +
                    "<option value = 'Spanish'>Spanish</option>" +
                    "<option value = 'German'>German</option>" +
                    "<option value = 'Italian'>Italian</option>" +
                    "<option value = 'Japanese'>Japanese</option>" +
                    "</select>" +
                    "</br></br>" +
                    "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                    "<input type = 'text' name = 'name' >" +
                    "<input type = 'submit' value = 'Greet Me!' >" +
                    "</form>" +
                    "</body>" +
                    "</html>";
        }

        //    Exercises
        @RequestMapping(method = RequestMethod.POST, value = "hello")
        public static String createMessage(@RequestParam String name, @RequestParam String language ) {
            if(name.equals("")){
                name = "World";
            }
            String greeting = "";

            if (language.equals("French")) {
                greeting =  "Bonjour, ";
            } else if (language.equals("Spanish")) {
                greeting = "Hola, ";
            } else if (language.equals("German")) {
                greeting = "Hallo, ";
            } else if (language.equals( "Italian")) {
                greeting = "Ciao, ";
            } else if (language.equals("Japanese")) {
                greeting = "Kon'nichiwa, ";
            }

            return greeting + name + "!";
        }

    }
