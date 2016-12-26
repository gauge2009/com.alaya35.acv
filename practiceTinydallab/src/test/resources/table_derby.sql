--prompt PL/SQL Developer import file
--prompt Created on 2013年7月30日 by renhui
--set feedback off
--set define off
--First　delete　the　tables　if　they　exist.　
--Ignore　the　table　does　not　exist　error　if　present　
drop table CUSTOM;
--prompt Creating CUSTOM...
create table CUSTOM
(
  id int NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name   VARCHAR(32),
  age    int
);
