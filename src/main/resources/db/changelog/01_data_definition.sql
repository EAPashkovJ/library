CREATE TABLE "users"(
                        "id" BIGINT NOT NULL,
                        "name" VARCHAR(255) NOT NULL,
                        "points" INTEGER NOT NULL,
                        "access_type_id" INTEGER NOT NULL,
                        "email" VARCHAR(255) NOT NULL,
                        "password" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "users" ADD PRIMARY KEY("id");
CREATE TABLE "books"(
                        "id" BIGINT NOT NULL,
                        "title" VARCHAR(255) NOT NULL,
                        "genre_id" INTEGER NOT NULL,
                        "description" TEXT NOT NULL,
                        "author_id" BIGINT NOT NULL,
                        "year" DATE NOT NULL,
                        "price" INTEGER NOT NULL
);
ALTER TABLE
    "books" ADD PRIMARY KEY("id");
CREATE TABLE "genre"(
                        "id" INTEGER NOT NULL,
                        "genre" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "genre" ADD PRIMARY KEY("id");
CREATE TABLE "orders_history"(
                                 "user_id" BIGINT NOT NULL,
                                 "book_id" BIGINT NOT NULL,
                                 "take_date" DATE NOT NULL,
                                 "return_date" DATE NOT NULL,
                                 "id" BIGINT NOT NULL
);
ALTER TABLE
    "orders_history" ADD PRIMARY KEY("id");
CREATE TABLE "access_type"(
                              "id" INTEGER NOT NULL,
                              "access" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "access_type" ADD PRIMARY KEY("id");
CREATE TABLE "authors"(
                          "id" BIGINT NOT NULL,
                          "author_name" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "authors" ADD PRIMARY KEY("id");
CREATE TABLE "library_trash_and_carry"(
                                          "id" BIGINT NOT NULL,
                                          "user_id" BIGINT NOT NULL,
                                          "date" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL
);
ALTER TABLE
    "library_trash_and_carry" ADD PRIMARY KEY("id");
ALTER TABLE
    "library_trash_and_carry" ADD CONSTRAINT "library_trash_and_carry_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "users"("id");
ALTER TABLE
    "books" ADD CONSTRAINT "books_genre_id_foreign" FOREIGN KEY("genre_id") REFERENCES "genre"("id");
ALTER TABLE
    "orders_history" ADD CONSTRAINT "orders_history_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "users"("id");
ALTER TABLE
    "orders_history" ADD CONSTRAINT "orders_history_book_id_foreign" FOREIGN KEY("book_id") REFERENCES "books"("id");
ALTER TABLE
    "users" ADD CONSTRAINT "users_access_type_id_foreign" FOREIGN KEY("access_type_id") REFERENCES "access_type"("id");
ALTER TABLE
    "books" ADD CONSTRAINT "books_author_id_foreign" FOREIGN KEY("author_id") REFERENCES "authors"("id");
