INSERT INTO candidate (candidate_id,candidate_first_name,candidate_middle_name,candidate_last_name,candidate_first_address,candidate_second_address,candidate_city,candidate_state,candidate_contry,candidate_zip,candidate_email,candidate_phone_number,candidate_github_url)
VALUES (1,'Ankush','Ved Mitra','Pandit','8119 w 144th Pl','','Overland Park','Kansas','USA','66223','ankush.pandit@gmail.com','3156011859','https://github.com/iamankushpandit');

INSERT INTO degree (degree_id,candidate_id,degree_name,degree_complete_date,degree_college_name,degree_college_address,degree_specialization)
VALUES (1,1,'Master of Science in Computer Science','December 2009','State University of New York Institute of Technology','Utica, NY','Mobile Application Prototyping.');

INSERT INTO degree (degree_id,candidate_id,degree_name,degree_complete_date,degree_college_name,degree_college_address,degree_specialization)
VALUES (2,1,'Bachelor of Engineering in Computer Science','May 2007','Pandit Ravishankar Shukla University','Raipur, CG, India','Mobile Application Prototyping.');

INSERT INTO company (company_id,company_name,company_first_address,company_second_address,company_city,company_state,company_contry,company_zip,company_email,company_phone_number)
VALUES (1,'Cerner Corporation.','2800 Rock Creek Pkwy','','Kansas City','Missouri','USA','64117','N/A','+1-866-434-1543');

INSERT INTO company (company_id,company_name,company_first_address,company_second_address,company_city,company_state,company_contry,company_zip,company_email,company_phone_number)
VALUES (2,'Datacom Systems','9 Adler Drive','','East Syracuse','New York','USA','13057','N/A','+1 315 463 9541');

INSERT INTO job_profile
(
job_profile_id,
candidate_id,
job_title,
company_id,
job_start_date,
job_end_date,
job_duties,
job_highlights,
current_job
)
VALUES
(
1,
1,
'Associate Lead Software Engineer',
1,
'2021-02-01',
NULL,
'{
"System Level Design and implementation.",
"Advance troubleshooting of technical issues.",
"Automation of tests.",
"Spike existing and new solutions.",
"Leading efforts to modernize the development environment.",
"Collaboration with open source community to resolve issues.",
"Managing framework contribution work from outside the team.",
"Mentoring new associates internal and external to the team.",
"Developing methods for the team to achieve CI/CD.",
"Coordinating demonstration of developed components.",
"Knowledge transfer through talks within the team and at yearly conference.",
"Engineering Culture contributor through talk selecting and discussions.",
"Improving process and security for products inside and outside of the team.",
"Reduced the release time from Weeks to a few hours."
}',
'{
" "
}',
TRUE
);

INSERT INTO job_profile
(
job_profile_id,
candidate_id,
job_title,
company_id,
job_start_date,
job_end_date,
job_duties,
job_highlights,
current_job
)
VALUES
(
2,
1,
'Senior Software Engineer',
1,
'2016-08-01',
'2021-01-31',
'{
"Responsible for enhancements,Code analysis, implementation, debugging, documenting and unit testing medical image rendering, analyzing and manipulating software (Cerner SkyVue) for radiologist, cardiologist and health professionals to better assist patients.",
"Strategic technical designing of features used by Radiologist",
"Debug internal and client issues",
"Team code reviews, project estimations, automating software building pipelines",
"Building Monorepo, facilitating code version control strategies",
"Providing inputs to technical feasibility documentation",
"Mentoring new associates",
"Prototyping future projects",
"Presenting field related topics and technical conference observations to team."
}',
'{
" "
}',
FALSE
);

INSERT INTO job_profile
(
job_profile_id,
candidate_id,
job_title,
company_id,
job_start_date,
job_end_date,
job_duties,
job_highlights,
current_job
)
VALUES
(
3,
1,
'Software Engineer',
1,
'2013-12-01',
'2016-07-31',
'{
"Building system to analyze the Support org efficiencies and dead locks.",
"Investigating, debugging and documenting to resolve client issues in a timely manner.",
"Handling technical investigations and escalations following an investigation from a software analyst.",
"Identifying code defects/enhancements within Laboratory Admin Systems and Imaging Integration Systems for Cerner Applications.",
"Identification of code changes through investigation of service records, analysis of log files.",
"Examining client installed components while comparing with in-house implementation.",
"Debugging through front-end (.Net, Visual Basic and Java) code, middleware (C++, Java) and back-end (Oracle SQL Manager/CCL)",
"Discuss, propose resolutions of code defects with the development engineering team and raise appropriate change requests",
"Further generate documented workaround and notify analysts and clients detailing resolution of an issue.",
"Creating various diagnostic packages and RPRs to debug and resolve issues."
}',
'{
" "
}',
FALSE
);

INSERT INTO job_profile
(
job_profile_id,
candidate_id,
job_title,
company_id,
job_start_date,
job_end_date,
job_duties,
job_highlights,
current_job
)
VALUES
(
4,
1,
'Software Engineer',
2,
'2009-08-01',
'2013-11-30',
'{
"Worked on remote device management systems, developed & maintained Datacom API.",
"Responsible for development of various WindRiver Linux application projects.",
"Created various test and production tools.",
"Code version management and developer assistance.",
"Specific language interoperable programming in the area if C API to PHP-CGI.",
"Worked with Microsoft Office automation tools including sophisticated CVS file processing."
}',
'{
" "
}',
FALSE
);

