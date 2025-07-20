-- Create tables for testing
CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(100),
    age NUMBER,
    balance NUMBER,
    IsVIP VARCHAR2(5)
);

CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    interest_rate NUMBER,
    due_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Sample data
INSERT INTO customers VALUES (1, 'Alice', 65, 12000, 'FALSE');
INSERT INTO customers VALUES (2, 'Bob', 45, 8000, 'FALSE');
INSERT INTO customers VALUES (3, 'Charlie', 70, 15000, 'FALSE');

INSERT INTO loans VALUES (101, 1, 5.0, SYSDATE + 20);
INSERT INTO loans VALUES (102, 2, 6.5, SYSDATE + 35);
INSERT INTO loans VALUES (103, 3, 7.0, SYSDATE + 10);

COMMIT;
