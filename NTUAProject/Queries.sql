-CREATE TABLE ARTICLES(
ID serial PRIMARY KEY NOT NULL,
ARTICLEID text,
TITLE text,
AUTHORNAME text,
PUBLISHDATE date,
SITELINK text,
SEARCHINDEX integer
);

-INSERT INTO ARTICLES VALUES(DEFAULT,'1','test title','test authorname',to_date('01-01-1900','dd-mm-yyyy'),'test sitelink',1);



-CREATE TABLE METADATA(
ID serial PRIMARY KEY NOT NULL,
CORD_UID text,
TITLE text,
PMCID text,
ABSTRACT text,
PUBLISH_TIME text,
AUTHORS text,
url text
);

-CREATE TEMPORARY TABLE T
(cord_uid text,sha text,source_x text,title text,doi text,pmcid text,pubmed_id text,license text,abstract text,publish_time text,authors text,journal text,mag_id text,who_covidence_id text,arxiv_id text,pdf_json_files text,pmc_json_files text,url text,s2_id text);

-copy T (cord_uid ,sha ,source_x ,title ,doi ,pmcid ,pubmed_id ,license ,abstract,publish_time,authors ,journal ,mag_id ,who_covidence_id ,arxiv_id ,pdf_json_files ,pmc_json_files ,url ,s2_id)
from 'C:\metadata.csv'
with (format csv);

-INSERT INTO METADATA (cord_uid ,title ,pmcid  ,abstract,publish_time, authors, url)
select cord_uid ,title  ,pmcid  ,abstract,publish_time, authors, url
from t

-create or replace function varchar_to_date_or_null(str varchar)
returns date language plpgsql as $$
begin
    return to_date(str, 'YYYY-MM-DD');
exception
    when invalid_datetime_format then return null;
end $$;

-alter table metadata add new_publish_date date;

-update metadata
set new_publish_date = varchar_to_date_or_null(publish_time);


-drop table t

