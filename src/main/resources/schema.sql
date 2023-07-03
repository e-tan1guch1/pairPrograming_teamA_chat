-- テーブル削除
DROP TABLE IF EXISTS chats;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS todos;
DROP TABLE IF EXISTS frends;

-- チャットテーブル
CREATE TABLE chats
(
   id SERIAL PRIMARY KEY,
   user_id INTEGER,
   text TEXT,
   address_id INTEGER,
   date TIMESTAMP
);
-- ユーザーテーブル
CREATE TABLE users
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   email TEXT,
   password TEXT
);
-- フレンドテーブル
CREATE TABLE frends
(
   id SERIAL PRIMARY KEY,
   user_id INTEGER,
   user2_id INTEGER
);
-- TODOテーブル
CREATE TABLE todos
(
   id SERIAL PRIMARY KEY,
   releaseDate TIMESTAMP,
   hour INTEGER,
   minute INTEGER,
   text TEXT,
    user_id INTEGER
);