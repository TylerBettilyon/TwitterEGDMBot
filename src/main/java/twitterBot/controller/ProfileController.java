package twitterBot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twitterBot.dao.ProfileDao;

@RestController
@CrossOrigin
public class ProfileController {

    private ProfileDao profileDao;

    public ProfileController(ProfileDao profileDao) {this.profileDao = profileDao;}

    @GetMapping("/profiles")
    public ResponseEntity<?> getAllProfilesC() {
        return new ResponseEntity<>(profileDao.getAllProfiles(), HttpStatus.OK);
    }

    //How do I get the different profile information here?
    @PostMapping("/addprofile")
    public ResponseEntity<?> add(){

        //return new ResponseEntity<>(profileDao.addProfile(profile), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
