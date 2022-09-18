BEGIN TRANSACTION;

DROP TABLE IF EXISTS profile;
DROP SEQUENCE IF EXISTS seq_profile_id;

CREATE SEQUENCE seq_profile_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE profile (
	profile_id int DEFAULT nextval('seq_profile_id'::regclass) NOT NULL,
	username varchar(100) NOT NULL,
	url varchar(200) NOT NULL,
	profile_picture_file bit varying NOT NULL,
	is_secretary boolean NOT NULL,
	owners_url varchar(200),
	
	CONSTRAINT PK_profile PRIMARY KEY (profile_id)
);

INSERT INTO profile (username, url, profile_picture_file, is_secretary, owners_url) VALUES ('THE Twitter', 'www.twitter.com', 101, true, 'Elon Musk');
 
COMMIT TRANSACTION;
