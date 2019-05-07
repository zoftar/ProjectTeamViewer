insert into employee(id, name) values(1, "Tony Stark");
insert into employee(id, name) values(2, "Steve Rogers");
insert into employee(id, name) values(3, "Thor Odinson");
insert into employee(id, name) values(4, "Natasha Romanoff");
insert into employee(id, name) values(5, "Bruce Banner");
insert into employee(id, name) values(6, "Clint Barton");

insert into project(id, name, start_date, end_date) values (1, "Project 1", '2008-04-30', '2023-04-24');
insert into project(id, name, start_date, end_date) values (2, "Project 2", '2013-01-01', null);
insert into project (id, name, start_date, end_date) values (3, "Project 3",'2000-01-01', '2000-12-31');

insert into project_team_members values(1, 1);
insert into project_team_members values(1, 2);
insert into project_team_members values(1, 3);
insert into project_team_members values(2, 3);
insert into project_team_members values(2, 4);
insert into project_team_members values(3, 1);
insert into project_team_members values(3, 5);
insert into project_team_members values (3, 6);