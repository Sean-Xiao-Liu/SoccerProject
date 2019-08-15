ALTER TABLE Games
ADD CONSTRAINT games_home_teams_fk FOREIGN KEY ( home_team_id ) REFERENCES Teams ( id );

ALTER TABLE Games
ADD CONSTRAINT games_away_teams_fk FOREIGN KEY ( away_team_id ) REFERENCES Teams ( id );