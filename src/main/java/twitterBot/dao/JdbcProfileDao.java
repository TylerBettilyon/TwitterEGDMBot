package twitterBot.dao;

import twitterBot.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.io.File;
import java.util.BitSet;

public class JdbcProfileDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


//    public void addProfile(Profile profile) {
//        String sql = "INSERT INTO profile (username, url, profile_picture_file, is_secretary, owners_url) " +
//                "VALUES (?, ?, ?, ?, ?);";
//        jdbcTemplate.queryForObject(sql, int.class, profile.getUsername(), profile.getUrl(), profile.getProfilePictureFile(), profile.isSecretary(), profile.getOwnersUrl());
//    }
//
//    public void updateProfile(String username, Profile profile) {
//        String sql = "UPDATE profile" +
//                " SET username = ?, url = ?, profile_picture_file = ?, is_secretary = ?, owners_url = ? " +
//                " WHERE property_id = ?";
//        jdbcTemplate.update(sql, profile.getUsername(), profile.getUrl(), profile.getProfilePictureFile(), profile.isSecretary(), profile.getOwnersUrl());
//    }
    public Profile getProfileByProfilePictureFile(BitSet profilePictureFile) {

        String sql = "SELECT username, url, is_secretary, owners_url " +
                "FROM profile" +
                "WHERE profile_picture_base_64 = ?;";
        SqlRowSet rowset = jdbcTemplate.queryForRowSet(sql);
        Profile profile = new Profile();
        if(rowset.next()) {
            profile = mapRowToProfile(rowset);
        }

        return profile;
    }
    //delete

    private Profile mapRowToProfile (SqlRowSet rowSet) {
        Profile profile = new Profile();
        profile.setUsername(rowSet.getString("username"));
        profile.setUrl(rowSet.getString("url"));
        //I need a setter that allows me to take in a png and receive a binary stream and vice versa
        profile.setProfilePictureBase64(rowSet.getString("profile_picture_base_64"));
        profile.setSecretary(rowSet.getBoolean("is_secretary"));
        profile.setOwnersUrl(rowSet.getString("owners_url"));
        return profile;
    }




}
