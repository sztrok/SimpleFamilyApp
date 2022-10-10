CREATE TABLE IF NOT EXISTS family(
    id serial PRIMARY KEY,
    family_name VARCHAR(50) NOT NULL,
    nr_of_adults integer,
    nr_of_children integer,
    nr_of_infants integer
);
CREATE TABLE IF NOT EXISTS family_member(
    id serial PRIMARY KEY,
    given_name VARCHAR(50) NOT NULL,
    family_id integer,
    family_name VARCHAR(50) NOT NULL,
    age integer
);

