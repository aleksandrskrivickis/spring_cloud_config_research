--database - properties-service

CREATE TABLE `properties` (
  `application` varchar(200) DEFAULT NULL,
  `profile` varchar(200) DEFAULT NULL,
  `label` varchar(200) DEFAULT NULL,
  `key` varchar(200) DEFAULT NULL,
  `value` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1

INSERT INTO `properties` (`key`, `value`, `application`, `profile`, `label`)
VALUES ('user','{
      "max-connections": 1,
      "timeout-ms": 3600,
	  "json-data": {
		"title":"exampleglossary",
		"GlossDiv":{
		"title":"S",
		"GlossList":{
		"GlossEntry":{
		"ID":"SGML",
		"SortAs":"SGML",
		"GlossTerm":"StandardGeneralizedMarkupLanguage",
		"Acronym":"SGML",
		"Abbrev":"ISO8879:1986",
		"GlossDef":{
		"para":"Ameta-markuplanguage,usedtocreatemarkuplanguagessuchasDocBook.",
		"GlossSeeAlso":["GML","XML"]
		},
		"GlossSee":"markup"
		}
		}
		}
		}
    }','properties','production','latest');

-- CREATE TABLE `properties` (
--   `application` varchar(200) DEFAULT NULL,
--   `profile` varchar(200) DEFAULT NULL,
--   `label` varchar(200) DEFAULT NULL,
--   `key` varchar(200) DEFAULT NULL,
--   `value` varchar(200) DEFAULT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1

-- INSERT INTO `properties` (`key`, `value`, `application`, `profile`, `label`)
-- VALUES ('datasource-driver-class-name','MyDriverClass','appplication1','production','latest');

-- INSERT INTO `properties` (`key`, `value`, `application`, `profile`, `label`)
-- VALUES ('json-parameters','{
-- 		"title":"exampleglossary",
-- 		"GlossDiv":{
-- 		"title":"S",
-- 		"GlossList":{
-- 		"GlossEntry":{
-- 		"ID":"SGML",
-- 		"SortAs":"SGML",
-- 		"GlossTerm":"StandardGeneralizedMarkupLanguage",
-- 		"Acronym":"SGML",
-- 		"Abbrev":"ISO8879:1986",
-- 		"GlossDef":{
-- 		"para":"Ameta-markuplanguage,usedtocreatemarkuplanguagessuchasDocBook.",
-- 		"GlossSeeAlso":["GML","XML"]
-- 		},
-- 		"GlossSee":"markup"
-- 		}
-- 		}
-- 		}
-- 		}','appplication1','production','latest');

-- INSERT INTO `properties` (`key`, `value`, `application`, `profile`, `label`)
-- VALUES ('json-parameters','{
-- 		"title":"exampleglossary",
-- 		"GlossDiv":{
-- 		"title":"S",
-- 		"GlossList":{
-- 		"GlossEntry":{
-- 		"ID":"SGML",
-- 		"SortAs":"SGML",
-- 		"GlossTerm":"StandardGeneralizedMarkupLanguage",
-- 		"Acronym":"SGML",
-- 		"Abbrev":"ISO8879:1986",
-- 		"GlossDef":{
-- 		"para":"Ameta-markuplanguage,usedtocreatemarkuplanguagessuchasDocBook.",
-- 		"GlossSeeAlso":["GML","XML"]
-- 		},
-- 		"GlossSee":"markup"
-- 		}
-- 		}
-- 		}
-- 		}','properties','production','latest');

