SET SERVEROUTPUT ON;

BEGIN
  FOR loan_rec IN (
    SELECT l.loan_id, c.customer_name, l.due_date
    FROM loans l
    JOIN customers c ON l.customer_id = c.customer_id
    WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || loan_rec.loan_id || ' for ' ||
                         loan_rec.customer_name || ' is due on ' ||
                         TO_CHAR(loan_rec.due_date, 'DD-MON-YYYY'));
  END LOOP;
END;
/
