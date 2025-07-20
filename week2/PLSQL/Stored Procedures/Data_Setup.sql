-- Create tables (simplified example)

CREATE TABLE savings_accounts (
  account_id NUMBER PRIMARY KEY,
  customer_id NUMBER,
  balance NUMBER
);

CREATE TABLE employees (
  employee_id NUMBER PRIMARY KEY,
  department_id NUMBER,
  salary NUMBER
);

CREATE TABLE accounts (
  account_id NUMBER PRIMARY KEY,
  customer_id NUMBER,
  balance NUMBER
);

-- Insert sample data

INSERT INTO savings_accounts VALUES (1, 101, 1000);
INSERT INTO savings_accounts VALUES (2, 102, 2000);

INSERT INTO employees VALUES (1, 10, 50000);
INSERT INTO employees VALUES (2, 20, 60000);

INSERT INTO accounts VALUES (101, 1001, 3000);
INSERT INTO accounts VALUES (102, 1002, 1500);

COMMIT;
