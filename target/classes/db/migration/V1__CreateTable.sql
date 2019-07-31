-- Create tables for data of matches, players and teams

CREATE TABLE Game
(
    matchid character varying(50)  NOT NULL,
    ishome character varying(50) NOT NULL,
    teamid character varying(50),
    goals numeric,
    losts numeric,
    matchresult character varying(50),
    shots numeric,
    shotsontarget numeric,
    fouls numeric,
    corner numeric,
    offsides numeric,
    yellowcard numeric,
    redcard numeric,
    formation character varying(50),
    passsuccessrate numeric,
    possessionpercentage numeric,
    passes numeric,
    averagepassstreak numeric,
    CONSTRAINT matches_pkey PRIMARY KEY (matchid, ishome)
);

CREATE TABLE Player
(
    playerid character varying(50) NOT NULL,
    teamid character varying(50) NOT NULL,
    playername character varying(50) ,
    age numeric,
    playerposition character varying(50) ,
    nationality character varying(50) ,
    height numeric,
    weight numeric,
    overallscore numeric,
    pace numeric,
    acceleration numeric,
    sprintspeed numeric,
    dribbling numeric,
    agility numeric,
    balance numeric,
    reactions numeric,
    ballcontrol numeric,
    composure numeric,
    shooting numeric,
    positioning numeric,
    finishing numeric,
    shotpower numeric,
    longshots numeric,
    volleys numeric,
    penalties numeric,
    passingability numeric,
    vision numeric,
    crossing numeric,
    freekick numeric,
    shortpass numeric,
    longpass numeric,
    passcurve numeric,
    defending numeric,
    interceptions numeric,
    heading numeric,
    marking numeric,
    standingtackle numeric,
    slidingtackle numeric,
    physicality numeric,
    jumping numeric,
    stamina numeric,
    strength numeric,
    aggression numeric,
    CONSTRAINT player_pkey PRIMARY KEY (playerid)
);

CREATE TABLE Team
(
    teamname character varying(50) ,
    teamid character varying(50) NOT NULL,
    homewin numeric,
    awaywin numeric,
    homeloss numeric,
    awayloss numeric,
    matcheswon numeric,
    matcheslost numeric,
    matchesdrawn numeric,
    totalmatches numeric,
    points numeric,
    finishposition numeric,
    homegoals numeric,
    awaygoals numeric,
    goalsscored numeric,
    goalsconceded numeric,
    goaldifference numeric,
    CONSTRAINT team_pkey PRIMARY KEY (teamid)
);

