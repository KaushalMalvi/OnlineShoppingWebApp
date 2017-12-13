create table category(

	id IDENTITY,
	name varchar(100),
	description varchar(255),
	img_Url varchar(100),
	active boolean,
	
	constraint pk_category_id primary key(id)
);