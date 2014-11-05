CREATE USER IF NOT EXISTS SA SALT '0e8ab4cbddbd22b5' HASH 'cabc79feb2d9db71d40aabc401e0a1887a6ebc9f788748593494630dee5acb73' ADMIN;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_A8C48793_90A2_487F_8E20_60EE17E84387 START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_7B2D6AFA_DFC0_44B2_9210_35FE6F146002 START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_B299B692_EDC5_48E3_BE6A_FA11B4B7A9BA START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_A1CD1478_02E7_45C7_AFEF_0DC6C1B1DE20 START WITH 1 BELONGS_TO_TABLE;


CREATE CACHED TABLE PUBLIC.LOCATION(
    ZIP VARCHAR(255) NOT NULL,
    CITY VARCHAR(255),
    COUNTRY VARCHAR(255),
    REGION VARCHAR(255)
);
ALTER TABLE PUBLIC.LOCATION ADD CONSTRAINT PUBLIC.CONSTRAINT_9 PRIMARY KEY(ZIP);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.LOCATION;
CREATE CACHED TABLE PUBLIC.WEATHER(
    ID INTEGER DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_B299B692_EDC5_48E3_BE6A_FA11B4B7A9BA) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_B299B692_EDC5_48E3_BE6A_FA11B4B7A9BA,
    DATE TIMESTAMP,
    LOCATION_ZIP VARCHAR(255)
);
ALTER TABLE PUBLIC.WEATHER ADD CONSTRAINT PUBLIC.CONSTRAINT_73 PRIMARY KEY(ID);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.WEATHER;
CREATE CACHED TABLE PUBLIC.ATMOSPHERE(
    ID INTEGER DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_A1CD1478_02E7_45C7_AFEF_0DC6C1B1DE20) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_A1CD1478_02E7_45C7_AFEF_0DC6C1B1DE20,
    HUMIDITY VARCHAR(255),
    PRESSURE VARCHAR(255),
    RISING VARCHAR(255),
    VISIBILITY VARCHAR(255),
    WEATHER_ID INTEGER NOT NULL
);
ALTER TABLE PUBLIC.ATMOSPHERE ADD CONSTRAINT PUBLIC.CONSTRAINT_D PRIMARY KEY(ID);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.ATMOSPHERE;
CREATE CACHED TABLE PUBLIC.CONDITION(
    ID INTEGER DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_7B2D6AFA_DFC0_44B2_9210_35FE6F146002) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_7B2D6AFA_DFC0_44B2_9210_35FE6F146002,
    CODE VARCHAR(255),
    DATE VARCHAR(255),
    TEMP VARCHAR(255),
    TEXT VARCHAR(255),
    WEATHER_ID INTEGER NOT NULL
);
ALTER TABLE PUBLIC.CONDITION ADD CONSTRAINT PUBLIC.CONSTRAINT_7 PRIMARY KEY(ID);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.CONDITION;

CREATE CACHED TABLE PUBLIC.WIND(
    ID INTEGER DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_A8C48793_90A2_487F_8E20_60EE17E84387) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_A8C48793_90A2_487F_8E20_60EE17E84387,
    CHILL VARCHAR(255),
    DIRECTION VARCHAR(255),
    SPEED VARCHAR(255),
    WEATHER_ID INTEGER NOT NULL
);

ALTER TABLE PUBLIC.WIND ADD CONSTRAINT PUBLIC.CONSTRAINT_2 PRIMARY KEY(ID);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.WIND;

ALTER TABLE PUBLIC.WEATHER ADD CONSTRAINT PUBLIC.FKAC24CFD41D328C00 FOREIGN KEY(LOCATION_ZIP) REFERENCES PUBLIC.LOCATION(ZIP) NOCHECK;
ALTER TABLE PUBLIC.ATMOSPHERE ADD CONSTRAINT PUBLIC.FK2AF43942E377EE06 FOREIGN KEY(WEATHER_ID) REFERENCES PUBLIC.WEATHER(ID) NOCHECK;
ALTER TABLE PUBLIC.CONDITION ADD CONSTRAINT PUBLIC.FK441B8CFBE377EE06 FOREIGN KEY(WEATHER_ID) REFERENCES PUBLIC.WEATHER(ID) NOCHECK;
ALTER TABLE PUBLIC.WIND ADD CONSTRAINT PUBLIC.FK292428E377EE06 FOREIGN KEY(WEATHER_ID) REFERENCES PUBLIC.WEATHER(ID) NOCHECK;