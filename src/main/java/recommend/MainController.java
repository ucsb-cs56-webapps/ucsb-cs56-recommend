package recommend;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.Random;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.core.env.Environment;

import org.springframework.ui.Model;

import recommend.User;
import recommend.UserRepository;
import recommend.RecSongs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private Environment env;

	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;	//inject an repository instance
    private int id_counter = 1;

	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String song
			, @RequestParam String artist, @RequestParam String genre) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

        if(userRepository.existsBySong(song)) {
            return "UNSUCCESSFUL ADD";
        }

		User n = new User();
        id_counter = (int)(userRepository.count()) + 1;         //suppose to increment instead of using specific count each time, doing this because userRepository cant be called outside of functions for some reason????
        n.setID(id_counter);

        n.setSongName(song);
		n.setArtist(artist);
		n.setGenre(genre);
		userRepository.save(n);
		return "SUCCESSFUL ADD";
	}

    /*
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
    */

    @RequestMapping(path="/all")
    public String getAllUsers(Model model) {
        if (userRepository.count() == 0)
        {
            model.addAttribute("arrObj", null);
            return "playlist";
        }
        Iterable<User> users = userRepository.findAll();
        ArrayList<JSONObject> userList = new ArrayList<JSONObject>();
        for (User u : users)
        {
            JSONObject obj = new JSONObject();
            obj.put("song", u.getSongName());
            obj.put("artist", u.getArtist());
            obj.put("genre", u.getGenre());
            userList.add(obj);
        }
        String arr = "[";
        for(int i = 0; i < userList.size(); i++) {
            arr += userList.get(i).toString();
            if(i == userList.size() - 1) {
                arr+="]";
            } else {
                arr+=",";
            }
        }
        System.out.println(arr);
        model.addAttribute("arrObj", arr);
        return "playlist";
    }

    @RequestMapping(path="/clear") 
    public String clear() {
        
        id_counter = 1;
        userRepository.deleteAll();
        return "index";
        //userRepository.resetAutoInc();
    }


    @RequestMapping(path="/request")
    public String request(Model model) {
    	
    	//If there is no data in database, we will redirect to index.ftl
        if(userRepository.count() == 0) {
            model.addAttribute("arrObj", null);
            return "display";
        }
        
        //Retrieve a random song from our database
        int index = (int)(Math.random() * userRepository.count()) + 1;
        String songGenre = userRepository.findById(index).get().getGenre();


        //Pass random song to spotify api and retrieve an arrayList(3) of recommended songs
        String client_id = env.getProperty("spotify_client_id");
        
        String client_secret = env.getProperty("spotify_client_secret");
        /*
        for (int i=0; i<20; i++) {
            logger.info("--------------");
        }
        logger.info("cid: " + client_id + ", cs: " + client_secret);
        */
        RecSongs rc = new RecSongs(client_id, client_secret);
        ArrayList<JSONObject> arrList = rc.getSongs(songGenre.toLowerCase());

        //This part is test until we have api function to retrieve data
    	
    	
        //Constructs a string in javascript's array of JSONObject format
        //i.e. [{"id":1,"artist":"Michael Jackson","genre":"Pop","songName":"Billie Jean"},{"id":2,"artist":"Queen","genre":"Rock","songName":"Bohemian Rhapsody"}]
        String arr = "[";
        for(int i = 0; i < arrList.size(); i++) {
            arr += arrList.get(i).toString();
            if(i == arrList.size() - 1) {
                arr+="]";
            } else {
                arr+=",";
            }
        }
        

        //String arr = "[{\"id\":1,\"artist\":\"Michael Jackson\",\"genre\":\"Pop\",\"songName\":\"Billie Jean\"},{\"id\":2,\"artist\":\"Queen\",\"genre\":\"Rock\",\"songName\":\"Bohemian Rhapsody\"},{\"id\":3,\"artist\":\"Lorde\",\"genre\":\"pop\",\"songName\":\"somesongshesang\"}]";

        //Pass array of JSONObjects to display.ftl
        model.addAttribute("arrObj", arr);
    	

        //Redirect to display.ftl file
        return "display";
    	
    	
    }

}