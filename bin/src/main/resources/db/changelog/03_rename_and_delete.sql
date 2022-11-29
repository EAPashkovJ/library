ALTER TABLE public.library_trash_and_carry RENAME TO application_wallet;

ALTER TABLE application_wallet DROP COLUMN give_me_your_money;

ALTER TABLE application_wallet RENAME CONSTRAINT library_trash_and_carry_user_id_foreign TO application_wallet_user_id_foreign;

ALTER TABLE application_wallet RENAME CONSTRAINT library_trash_and_carry_pkey TO application_wallet_pkey;
