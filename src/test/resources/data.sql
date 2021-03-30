DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id bigint NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  department VARCHAR(250) DEFAULT NULL,
  email VARCHAR(250) DEFAULT NULL,
  address VARCHAR(250) DEFAULT NULL
);

INSERT INTO employee (id, first_name, last_name, department,email,address) VALUES (1001, 'Fathi', 'As','Java','fa@gmail.com','MY');
INSERT INTO employee (id, first_name, last_name, department,email,address) VALUES (1002, 'Ahm', 'Mans','Java-Spring','ah@gmail.com','MY');
INSERT INTO employee (id, first_name, last_name, department,email,address) VALUES (1003, 'moh', 'rims','Java-SpringBoot','tim@gmail.com','MY');
