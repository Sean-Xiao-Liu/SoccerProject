ALTER TABLE Players
ADD CONSTRAINT players_teams_fk FOREIGN KEY ( team_id ) REFERENCES Teams ( id );
