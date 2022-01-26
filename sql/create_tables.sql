CREATE TABLE candidate
(
    candidate_id                    SERIAL PRIMARY KEY,
    candidate_first_name            varchar(80)   NOT NULL,
	candidate_middle_name           varchar(80)   NOT NULL,
	candidate_last_name             varchar(80)   NOT NULL,
    candidate_first_address         varchar(1024) NOT NULL,
	candidate_second_address        varchar(1024) NOT NULL,
	candidate_city                  varchar(1024) NOT NULL,
	candidate_state                 varchar(1024) NOT NULL,
	candidate_contry                varchar(1024) NOT NULL,
	candidate_zip                   varchar(1024) NOT NULL,
	candidate_email                 varchar(1024) NOT NULL,
	candidate_phone_number          varchar(1024) NOT NULL,
    candidate_github_url            varchar(1024) NOT NULL
);
CREATE TABLE degree
(
    degree_id                       SERIAL PRIMARY KEY,
    candidate_id                    integer       NOT NULL,
    degree_name                     varchar(80)   NOT NULL,
	degree_complete_date            varchar(80)   NOT NULL,
	degree_college_name             varchar(80)   NOT NULL,
    degree_college_address          varchar(1024) NOT NULL,
	degree_specialization           varchar(1024) NOT NULL
);

CREATE TABLE certification
(
    certification_id                SERIAL PRIMARY KEY,
    candidate_id                    integer       NOT NULL,
    certification_name              varchar(80)   NOT NULL,
	certification_complete_date     varchar(80)   NOT NULL,
	certification_institution_name  varchar(80)   NOT NULL
);

CREATE TABLE company
(
    company_id                  SERIAL PRIMARY KEY,
    company_name                varchar(1024)   NOT NULL,
	company_first_address       varchar(1024)   NOT NULL,
	company_second_address      varchar(1024)   NOT NULL,
	company_city                varchar(256)    NOT NULL,
	company_state               varchar(256)    NOT NULL,
	company_contry              varchar(128)    NOT NULL,
	company_zip                 varchar(64)     NOT NULL,
	company_email               varchar(1024)   NOT NULL,
	company_phone_number        varchar(64)     NOT NULL
);

CREATE TABLE job_profile
(
    job_profile_id                    SERIAL PRIMARY KEY,
    candidate_id                integer         NOT NULL,
	job_title                   varchar(1024)   NOT NULL,
	company_id                  integer         NOT NULL,
	job_start_date              date            NOT NULL,
	job_end_date                date                    ,
	job_duties                  text[1024]      NOT NULL,
	job_highlights              text[1024]      NOT NULL,
	current_job                 boolean
);

CREATE TABLE awards
(
    awards_id                SERIAL PRIMARY KEY,
    candidate_id             integer       NOT NULL,
    project_name             varchar(80)   NOT NULL,
    awards_name              varchar(80)   NOT NULL,
	awards_year              varchar(80)   NOT NULL,
	awards_institution_name  varchar(80)   NOT NULL
);

CREATE TABLE conference
(
    conference_id                SERIAL PRIMARY KEY,
    candidate_id                 integer       NOT NULL,
    role                         varchar(80)   NOT NULL,
    conference_year              varchar(80)   NOT NULL,
    topic                        varchar(80)   NOT NULL,
	conference_institution_name  varchar(80)   NOT NULL
);

CREATE TABLE open_source_contribution
(
    open_source_contribution_id                 SERIAL PRIMARY KEY,
    candidate_id                  integer       NOT NULL,
    issue                         varchar(1024) NOT NULL,
    product                       varchar(80)   NOT NULL,
    evidence_url                  varchar(80)   NOT NULL
);

CREATE TABLE headline
(
    headline_id                 SERIAL          PRIMARY KEY,
    candidate_id               integer          NOT NULL,
    headline                    text            NOT NULL
);

CREATE TABLE responsibilities
(
    responsibilities_id                 SERIAL          PRIMARY KEY,
    candidate_id                        integer         NOT NULL,
    responsibilities                    text[1024]      NOT NULL
);

CREATE TABLE tools
(
    tool_id          SERIAL          PRIMARY KEY,
    candidate_id     integer         NOT NULL,
    tool_type        varchar(1024)   NOT NULL,
    tools            varchar(1024)   NOT NULL
);