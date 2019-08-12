-- Create tables for data of games, players and teams

CREATE TABLE Games
(
    id bigint  NOT NULL,
    home_team_id bigint,
    away_team_id bigint,
    home_goals smallint,
    home_losts smallint,
    home_match_result character varying(50),
    CONSTRAINT game_pkey PRIMARY KEY (id)
);

CREATE TABLE Players
(
    id bigint NOT NULL,
    team_id bigint NOT NULL,
    player_name character varying(50) ,
    age smallint,
    player_position character varying(50) ,
    nationality character varying(50) ,

    CONSTRAINT player_pkey PRIMARY KEY (id)
);

CREATE TABLE Teams
(

    team_name character varying(50) ,
    id bigint NOT NULL,
    home_win smallint,
    away_win smallint,
    home_loss smallint,
    away_loss smallint,
    CONSTRAINT team_pkey PRIMARY KEY (id)
);

