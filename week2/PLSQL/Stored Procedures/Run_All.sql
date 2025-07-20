-- Run all stored procedure scripts
@01_ProcessMonthlyInterest.sql
@02_UpdateEmployeeBonus.sql
@03_TransferFunds.sql

-- Execute procedures with example parameters

BEGIN
  ProcessMonthlyInterest;
END;
/

BEGIN
  UpdateEmployeeBonus(p_department_id => 10, p_bonus_percent => 5);
END;
/

BEGIN
  TransferFunds(p_source_account => 101, p_target_account => 102, p_amount => 500);
END;
/
