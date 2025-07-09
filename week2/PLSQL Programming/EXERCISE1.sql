--Scenario 1
BEGIN
    FOR c IN (
        SELECT CustomerID, DOB 
        FROM Customers
    ) LOOP
        IF MONTHS_BETWEEN(SYSDATE, c.DOB)/12 > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = c.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;

--Scenario 2
ALTER TABLE Customers ADD IsVIP CHAR(1);

BEGIN
    FOR c IN (
        SELECT CustomerID, Balance 
        FROM Customers
    ) LOOP
        IF c.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = c.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;

--Scenario 3
DECLARE
    v_name VARCHAR2(100);
BEGIN
    FOR l IN (
        SELECT CustomerID, LoanID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        SELECT Name INTO v_name FROM Customers WHERE CustomerID = l.CustomerID;
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || l.LoanID || ' for customer ' || v_name || ' is due on ' || TO_CHAR(l.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;
