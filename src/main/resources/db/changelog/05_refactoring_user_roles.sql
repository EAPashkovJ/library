ALTER TABLE usrs DROP COLUMN "access_type_id";

ALTER TABLE access_type ADD COLUMN "user_id" BIGSERIAL NOT NULL;