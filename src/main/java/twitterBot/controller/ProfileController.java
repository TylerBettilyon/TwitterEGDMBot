package twitterBot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import twitterBot.dao.ProfileDao;

@RestController
@CrossOrigin
public class ProfileController {

    private ProfileDao profileDao;

    public ProfileController(ProfileDao profileDao) {this.profileDao = profileDao;}

    @GetMapping("/profiles")
    public ResponseEntity<?> getAvailable() {
        return new ResponseEntity<>(profileDao.getAllProfiles(), HttpStatus.OK);
    }

}
