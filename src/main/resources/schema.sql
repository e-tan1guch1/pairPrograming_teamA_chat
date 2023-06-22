-- テーブル削除
DROP TABLE IF EXISTS chats;
DROP TABLE IF EXISTS users;

-- チャットテーブル
CREATE TABLE chats
(
   id SERIAL PRIMARY KEY,
   user_id Integer,
   text TEXT
);

-- ユーザーテーブル
CREATE TABLE users
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   email TEXT,
   password TEXT
);