INSERT INTO awards
(
awards_id,
candidate_id,
awards_name,
project_name,
awards_year,
awards_institution_name
)
VALUES
(
1,
1,
'People''s Choice Award.',
'Using Eggplant to test restful services.',
'2020',
'EggPlant'
);

INSERT INTO conference
(
conference_id,
candidate_id,
role,
conference_year,
topic,
conference_institution_name
)
VALUES
(
1,
1,
'Volunteer',
'2019',
'Badge Pickup',
'DevCon'
);

INSERT INTO conference
(
conference_id,
candidate_id,
role,
conference_year,
topic,
conference_institution_name
)
VALUES
(
2,
1,
'Talk Selection',
'DevCon',
'2020',
'CI/CD Track.'
);
INSERT INTO conference
(
conference_id,
candidate_id,
role,
conference_year,
topic,
conference_institution_name
)
VALUES
(
3,
1,
'Speaker',
'2020',
'Shift-Left Testing by Engineer.',
'DevCon'
);

INSERT INTO conference
(
conference_id,
candidate_id,
role,
conference_year,
topic,
conference_institution_name
)
VALUES
(
4,
1,
'Booth agent',
'2021',
'Community Engagement.',
'KCDC'
);

INSERT INTO open_source_contribution
(
open_source_contribution_id,
candidate_id,
issue,
product,
evidence_url
)
VALUES
(
1,
1,
'Eclipse Based Applications Crash when drag and dropping object with other applications.',
'Eclipse SDK 4.13',
'https://iamankushpandit.github.io/eclipseDnDIssue/'
);

INSERT INTO headline
(
headline_id,
candidate_id,
headline
)
VALUES
(
1,
1,
'Software Engineer IV (Associate Lead Software Engineer) with 12 year working experience with various development and support roles.'
);

INSERT INTO responsibilities
(
responsibilities_id,
candidate_id,
responsibilities
)
VALUES
(
1,
1,
'{
"Participating in the planning and scheduling of project tasks and major Service Record events.",
"Processing and performing assigned project task in an efficient manner.",
"Working closely with the upper management for planning, estimations, and troubleshooting.",
"Design and develop programming systems while making specific determination about system performance.",
"Responding promptly and professionally to bug and service reports.",
"Review, report, and repair legacy code.",
"Responsible for developing new tools and proofing the new applications to assure production of a quality product.",
"Document code consistently throughout the development process by listing a description of the program and special instructions.",
"Responsible for utilizing tools and equipment involved in performance of essential function of programming/debugging.",
"Research and recommend software tools to the development, quality assurance and support teams and management.",
"Aid in automation and quality assurance and support team as needed to determine system problems.",
"Review, to the extent possible, changes in code and environment that will affect system performance.",
"Interview new candidates for the company.",
"Mentoring new members of the team and company."
}'
);

INSERT INTO tools (tool_id,candidate_id,tool_type,tools)
VALUES (1,1,'Languages','Java, C, C++, .Net, PHP, Shell scripting, HTML, JSP, CSS, Java Script, Python and Eggplant(SenseTalk).');

INSERT INTO tools (tool_id,candidate_id,tool_type,tools)
VALUES (2,1,'Frameworks','OSGI, GRPC.');

INSERT INTO tools (tool_id,candidate_id,tool_type,tools)
VALUES (3,1,'Build tools','Maven, Jenkins and Gradle.');

INSERT INTO tools (tool_id,candidate_id,tool_type,tools)
VALUES (4,1,'IDLs','ProtoBuf.');

INSERT INTO tools (tool_id,candidate_id,tool_type,tools)
VALUES (5,1,'Platforms','Various Linux/Unix distributions, Windows family, WindRiver Linux, Red Hat Linux, VirtualBox.');

INSERT INTO tools (tool_id,candidate_id,tool_type,tools)
VALUES (6,1,'Databases','GDBM, LDAP (Active Directory).');

INSERT INTO tools (tool_id,candidate_id,tool_type,tools)
VALUES (7,1,'Web','Mongoose, IIS server, WAMP, Jetty.');

INSERT INTO tools (tool_id,candidate_id,tool_type,tools)
VALUES (8,1,'Documentation','Doxygen, FogBugz, Microsoft Office, Notepad++, Kdiff.');

INSERT INTO tools (tool_id,candidate_id,tool_type,tools)
VALUES (9,1,'Source Control','Github and SVN.');

INSERT INTO tools (tool_id,candidate_id,tool_type,tools)
VALUES (10,1,'Network','Wireshark, Putty, FileZilla, WinSCP.');

INSERT INTO tools (tool_id,candidate_id,tool_type,tools)
VALUES (11,1,'IDE','Eclipse, Visual Studio, NetBeans, WindRiver Workbench, QT Creator, InstallShield.');

INSERT INTO tools (tool_id,candidate_id,tool_type,tools)
VALUES (12,1,'SCA tools','SonarQube.');

INSERT INTO tools (tool_id,candidate_id,tool_type,tools)
VALUES (13,1,'Debug','BMC AppSight, Windbg, various Cerner’s in-house tools for code management.');

INSERT INTO certification
(
certification_id,
candidate_id,
certification_name,
certification_complete_date,
certification_institution_name
)
VALUES
(
2,
1,
'WindRiver Linux',
'June 2010',
'Wind River Vx Works'
);

INSERT INTO certification
(
certification_id,
candidate_id,
certification_name,
certification_complete_date,
certification_institution_name
)
VALUES
(
1,
1,
'RedHat Linux Essentials (RH003)',
'August 2010',
'RedHat'
);