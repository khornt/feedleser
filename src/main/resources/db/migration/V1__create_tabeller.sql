CREATE TABLE nyheter(

    tittel varchar(1000),
    link varchar(1000),
    id varchar(100),
    oppdatert varchar(100),
    summary varchar(32000),
    lagttil datetime,
    guid varchar(100)
);

CREATE TABLE sistlest(

    guid varchar(100),
    id int(11)

);