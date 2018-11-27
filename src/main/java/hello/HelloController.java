
package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

//This class is flagged as a @RestController
//This means the class "HelloController" can be used by Spring MVC to handle web requests
@RestController
public class HelloController {

	//@RequestMapping will map "/" to the index method??
	@RequestMapping("/")
    public String index() {
        return "Changing up the index here";
    }

	//HelloController is able to return text thanks to @RestController
	//IF it is invoked by a broswer or through curl in cmd
	//@RestController is actually @Controller and @ResponseBody combined
	//They allow web requests to return data (instead of view??)

}
