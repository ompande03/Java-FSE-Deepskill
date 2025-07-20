CREATE OR REPLACE PROCEDURE TransferFunds (
  p_source_account IN NUMBER,
  p_target_account IN NUMBER,
  p_amount IN NUMBER
) IS
  v_source_balance NUMBER;
BEGIN
  SELECT balance INTO v_source_balance FROM accounts WHERE account_id = p_source_account;

  IF v_source_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account');
  ELSE
    UPDATE accounts SET balance = balance - p_amount WHERE account_id = p_source_account;
    UPDATE accounts SET balance = balance + p_amount WHERE account_id = p_target_account;
    COMMIT;
  END IF;
END;
/
