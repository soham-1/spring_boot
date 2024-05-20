use advancejpademo;

drop table if exists student_details;
drop table if exists student;
drop table if exists instructor;
drop table if exists course;
drop table if exists course_student;

create table student (
	id int not null auto_increment,
    first_name varchar(50) not null,
	constraint pk_id primary key(id)
);


create table student_details (
	student_id int not null,
    age int not null,
    constraint fk_studentId foreign key (student_id) references student(id)
);

create table instructor (
	instructor_id int auto_increment,
    first_name varchar(50),
    constraint pk_instructor_id primary key(instructor_id)
);
create table course (
	course_id int not null auto_increment,
    course_name varchar(50) not null,
    instructor_id int not null,
	constraint pk_course_id primary key(course_id),
    constraint fk_instructor_id foreign key (instructor_id) references instructor(instructor_id)
);

create table course_student (
	course_id int not null,
    student_id int not null,
    constraint fk_course_id foreign key (course_id) references course(course_id),
    constraint fk_student_id foreign key (student_id) references student(id)
);