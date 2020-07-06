BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "android_metadata" (
	"locale"	TEXT
);
CREATE TABLE IF NOT EXISTS "events" (
	"_id"	integer,
	"uuid"	INTEGER,
	"title"	TEXT,
	"info"	TEXT,
	"date"	TEXT,
	"actual"	TEXT,
	PRIMARY KEY("_id" AUTOINCREMENT)
);
INSERT INTO "android_metadata" VALUES ('en_US');
INSERT INTO "events" VALUES (1,123,'Актуальное событие 1','Это событие','detailedInfooo','yes');
INSERT INTO "events" VALUES (2,124,'Актуальное событие 2','Это событие','detailedInfooo','yes');
INSERT INTO "events" VALUES (3,125,'Актуальное событие 3','Это событие','detailedInfooo','yes');
INSERT INTO "events" VALUES (4,126,'Актуальное событие 4','Это событие','detailedInfooo','yes');
COMMIT;
